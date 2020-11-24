package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.ItemService;

@Controller
@RequestMapping("/items-delivery/im_ex_history")
public class ImportExportHistoryController {
    private ItemService itemService;

    @Autowired
    private AuthenticationService authenticationService;

    public ImportExportHistoryController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getImExHistoryPage(Model model){
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        model.addAttribute("itemService",itemService);
        model.addAttribute("itemsimport",itemService.getItemImportAll());
        model.addAttribute("itemsexport",itemService.getItemExportAll());
        model.addAttribute("dateTimeAdapter",new DateTimeAdapter());
        model.addAttribute("authen",authenticationService);

        String head ="fragments";
        if(authenticationService.getStaffCurrentLogin().getRole().equals("INVENTORY MANAGER")){
            head="fragmentInventory";
        }
        model.addAttribute("head",head);

        return "im_ex_history";
    }
}
