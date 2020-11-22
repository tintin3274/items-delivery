package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.model.Staff;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/items-delivery/create_order")
public class CreateOrderController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/customer_id={id}")
    public String getCreatePage(@PathVariable int id, ModelMap model, HttpServletRequest request){
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        Customer customer = customerService.getCustomer(id);
        //model.addAttribute("customer", customer);
        request.getSession().setAttribute("customer", customer);
        model.addAttribute("allItems", itemService.getItemAll());
        return "create_order";
    }

    @PostMapping
    public String createOrder(@RequestParam String name, @RequestParam String address, @RequestParam String dueDateTime,
                              @RequestParam String description, ModelMap model, RedirectAttributes redirectAttributes,
                              HttpServletResponse response, HttpServletRequest request) {

        Staff staff = authenticationService.getStaffCurrentLogin();
        Customer customer = (Customer) request.getSession().getAttribute("customer");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //System.err.println(dueDateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(dueDateTime, dateTimeFormatter);
        OrderRequest orderRequest = new OrderRequest(0, name.trim(), null, address.trim(), description,
                null, localDateTime, null, customer.getId(), staff.getId());

        request.getSession().setAttribute("order", orderRequest);
        model.addAttribute("allItem",itemService.getItemAll());
        //System.err.println(customer.toString());
        //System.err.println(orderRequest.toString());
        return "quantity_item";
    }
}
