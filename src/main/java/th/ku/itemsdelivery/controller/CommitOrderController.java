package th.ku.itemsdelivery.controller;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping({"/items-delivery/home", "/items-delivery"})
public class CommitOrderController {
    private OrderRequestService orderRequestService;

    private AuthenticationService authenticationService;

    public CommitOrderController(OrderRequestService orderRequestService, AuthenticationService authenticationService) {
        this.orderRequestService = orderRequestService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getHomePage(Model model){
        if (authenticationService.getStaffCurrentLogin() == null){
            //System.err.println(authenticationService.getStaffCurrentLogin().toString());
            return "redirect:/items-delivery/login";
        }

        ArrayList<OrderRequest> currentOrdersList = new ArrayList<>();
        DateTimeAdapter dateTimeAdapter =new DateTimeAdapter();
        List<OrderRequest> pendingOrderList = orderRequestService.getOrderRequestStatusAll("PENDING");
        HashMap<Integer, Boolean> checkOrder = orderRequestService.pendingCheckOrderRequestItemAll();
        HashMap<Integer, Long> timeLeftMap = new HashMap<>();
        for(OrderRequest orderRequest : pendingOrderList){
            if(checkOrder.get(orderRequest.getId()))
                orderRequest.setStatus("PENDING - READY");
            else
                orderRequest.setStatus("PENDING - NOT READY");
        }

        currentOrdersList.addAll(pendingOrderList);
        currentOrdersList.addAll(orderRequestService.getOrderRequestStatusAll("PROGRESS"));

        for(OrderRequest orderRequest : currentOrdersList){
            timeLeftMap.put(orderRequest.getId(), Duration.between(LocalDateTime.now(), orderRequest.getDueDatetime()).toDays());
        }

//        for (int key : timeLeftMap.keySet()){
//            System.err.println("This is order id" + key);
//            System.err.println(timeLeftMap.get(key));
//        }

        model.addAttribute("allOrders",currentOrdersList);
        model.addAttribute("timeLeft", timeLeftMap);
        model.addAttribute("dateTimeAdapter",dateTimeAdapter);
        return "home";
    }

    @GetMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable int id){
        orderRequestService.cancelOrderRequest(id);
        return "redirect:/items-delivery/home";
    }

    @GetMapping("/commit/{id}")
    public String commitOrder(@PathVariable int id){
        switch (orderRequestService.getOrderRequest(id).getStatus()){
            case "PENDING": orderRequestService.progressOrderRequest(id); break;
            case "PROGRESS": orderRequestService.successOrderRequest(id); break;
            default:
        }

        return "redirect:/items-delivery/home";
    }


}
