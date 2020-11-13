package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectItemController {
    @RequestMapping("/select_item")
    public String getSelectPage(){return "select_item";}
}
