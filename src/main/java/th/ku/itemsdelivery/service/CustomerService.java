package th.ku.itemsdelivery.service;

import org.springframework.stereotype.Service;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.repository.CustomerRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer findCustomer(int id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
