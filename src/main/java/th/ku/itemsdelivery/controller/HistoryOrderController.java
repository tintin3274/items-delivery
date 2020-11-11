package th.ku.itemsdelivery.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoryOrderController {
    @RequestMapping("/history_order")
    public String getHistoryPage(){return "history_order";}
}
