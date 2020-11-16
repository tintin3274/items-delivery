package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ku.itemsdelivery.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping("/quantity_item")
public class SelectQuantityItemController {
    private ItemService itemService;

    public SelectQuantityItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getQuantityItemPage(Model model){
        model.addAttribute("allItem",itemService.getItemAll());
        return "quantity_item";
    }
    @PostMapping
    public String inputInt(HttpServletRequest request){
        String[] itemQty = request.getParameterValues("quantity");
        Object itemId=request.getAttribute("idQty1");
        System.err.println(Arrays.toString(itemQty));
        System.err.println(itemId.toString());
        return "home";
    }
}
