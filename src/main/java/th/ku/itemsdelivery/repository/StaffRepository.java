package th.ku.itemsdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ku.itemsdelivery.model.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findStaffByUsernameEquals(String username);
}
