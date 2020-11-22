package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.time.LocalDateTime;
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
        if (authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        ArrayList<OrderRequest> currentOrderslist=new ArrayList<>();
        String month=new String();
        DateTimeAdapter dateTimeAdapter=new DateTimeAdapter();

        model.addAttribute("currentDateTime", LocalDateTime.now());
        model.addAttribute("cancelOrders",currentOrderslist);
        model.addAttribute("customerService",customerService);
        model.addAttribute("authenService",authenticationService);
        model.addAttribute("dateTime",dateTimeAdapter);
        model.addAttribute("month",month);
        return "report";
    }

    @PostMapping
    public String setReportPage(Model model, @RequestParam String date) {
        //System.err.println(date);
        ArrayList<OrderRequest> currentOrderslist = new ArrayList<>();
        currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("CANCEL"));
        DateTimeAdapter dateTimeAdapter = new DateTimeAdapter();
        ArrayList<OrderRequest> showOrderList = new ArrayList<>();

            String[] createDate;
            for (OrderRequest orderRequest : currentOrderslist) {
                createDate = orderRequest.getCreateDatetime().toLocalDate().toString().split("-");
                if (Integer.parseInt(createDate[1]) < 10)
                    createDate[1] = "0" + createDate[1];
                //System.err.println(createDate[1]+"-"+createDate[0]);
                //System.err.println(date);
                if ((createDate[1] + "-" + createDate[0]).equals(date))
                    showOrderList.add(orderRequest);
            }


        String[] monthList = {"", "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน",
                "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม",
                "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"};

        String month = monthList[Integer.parseInt(date.split("-")[0])];

        model.addAttribute("currentDateTime", LocalDateTime.now());
        model.addAttribute("month",month);
        model.addAttribute("cancelOrders",showOrderList);
        model.addAttribute("customerService",customerService);
        model.addAttribute("authenService",authenticationService);
        model.addAttribute("dateTime",dateTimeAdapter);
        return "report";
    }
}
