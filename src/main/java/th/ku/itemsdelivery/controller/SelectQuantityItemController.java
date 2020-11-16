package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quantity_item")
public class SelectQuantityItemController {
    @GetMapping
    public String getQuantityItemPage(){
        return "quantity_item";
    }
}
