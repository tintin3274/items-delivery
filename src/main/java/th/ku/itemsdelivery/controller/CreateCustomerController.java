package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequestMapping("/create_customer")
public class CreateCustomerController {
    private CustomerService customerService;

    public CreateCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public String getCreatePage(){return "create_customer";}

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
        return "create_order/customer_id="+customer.getId();
    }
}
