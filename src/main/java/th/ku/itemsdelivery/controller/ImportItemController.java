package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;

import th.ku.itemsdelivery.model.Staff;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.ItemService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/items-delivery/import_item")
public class ImportItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public String getImportPage(Model model) {
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        model.addAttribute("allItems",itemService.getItemAll());
        return "import_item";
    }

    @PostMapping("/import")
    public String importItem(Model model, HttpServletRequest request, @RequestParam int quantity){
        Staff staff = authenticationService.getStaffCurrentLogin();
        String[] itemIDs = request.getParameterValues("item_box[]");
        int itemId = Integer.parseInt(itemIDs[0]);

        //System.err.println(itemId+" "+quantity);
        itemService.createItemImport(itemId, quantity, staff.getId());

        return "redirect:/items-delivery/import_item";
    }

    @PostMapping("/create_item")
    public String createItem(Model model, @ModelAttribute Item item){
        Staff staff = authenticationService.getStaffCurrentLogin();
        //System.err.println(item.toString());
        int quantity = item.getQuantity();
        item = itemService.createItem(item);
        //System.err.println(item.toString());
        itemService.createItemImport(item.getId(), quantity, staff.getId());
        return "redirect:/items-delivery/import_item";
    }
}
