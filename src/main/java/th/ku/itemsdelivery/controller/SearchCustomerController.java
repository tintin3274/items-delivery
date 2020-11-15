package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search_customer")
public class SearchCustomerController {
    @GetMapping
    public String getSearchCustomerPage(){return "search_customer";}
}
