package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.model.ItemImport;
import th.ku.itemsdelivery.repository.ItemImportRepository;
import th.ku.itemsdelivery.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/items-delivery/item_import")
public class ItemImportRestController {
    private ItemImportRepository itemImportRepository;
    private ItemRepository itemRepository;

    public ItemImportRestController(ItemImportRepository itemImportRepository, ItemRepository itemRepository) {
        this.itemImportRepository = itemImportRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<ItemImport> getAll() {
        return itemImportRepository.findAll();
    }

    @GetMapping("/{id}")
    public ItemImport getOne(@PathVariable int id){
        try {
            return itemImportRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @PostMapping
    public ItemImport create(@RequestBody ItemImport itemImport) {
        ItemImport record = itemImportRepository.saveAndFlush(itemImport);
        return record;
    }

    @GetMapping("/item={item_id}/add={quantity}")
    public ItemImport addQuantity(@PathVariable int item_id, @PathVariable int quantity) {
        try {
            if(quantity < 1) throw new IllegalArgumentException("Quantity should > 1");
            Item item = itemRepository.getOne(item_id);
            item.setQuantity(item.getQuantity() + quantity);
            itemRepository.save(item);

            ItemImport itemImport = new ItemImport();
            itemImport.setItem_id(item_id);
            itemImport.setImportQuantity(quantity);
            itemImport.setImportRemark("ARRIVAL");
            itemImport.setImportDatetime(LocalDateTime.now());
            itemImportRepository.saveAndFlush(itemImport);
            return itemImport;
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
