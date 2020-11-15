package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/select_item")
public class SelectItemController {
    private OrderRequestService orderRequestService;
    private ItemService itemService;

    public SelectItemController(OrderRequestService orderRequestService,ItemService itemService) {
        this.orderRequestService = orderRequestService;
        this.itemService=itemService;
    }

    @GetMapping
    public String getSelectPage(Model model){
        model.addAttribute("allItems",itemService.getItemAll());
        return "select_item";}

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
