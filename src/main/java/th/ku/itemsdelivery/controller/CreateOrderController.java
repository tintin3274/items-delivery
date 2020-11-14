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
    public String createOrder(@ModelAttribute OrderRequest orderRequest, @ModelAttribute Customer customer) {
        for(Customer customerCheck : customerService.getCustomerAll()){
            if(customerCheck.getFirstname().equals(customer.getFirstname())
            || customerCheck.getLastname().equals(customer.getLastname())
            || customerCheck.getPhoneNumber().equals(customer.getPhoneNumber()))
                return "redirect:/create_order";
        }

        customerService.createCustomer(customer);
        orderRequestService.createOrderRequest(orderRequest);
        return "redirect:/create_order";
    }
}
