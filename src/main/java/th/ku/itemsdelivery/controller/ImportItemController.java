package th.ku.itemsdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImportItemController {
    @RequestMapping("/import_item")
    public String getPage(){return "import_item";}
}
