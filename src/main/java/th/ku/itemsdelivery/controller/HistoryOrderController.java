package th.ku.itemsdelivery.controller;


import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.model.Staff;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.util.ArrayList;

@Controller
@RequestMapping("/items-delivery/history_order")
public class HistoryOrderController {
    private OrderRequestService orderRequestService;
    private ItemService itemService;
    private CustomerService customerService;


    @Autowired
    private AuthenticationService authenticationService;

    public HistoryOrderController(OrderRequestService orderRequestService, ItemService itemService, CustomerService customerService) {
        this.orderRequestService = orderRequestService;
        this.itemService = itemService;
        this.customerService = customerService;
    }

    @GetMapping
    public String getHistoryPage(Model model){
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addDialect(new LayoutDialect());

        ArrayList<OrderRequest> currentOrderslist=new ArrayList<>();
        DateTimeAdapter dateTimeAdapter =new DateTimeAdapter();

        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("CANCEL"));
        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("SUCCESS"));
        model.addAttribute("allHistoryOrders",currentOrderslist);
        model.addAttribute("dateTimeAdapter",dateTimeAdapter);

        String head ="fragments";
        if(authenticationService.getStaffCurrentLogin().getRole().equals("INVENTORY MANAGER")){
            head="fragmentInventory";
        }
        model.addAttribute("head",head);

        return "history_order";
    }

    @GetMapping("/info/{id}")
    public String getInfoPage(@PathVariable int id, Model model){
        model.addAttribute("authen",authenticationService);
        model.addAttribute("Order",orderRequestService.getOrderRequest(id));
        model.addAttribute("allItem",itemService.getListItemOrder(id));
        model.addAttribute("itemService",itemService);
        model.addAttribute("dateTimeAdapter",new DateTimeAdapter());
        model.addAttribute("customerService",customerService);
        return "info_order";
    }
}
