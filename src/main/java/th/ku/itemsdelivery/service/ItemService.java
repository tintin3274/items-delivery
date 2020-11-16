package th.ku.itemsdelivery.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ku.itemsdelivery.model.*;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {
    private RestTemplate restTemplate;

    public ItemService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //***** ItemService *****/////
    public List<Item> getItemAll() {
        String url = "http://localhost:8090/api/items-delivery/item";
        ResponseEntity<Item[]> responseEntity = restTemplate.getForEntity(url, Item[].class);
        Item[] items = responseEntity.getBody();
        return Arrays.asList(items);
    }

    public Item getItem(int id) {
        String url = "http://localhost:8090/api/items-delivery/item/"+id;
        ResponseEntity<Item> responseEntity = restTemplate.getForEntity(url, Item.class);
        Item item = responseEntity.getBody();
        return item;
    }

    public Item createItem(Item item) {
        String url = "http://localhost:8090/api/items-delivery/item";
        Item itemResponse = restTemplate.postForObject(url, item, Item.class);
        return itemResponse;
    }



    //***** ItemImportService *****/////
    public List<ItemImport> getItemImportAll() {
        String url = "http://localhost:8090/api/items-delivery/item_import";
        ResponseEntity<ItemImport[]> responseEntity = restTemplate.getForEntity(url, ItemImport[].class);
        ItemImport[] itemImports = responseEntity.getBody();
        return Arrays.asList(itemImports);
    }

    public ItemImport getItemImport(int id) {
        String url = "http://localhost:8090/api/items-delivery/item_import/"+id;
        ResponseEntity<ItemImport> responseEntity = restTemplate.getForEntity(url, ItemImport.class);
        ItemImport itemImport = responseEntity.getBody();
        return itemImport;
    }

    public ItemImport createItemImport(int itemId, int quantity) {
        String url = "http://localhost:8090/api/items-delivery/item_import/item="+itemId+"/add="+quantity;
        ResponseEntity<ItemImport> responseEntity = restTemplate.getForEntity(url, ItemImport.class);
        ItemImport itemImport = responseEntity.getBody();
        return itemImport;
    }



    //***** ItemExportService *****/////
    public List<ItemExport> getItemExportAll() {
        String url = "http://localhost:8090/api/items-delivery/item_export";
        ResponseEntity<ItemExport[]> responseEntity = restTemplate.getForEntity(url, ItemExport[].class);
        ItemExport[] itemExports = responseEntity.getBody();
        return Arrays.asList(itemExports);
    }

    public ItemExport getItemExport(int orderId, int itemId) {
        String url = "http://localhost:8090/api/items-delivery/item_export/order_id="+orderId+"&item_id="+itemId;
        ResponseEntity<ItemExport> responseEntity = restTemplate.getForEntity(url, ItemExport.class);
        ItemExport itemExport = responseEntity.getBody();
        return itemExport;
    }



    //***** ListItemService *****/////
    public List<ListItem> getListItemAll() {
        String url = "http://localhost:8090/api/items-delivery/list_item";
        ResponseEntity<ListItem[]> responseEntity = restTemplate.getForEntity(url, ListItem[].class);
        ListItem[] listItems = responseEntity.getBody();
        return Arrays.asList(listItems);
    }

    public ListItem getListItem(int orderId, int itemId) {
        String url = "http://localhost:8090/api/items-delivery/item_export/order_id="+orderId+"&item_id="+itemId;
        ResponseEntity<ListItem> responseEntity = restTemplate.getForEntity(url, ListItem.class);
        ListItem listItem = responseEntity.getBody();
        return listItem;
    }

    public ListItem createListItem(ListItem listItem) {
        String url = "http://localhost:8090/api/items-delivery/list_item";
        ResponseEntity<ListItem> responseEntity = restTemplate.getForEntity(url, ListItem.class);
        ListItem listItemResponse = responseEntity.getBody();
        return listItemResponse;
    }

    public List<ListItem> getListItemOrder(int orderId) {
        String url = "http://localhost:8090/api/items-delivery/list_item/order_id="+orderId;
        ResponseEntity<ListItem[]> responseEntity = restTemplate.getForEntity(url, ListItem[].class);
        ListItem[] listItems = responseEntity.getBody();
        return Arrays.asList(listItems);
    }
}
