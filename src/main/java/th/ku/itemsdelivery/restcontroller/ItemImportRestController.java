package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.model.ItemImport;
import th.ku.itemsdelivery.repository.ItemImportRepository;
import th.ku.itemsdelivery.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

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
    public ItemImport getOne(@PathVariable int id) {
        try {
            return itemImportRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/item={itemId}/add={quantity}/staff={staffId}")
    public ItemImport addQuantity(@PathVariable int itemId, @PathVariable int quantity, @PathVariable int staffId) {
        try {
            if(quantity < 1) throw new IllegalArgumentException("Quantity should > 1");
            ItemImport itemImport = new ItemImport();
            itemImport.setItemId(itemId);
            itemImport.setImportQuantity(quantity);
            itemImport.setImportRemark("ARRIVAL");
            itemImport.setImportDatetime(LocalDateTime.now());
            itemImport.setStaffId(staffId);
            itemImportRepository.saveAndFlush(itemImport);

            Item item = itemRepository.findById(itemId).get();
            item.setQuantity(item.getQuantity() + quantity);
            itemRepository.save(item);
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
