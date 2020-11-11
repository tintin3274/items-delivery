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
    public Customer getOne(@PathVariable int id){
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
    public List<Customer> getFindCustomer(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String phoneNumber){
        try {
            return customerRepository.findCustomersByFirstnameContainsAndLastnameContainsAndPhoneNumberContains(firstname, lastname, phoneNumber);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/phoneNumber={phoneNumber}")
    public Customer getFindIdByPhoneNumber(@PathVariable String phoneNumber){
        try {
            return customerRepository.findCustomersByPhoneNumber(phoneNumber);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
