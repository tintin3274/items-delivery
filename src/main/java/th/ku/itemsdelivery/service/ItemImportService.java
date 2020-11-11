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

    }
}
