package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.CustomerService;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequestMapping("/create_order")
public class CreateOrderController {
    @Autowired
    private ItemService itemService;
    private CustomerService customerService;

    public CreateOrderController(ItemService itemService, CustomerService customerService) {
        this.itemService = itemService;
        this.customerService = customerService;
    }

    @GetMapping("/customer_id={id}")
    public String getCreatePage(@PathVariable int id,Model model){
        model.addAttribute("allItems",itemService.getItemAll());
        return "create_order";
    }

    @PostMapping
    public String createOrder( @RequestParam String name,
                              @RequestParam String address, @RequestParam String dueDateTime,
                              @RequestParam String description, ModelMap model, RedirectAttributes redirectAttributes,
                              HttpServletResponse response, HttpServletRequest request) {

        Customer customer = customerService.getCustomer()


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a", Locale.US);
        //System.err.println(dueDateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(dueDateTime, dateTimeFormatter);
        OrderRequest orderRequest = new OrderRequest(0, name.trim(), null, address.trim(), description,
                null, localDateTime, null, customer.getId());
        redirectAttributes.addFlashAttribute(orderRequest);
        //model.addAttribute("allItems", itemService.getItemAll());
        //System.err.println(customer.toString());
        //System.err.println(orderRequest.toString());
        return "redirect:/select_item";
    }
}
