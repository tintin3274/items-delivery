package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.CustomerService;


@Controller
@RequestMapping("/items-delivery/create_customer")
public class CreateCustomerController {
    private CustomerService customerService;

    @Autowired
    public AuthenticationService authenticationService;

    public CreateCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public String getCreatePage(){
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        return "create_customer";
    }

    @PostMapping
    public String createCustomer(@RequestParam String firstname, @RequestParam String lastname,
                              @RequestParam String phoneNumber, Model model) {

        Customer customer = new Customer(0, firstname.trim(), lastname.trim(), phoneNumber.trim());
        if(customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber()) != null){
            customer = customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber());
        }
        else{
            customer = customerService.createCustomer(customer);
        }
        return "redirect:/items-delivery/create_order/customer_id="+customer.getId();
    }
}
