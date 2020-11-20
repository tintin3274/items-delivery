package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.service.ItemService;

@Controller
@RequestMapping("/items-delivery/instock_items")
public class InstockItemsController {
    private ItemService itemService ;

    public InstockItemsController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping
    public String getInstockPage(Model model){
        model.addAttribute("allItems",itemService.getItemAll());
        return "instock_items";
    }
}
