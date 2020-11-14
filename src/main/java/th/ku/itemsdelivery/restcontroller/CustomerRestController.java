package th.ku.itemsdelivery.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.ku.itemsdelivery.model.Customer;
import th.ku.itemsdelivery.repository.CustomerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/items-delivery/customer")
public class CustomerRestController {
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable int id) {
        try {
            return customerRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        customerRepository.saveAndFlush(customer);
        return customer;
    }

    @GetMapping("/firstname={firstname}/lastname={lastname}/phoneNumber={phoneNumber}")
    public List<Customer> getFindCustomer(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String phoneNumber) {
        try {
            return customerRepository.findCustomersByFirstnameContainsAndLastnameContainsAndPhoneNumberContains(firstname, lastname, phoneNumber);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/equal/firstname={firstname}/lastname={lastname}/phoneNumber={phoneNumber}")
    public Customer getFindCustomerEqual(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String phoneNumber) {
        List<Customer> customers = customerRepository.findCustomersByFirstnameEqualsAndLastnameEqualsAndPhoneNumberEquals(firstname, lastname, phoneNumber);
        if(customers.isEmpty()) return null;
        return customers.get(0);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(getOne(id).getId());
        customerRepository.save(customer);
        return customer;
    }
}
