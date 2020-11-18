package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.model.ListItemId;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/items_delivery/import_item")
public class ImportItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String getImportPage(Model model) {
        model.addAttribute("allItems",itemService.getItemAll());
        return "import_item";
    }

    @PostMapping("/import")
    public String importItem(Model model, HttpServletRequest request, @RequestParam int quantity){
        String[] itemIDs = request.getParameterValues("item_box[]");
        int itemId = Integer.parseInt(itemIDs[0]);

        //System.err.println(itemId+" "+quantity);
        itemService.createItemImport(itemId, quantity);
        return "redirect:/items_delivery/import_item";
    }

    @PostMapping("/create_item")
    public String createItem(Model model, @ModelAttribute Item item){
        //System.err.println(item.toString());
        int quantity = item.getQuantity();
        item = itemService.createItem(item);
        //System.err.println(item.toString());
        itemService.createItemImport(item.getId(), quantity);
        return "redirect:/items_delivery/import_item";
    }
}
