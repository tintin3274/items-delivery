package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.ItemImport;
import th.ku.itemsdelivery.repository.ItemImportRepository;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/items-delivery/item_import")
public class ItemImportRestController {
    private ItemImportRepository repository;

    public ItemImportRestController(ItemImportRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ItemImport> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ItemImport getOne(@PathVariable int id){
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @PostMapping
    public ItemImport create(@RequestBody ItemImport itemImport) {
        ItemImport record = repository.saveAndFlush(itemImport);
        return record;
    }
}
