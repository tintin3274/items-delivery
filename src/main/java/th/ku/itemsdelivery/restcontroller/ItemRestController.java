package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.repository.ItemRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/item")
public class ItemRestController {
    private ItemRepository repository;

    public ItemRestController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Item> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable int id){
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        Item record = repository.saveAndFlush(item);
        return record;
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable int id,
                       @RequestBody Item item) {
        try {
            Item record = repository.findById(id).get();
            record.setQuantity(item.getQuantity());
            record.setRequired(item.getRequired());
            repository.save(record);
            return record;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
