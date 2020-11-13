package th.ku.itemsdelivery.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemImportService {
    private RestTemplate restTemplate;

    public ItemImportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addItem(int id, int amount) {

    }
}
