package th.ku.itemsdelivery.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ku.itemsdelivery.model.Customer;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> getCustomerAll() {
        String url = "http://localhost:8090/api/items-delivery/customer";
        ResponseEntity<Customer[]> responseEntity = restTemplate.getForEntity(url, Customer[].class);
        Customer[] customers = responseEntity.getBody();
        return Arrays.asList(customers);
    }

    public Customer getCustomer(int id) {
        String url = "http://localhost:8090/api/items-delivery/customer/"+id;
        ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(url, Customer.class);
        Customer customer = responseEntity.getBody();
        return customer;
    }

    public Customer createCustomer(Customer customer) {
        String url = "http://localhost:8090/api/items-delivery/customer";
        Customer customerResponse = restTemplate.postForObject(url, customer, Customer.class);
        return customerResponse;
    }

    public List<Customer> getFindCustomer(String firstname, String lastname, String phoneNumber) {
        String url = "http://localhost:8090/api/items-delivery/customer/firstname="+firstname+"/lastname="+lastname+"/phoneNumber="+phoneNumber;
        ResponseEntity<Customer[]> responseEntity = restTemplate.getForEntity(url, Customer[].class);
        Customer[] customers = responseEntity.getBody();
        return Arrays.asList(customers);
    }

    public Customer getFindCustomerEqual(String firstname, String lastname, String phoneNumber) {
        String url = "http://localhost:8090/api/items-delivery/customer/equal/firstname="+firstname+"/lastname="+lastname+"/phoneNumber="+phoneNumber;
        ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(url, Customer.class);
        Customer customer = responseEntity.getBody();
        return customer;
    }

    public Customer updateCustomer(int id, Customer customer) {
        String url = "http://localhost:8090/api/items-delivery/customer/"+id;
        restTemplate.put(url, customer);
        return getCustomer(id);
    }
}
