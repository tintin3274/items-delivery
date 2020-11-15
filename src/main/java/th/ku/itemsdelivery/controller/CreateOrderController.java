package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequestMapping("/create_order")
public class CreateOrderController {
    @Autowired
    private OrderRequestService orderRequestService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getCreatePage(){return "create_order";}

    @PostMapping
    public String createOrder(@RequestParam String firstname, @RequestParam String lastname,
                              @RequestParam String phoneNumber, @RequestParam String name,
                              @RequestParam String address, @RequestParam String dueDateTime,
                              @RequestParam String description, Model model) {

        Customer customer = new Customer(0, firstname.trim(), lastname.trim(), phoneNumber.trim());
        if(customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber()) != null){
            customer = customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber());
        }
        else{
            customer = customerService.createCustomer(customer);
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a", Locale.US);
        System.err.println(dueDateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(dueDateTime, dateTimeFormatter);
        OrderRequest orderRequest = new OrderRequest(0, name.trim(), null, address.trim(), description,
                null, localDateTime, null, customer.getId());
        model.addAttribute("order", orderRequest);
        System.err.println(customer.toString());
        System.err.println(orderRequest.toString());
        return "select_item";
    }
}
