package th.ku.itemsdelivery.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/history_order")
public class HistoryOrderController {
    private OrderRequestService orderRequestService;

    public HistoryOrderController(OrderRequestService orderRequestService){
        this.orderRequestService = orderRequestService;
    }

    @GetMapping
    public String getHistoryPage(Model model){
        ArrayList<OrderRequest> currentOrderslist=new ArrayList<>();
        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("CANCEL"));
        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("SUCCESS"));
        model.addAttribute("allHistoryOrders",currentOrderslist);
        return "history_order";
    }
}
