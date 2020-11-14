package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/items-delivery/item")
public class ItemRestController {
    private ItemRepository itemRepository;

    public ItemRestController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable int id) {
        try {
            return itemRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        item.setQuantity(0);
        item.setRequired(0);
        itemRepository.saveAndFlush(item);
        return item;
    }
}
