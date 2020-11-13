package th.ku.itemsdelivery.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.service.OrderRequestService;

@Controller
@RequestMapping("/history_order")
public class HistoryOrderController {
    private OrderRequestService orderRequestService;

    public HistoryOrderController(OrderRequestService orderRequestService){
        this.orderRequestService = orderRequestService;
    }

    @GetMapping
    public String getHistoryPage(Model model){
        model.addAttribute("allHistoryOrders", orderRequestService.getOrderRequestStatusAll("CANCEL").addAll(orderRequestService.getOrderRequestStatusAll("SUCESS")));
        return "history_order";
    }
}
