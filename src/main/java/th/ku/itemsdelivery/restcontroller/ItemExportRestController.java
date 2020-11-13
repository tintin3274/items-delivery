package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ku.itemsdelivery.model.ItemExport;
import th.ku.itemsdelivery.model.ItemExportId;
import th.ku.itemsdelivery.repository.ItemExportRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/item_export")
public class ItemExportRestController {
    ItemExportRepository itemExportRepository;

    public ItemExportRestController(ItemExportRepository itemExportRepository) {
        this.itemExportRepository = itemExportRepository;
    }

    @GetMapping
    public List<ItemExport> getAll() {
        return itemExportRepository.findAll();
    }

    @GetMapping("/order_id={order_id}&item_id={item_id}")
    public ItemExport getAll(@PathVariable int order_id, @PathVariable int item_id) {
        try {
            ItemExportId itemExportId = new ItemExportId(order_id, item_id);
            return itemExportRepository.findById(itemExportId).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
