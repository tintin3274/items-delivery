package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.ItemService;

@Controller
@RequestMapping("/items-delivery/instock_items")
public class InstockItemsController {
    private ItemService itemService ;

    @Autowired
    private AuthenticationService authenticationService;

    public InstockItemsController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping
    public String getInstockPage(Model model){
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        String head ="fragments";
        if(authenticationService.getStaffCurrentLogin().getRole().equals("INVENTORY MANAGER")){
            head="fragmentInventory";
        }
        model.addAttribute("head",head);
        model.addAttribute("allItems",itemService.getItemAll());


        return "instock_items";
    }
}
