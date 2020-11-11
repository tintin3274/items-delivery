package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.ListItem;
import th.ku.itemsdelivery.model.ListItemId;
import th.ku.itemsdelivery.repository.ListItemRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/list_item")
public class ListItemRestController {
    private ListItemRepository listItemRepository;

    public ListItemRestController(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @GetMapping
    public List<ListItem> getAll() {
        return listItemRepository.findAll();
    }

    @GetMapping("/order_id={order_id}&item_id={item_id}")
    public ListItem getOne(@PathVariable int order_id, @PathVariable int item_id){
        try {
            ListItemId listItemId = new ListItemId(order_id, item_id);
            return listItemRepository.findById(listItemId).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @PostMapping
    public ListItem create(@RequestBody ListItem listItem) {
        listItemRepository.saveAndFlush(listItem);
        return listItem;
    }
}
