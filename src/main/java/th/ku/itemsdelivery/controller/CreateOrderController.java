package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

@Controller
public class CreateOrderController {
    @RequestMapping("/create_order")
    public String getCreatePage(){return "create_order";}

//    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a"))
}
