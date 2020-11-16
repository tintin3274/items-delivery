package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.service.CustomerService;

import java.util.ArrayList;

@Controller
@RequestMapping("/search_customer")
public class SearchCustomerController {
    private CustomerService customerService;

    public SearchCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getPage (){
        return "search_customer";
    }

    @PostMapping("/searchName")
    public String searchCustomerName(@RequestParam String FirstName, @RequestParam String LastName,
                                     @RequestParam String Tel, Model model){
        model.addAttribute("selectedCustomer",customerService.getFindCustomer(FirstName,LastName,Tel));
        return "search_customer";
    }

    @PostMapping("/searchId")
    public String searchCustomerId(@RequestParam Integer Id, Model model){
        ArrayList<Customer> customer = new ArrayList<>();
        customer.add(customerService.getCustomer(Id));
        model.addAttribute("selectedCustomer",customer);
        System.err.println(customer);
        return "search_customer";
    }

}
