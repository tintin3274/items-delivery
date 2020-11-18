package th.ku.itemsdelivery.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/items_delivery/history_order")
public class HistoryOrderController {
    private OrderRequestService orderRequestService;
    private ItemService itemService;
    private CustomerService customerService;

    public HistoryOrderController(OrderRequestService orderRequestService, ItemService itemService, CustomerService customerService) {
        this.orderRequestService = orderRequestService;
        this.itemService = itemService;
        this.customerService = customerService;
    }

    @GetMapping
    public String getHistoryPage(Model model){
        ArrayList<OrderRequest> currentOrderslist=new ArrayList<>();
        DateTimeAdapter dateTimeAdapter =new DateTimeAdapter();

        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("CANCEL"));
        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("SUCCESS"));
        model.addAttribute("allHistoryOrders",currentOrderslist);
        model.addAttribute("dateTimeAdapter",dateTimeAdapter);
        return "history_order";
    }

    @GetMapping("/info/{id}")
    public String getInfoPage(@PathVariable int id, Model model){

        model.addAttribute("Order",orderRequestService.getOrderRequest(id));
        model.addAttribute("allItem",itemService.getListItemOrder(id));
        model.addAttribute("itemService",itemService);
        model.addAttribute("dateTimeAdapter",new DateTimeAdapter());
        model.addAttribute("customerService",customerService);
        return "info_order";
    }

}
