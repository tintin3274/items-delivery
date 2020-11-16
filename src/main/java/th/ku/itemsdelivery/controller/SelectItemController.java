package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ku.itemsdelivery.model.DateTimeAdapter;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/select_item")
public class SelectItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String getSelectPage(HttpServletRequest request, ModelMap model,
                                RedirectAttributes redirectAttributes, OrderRequest orderRequest){
        //System.err.println(orderRequest.toString());
        //model.addAttribute("order", orderRequest);
        request.getSession().setAttribute("order", orderRequest);
        model.addAttribute("allItems", itemService.getItemAll());
        System.err.println( request.getSession().getAttribute("order").toString());
        //System.err.println(orderRequest.toString());
        return "select_item";
    }

    @PostMapping
    public String select(HttpServletRequest request, ModelMap model){
        OrderRequest orderRequest = (OrderRequest) request.getSession().getAttribute("order");
//        if(orderRequest != null)
//            System.err.println(orderRequest.toString());
//        else
//            System.err.println("WHY!?");

        return "redirect:/home";
        //return "select_item";
    }
}
