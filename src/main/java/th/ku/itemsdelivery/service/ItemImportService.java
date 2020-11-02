package th.ku.itemsdelivery.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ku.itemsdelivery.model.Item;
import th.ku.itemsdelivery.model.ItemImport;

@Service
public class ItemImportService {
    private RestTemplate restTemplate;

    public ItemImportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addItem(int id, int amount) {
        String urlItem = "http://localhost:8090/api/items-delivery/item/" + id;
        ResponseEntity<Item> response = restTemplate.getForEntity(urlItem, Item.class);
        Item item = response.getBody();

        String urlItemImport = "http://localhost:8090/api/items-delivery/item_import";
        ItemImport itemImport = new ItemImport(item, amount);
        item.setQuantity(item.getQuantity() + amount);

        restTemplate.postForObject(urlItemImport, itemImport, ItemImport.class);
        restTemplate.put(urlItem, item);
    }
}
