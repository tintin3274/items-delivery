package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ku.itemsdelivery.model.ListItem;
import th.ku.itemsdelivery.model.ListItemId;
import th.ku.itemsdelivery.model.OrderRequest;
import th.ku.itemsdelivery.model.Staff;
import th.ku.itemsdelivery.service.AuthenticationService;
import th.ku.itemsdelivery.service.ItemService;
import th.ku.itemsdelivery.service.OrderRequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/items_delivery/quantity_item")
public class SelectQuantityItemController {
    @Autowired
    private OrderRequestService orderRequestService;

    @Autowired
    private AuthenticationService authenticationService;

    private ItemService itemService;

    public SelectQuantityItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getQuantityItemPage(Model model){
        if(authenticationService.getStaffCurrentLogin() == null)
            return "redirect:/items-delivery/login";

        model.addAttribute("allItem",itemService.getItemAll());
        return "quantity_item";
    }

    @PostMapping
    public String inputInt(HttpServletRequest request) {
        OrderRequest orderRequest = (OrderRequest) request.getSession().getAttribute("order");
        Staff staff = authenticationService.getStaffCurrentLogin();
        orderRequest.setStaffId(staff.getId());
        orderRequest = orderRequestService.createOrderRequest(orderRequest);

        int[] itemQty = Arrays.stream(request.getParameterValues("quantity")).mapToInt(Integer::parseInt).toArray();
        //System.err.println(Arrays.toString(itemQty));
        //System.err.println(Arrays.toString(request.getParameterValues("itemId")));
        int[] itemId = Arrays.stream(request.getParameterValues("itemId")).mapToInt(Integer::parseInt).toArray();
        //System.err.println(Arrays.toString(itemId));
        Map<Integer, Integer> mapIdQty = IntStream.range(0, itemId.length).boxed()
                .collect(Collectors.toMap(i -> itemId[i], i -> itemQty[i]));

        ArrayList<ListItemId> listItemIds = new ArrayList<>();
        for (int id : mapIdQty.keySet().stream().mapToInt(Integer::intValue).toArray()) {
            if (mapIdQty.get(id) != 0) {
                listItemIds.add(new ListItemId(orderRequest.getId(), id));
            }
        }
        //System.err.println(listItemIds.toString());
        ArrayList<ListItem> listItems = new ArrayList<>();
        for (ListItemId listItemId : listItemIds)
            listItems.add(new ListItem(listItemId, mapIdQty.get(listItemId.getItemId())));
        //System.err.println(listItems.toString());

        for(ListItem listItem : listItems)
            itemService.createListItem(listItem);

        return "redirect:/items-delivery/home";
    }
}
