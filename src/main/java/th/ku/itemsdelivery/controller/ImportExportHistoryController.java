package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.service.ItemService;

@Controller
@RequestMapping("/items-delivery/im_ex_history")
public class ImportExportHistoryController {
    private ItemService itemService;

    public ImportExportHistoryController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getImExHistoryPage(Model model){
        model.addAttribute("itemService",itemService);
        model.addAttribute("itemsimport",itemService.getItemImportAll());
        model.addAttribute("itemsexport",itemService.getItemExportAll());
        model.addAttribute("dateTimeAdapter",new DateTimeAdapter());
        return "im_ex_history";
    }
}
