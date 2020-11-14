package th.ku.itemsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ku.itemsdelivery.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomersByFirstnameContainsAndLastnameContainsAndPhoneNumberContains(String firstname, String lastname, String phoneNumber);
    List<Customer> findCustomersByFirstnameEqualsAndLastnameEqualsAndPhoneNumberEquals(String firstname, String lastname, String phoneNumber);
}
