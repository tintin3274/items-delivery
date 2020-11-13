package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private OrderRequestService orderRequestService;

    public HomeController(OrderRequestService orderRequestService){
        this.orderRequestService = orderRequestService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("allOrders",orderRequestService.getOrderRequestStatusAll("PENDING").addAll(orderRequestService.getOrderRequestStatusAll("PROGESS")));
        return "home";
    }

//    @PostMapping
//    public String showStatus(Model model) {
//        List<OrderRequest> ordersPendinglist = new ArrayList<OrderRequest>();
//        for(OrderRequest order : orderRequestService.getOrders())
//            if(orderRequestService.checkStatus(order) = "PENDING")
//                ordersPendinglist.add(order);
//        model.addAttribute("allOrders", ordersPendinglist);
//        return "redirect:home";
//    }

//    @PostMapping
//    public String registerCustomer(@ModelAttribute OrderRequest orderRequest, Model model) {
//        model.addAttribute("order", orderRequest);
//        return "redirect:home";
//    }
}
