package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.OrderRequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/select_item")
public class SelectItemController {
    private OrderRequestService orderRequestService;

    public SelectItemController(OrderRequestService orderRequestService) {
        this.orderRequestService = orderRequestService;
    }

    @GetMapping
    public String getSelectPage(){return "select_item";}

    @PostMapping
    public String select(HttpServletRequest request, Model model){
        String[] s=request.getParameterValues("duallistbox_demo1[]");
        System.err.println(Arrays.toString(s));


            ArrayList<OrderRequest> currentOrderslist=new ArrayList<>();
            DateTimeAdapter dateTimeAdapter =new DateTimeAdapter();
            currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("PENDING"));
            currentOrderslist.addAll(orderRequestService.getOrderRequestStatusAll("PROGRESS"));
        model.addAttribute("allOrders",currentOrderslist);
        model.addAttribute("dateTimeAdapter",dateTimeAdapter);
        return "home";
    }
}
