package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchCustomerController {
    @RequestMapping("/search_customer")
    public String getSearchCustomerPage(){return "search_customer";}
}
