package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.model.ListItem;
import th.ku.itemsdelivery.model.ListItemId;
import th.ku.itemsdelivery.repository.ItemRepository;
import th.ku.itemsdelivery.repository.ListItemRepository;
import th.ku.itemsdelivery.repository.OrderRequestRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/list_item")
public class ListItemRestController {
    private ListItemRepository listItemRepository;
    private ItemRepository itemRepository;
    private OrderRequestRepository orderRequestRepository;

    public ListItemRestController(ListItemRepository listItemRepository, ItemRepository itemRepository, OrderRequestRepository orderRequestRepository) {
        this.listItemRepository = listItemRepository;
        this.itemRepository = itemRepository;
        this.orderRequestRepository = orderRequestRepository;
    }

    @GetMapping
    public List<ListItem> getAll() {
        return listItemRepository.findAll();
    }

    @GetMapping("/order_id={orderId}&item_id={itemId}")
    public ListItem getOne(@PathVariable int orderId, @PathVariable int itemId) {
        try {
            ListItemId listItemId = new ListItemId(orderId, itemId);
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
        try {
            if(listItemRepository.existsById(listItem.getListItemId()))
                return listItemRepository.findById(listItem.getListItemId()).get();

            if(listItem.getQuantity() < 1) throw new IllegalArgumentException("Quantity should > 1");
            if(orderRequestRepository.findById(listItem.getListItemId().getOrderId()).get().getStatus().equals("PENDING")) {
                listItemRepository.saveAndFlush(listItem);

                Item item = itemRepository.findById(listItem.getListItemId().getItemId()).get();
                item.setRequired(item.getRequired() + listItem.getQuantity());
                itemRepository.save(item);
                return listItem;
            }
            else throw new IllegalArgumentException("OrderRequest status is not PENDING");
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
