package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info_order")
public class InfoOrderController {

    public String getInfoOrderPage(){return "info_order";}
}
