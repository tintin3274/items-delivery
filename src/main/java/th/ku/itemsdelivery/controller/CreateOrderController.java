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

import java.time.format.DateTimeFormatter;

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
    public String createOrder(Model model, @ModelAttribute Customer customer, @ModelAttribute OrderRequest orderRequest) {
        int customerId;
        if(customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber()) != null){
            customerId = customerService.getFindCustomerEqual(customer.getFirstname(), customer.getLastname(), customer.getPhoneNumber()).getId();
        }
        else{
            customerId = customerService.createCustomer(customer).getId();
        }
        orderRequest.setCustomerId(customerId);
        model.addAttribute("order", orderRequest);
        return "select_item";
    }
}
