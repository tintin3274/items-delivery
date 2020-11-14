package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoOrderController {
    @RequestMapping("/info_order")
    public String getInfoOrderPage(){return "info_order";}
}
