package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.service.ItemService;

@Controller
@RequestMapping("/import_item")
public class ImportItemController {
    private ItemService itemService;

    public ImportItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getImportPage(Model model) {
        model.addAttribute("allItems",itemService.getItemAll());
        return "import_item";
    }
}
