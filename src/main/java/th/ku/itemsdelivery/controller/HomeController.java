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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/home")
public class HomeController {
    private OrderRequestService orderRequestService;

    public HomeController(OrderRequestService orderRequestService){
        this.orderRequestService = orderRequestService;
    }

    @GetMapping
    public String getHomePage(Model model){
        List<OrderRequest> currentOrderlist = new ArrayList<>();
        currentOrderlist.addAll(orderRequestService.getOrderRequestStatusAll("PROGRESS"));
        currentOrderlist.addAll(orderRequestService.getOrderRequestStatusAll("PENDING"));
        model.addAttribute("allOrders",currentOrderlist);
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
