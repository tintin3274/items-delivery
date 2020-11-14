package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/create_order")
public class CreateOrderController {
    @Autowired
    private OrderRequestService orderRequestService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String getCreatePage(){return "create_order";}

    @PostMapping
    public String createOrder(@ModelAttribute Customer customer) {
//       if(customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber()) != null)
//           return "redirect:/create_order";
        System.err.println(customer.toString());
        System.err.println("WHY");
       customerService.createCustomer(customer);

       //orderRequestService.createOrderRequest(orderRequest);
       return "home";
    }
}
