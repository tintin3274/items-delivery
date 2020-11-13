package th.ku.itemsdelivery.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ku.itemsdelivery.model.OrderRequest;

import java.util.*;

@Service
public class OrderRequestService {
    private RestTemplate restTemplate;

    public OrderRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OrderRequest> getOrderRequestAll() {
        String url = "http://localhost:8090/api/items-delivery/order_request";
        ResponseEntity<OrderRequest[]> response = restTemplate.getForEntity(url, OrderRequest[].class);
        OrderRequest[] orderRequests = response.getBody();
        return Arrays.asList(orderRequests);
    }

    public OrderRequest getOrderRequest(int id) {
        String url = "http://localhost:8090/api/items-delivery/order_request/"+id;
        ResponseEntity<OrderRequest> response = restTemplate.getForEntity(url, OrderRequest.class);
        OrderRequest orderRequest = response.getBody();
        return orderRequest;
    }

    public List<OrderRequest> getOrderRequestStatusAll(String status) {
        String url = "http://localhost:8090/api/items-delivery/order_request/status="+status;
        ResponseEntity<OrderRequest[]> response = restTemplate.getForEntity(url, OrderRequest[].class);
        OrderRequest[] orderRequests = response.getBody();
        return Arrays.asList(orderRequests);
    }

    public OrderRequest createOrderRequest(OrderRequest orderRequest) {
        String url = "http://localhost:8090/api/items-delivery/order_request";
        OrderRequest orderRequestResponse = restTemplate.postForObject(url, orderRequest, OrderRequest.class);
        return orderRequestResponse;
    }

    public OrderRequest progressOrderRequest(int id) {
        String url = "http://localhost:8090/api/items-delivery/order_request/progress/"+id;
        ResponseEntity<OrderRequest> response = restTemplate.getForEntity(url, OrderRequest.class);
        OrderRequest orderRequest = response.getBody();
        return orderRequest;
    }

    public OrderRequest successOrderRequest(int id) {
        String url = "http://localhost:8090/api/items-delivery/order_request/success/"+id;
        ResponseEntity<OrderRequest> response = restTemplate.getForEntity(url, OrderRequest.class);
        OrderRequest orderRequest = response.getBody();
        return orderRequest;
    }

    public OrderRequest cancelOrderRequest(int id) {
        String url = "http://localhost:8090/api/items-delivery/order_request/canel/"+id;
        ResponseEntity<OrderRequest> response = restTemplate.getForEntity(url, OrderRequest.class);
        OrderRequest orderRequest = response.getBody();
        return orderRequest;
    }

    public boolean pendingCheckOrderRequestItem(int id) {
        String url = "http://localhost:8090/api/items-delivery/order_request/pending/"+id;
        return restTemplate.getForObject(url, Boolean.class);
    }

    public HashMap<Integer, Boolean> pendingCheckOrderRequestItemAll() {
        String url = "http://localhost:8090/api/items-delivery/order_request/pending-available";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap<Integer, Boolean>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<HashMap<Integer, Boolean>>(){});
        return response.getBody();
    }
}
