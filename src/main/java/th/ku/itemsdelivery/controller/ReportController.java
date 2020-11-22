package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.util.ArrayList;

@Controller
@RequestMapping("/items-delivery/report")
public class ReportController {
    private OrderRequestService orderRequestService;
    private CustomerService customerService;
    private AuthenticationService authenticationService;


    public ReportController(OrderRequestService orderRequestService, CustomerService customerService, AuthenticationService authenticationService) {
        this.orderRequestService = orderRequestService;
        this.customerService = customerService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getReportPage(Model model){
        ArrayList<OrderRequest> currentOrderslist=new ArrayList<>();
        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("CANCEL"));
        DateTimeAdapter dateTimeAdapter=new DateTimeAdapter();

        model.addAttribute("cancelOrders",currentOrderslist);
        model.addAttribute("customerService",customerService);
        model.addAttribute("authenService",authenticationService);
        model.addAttribute("dateTime",dateTimeAdapter);
        return "report";
    }
}
