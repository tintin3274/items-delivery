package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/items-delivery/cancel_order")
public class CancelOrderController {
    private OrderRequestService orderRequestService;

    public CancelOrderController(OrderRequestService orderRequestService) {
        this.orderRequestService = orderRequestService;
    }

    @GetMapping
    public String getHomePage(Model model){
        ArrayList<OrderRequest> currentOrdersList = new ArrayList<>();
        DateTimeAdapter dateTimeAdapter =new DateTimeAdapter();
        List<OrderRequest> pendingOrderList = orderRequestService.getOrderRequestStatusAll("PENDING");
        HashMap<Integer, Boolean> checkOrder = orderRequestService.pendingCheckOrderRequestItemAll();
        for(OrderRequest orderRequest : pendingOrderList){
            if(checkOrder.get(orderRequest.getId()))
                orderRequest.setStatus("PENDING - READY");
            else
                orderRequest.setStatus("PENDING - NOT READY");
        }

        currentOrdersList.addAll(pendingOrderList);
        currentOrdersList.addAll(orderRequestService.getOrderRequestStatusAll("PROGRESS"));
        model.addAttribute("allOrders",currentOrdersList);
        model.addAttribute("dateTimeAdapter",dateTimeAdapter);
        return "commit_order";
    }

    @GetMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable int id){
        orderRequestService.cancelOrderRequest(id);
        return "redirect:/items-delivery/cancel_order";
    }

//    @GetMapping("/commit/{id}")
//    public String commitOrder(@PathVariable int id){
//        switch (orderRequestService.getOrderRequest(id).getStatus()){
//            case "PENDING": orderRequestService.progressOrderRequest(id); break;
//            case "PROGRESS": orderRequestService.successOrderRequest(id); break;
//            default:
//        }
//
//        return "redirect:/items-delivery/commit_order";
//    }
}
