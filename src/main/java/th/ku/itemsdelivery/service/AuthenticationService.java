package th.ku.itemsdelivery.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ku.itemsdelivery.model.Staff;
import th.ku.itemsdelivery.repository.StaffRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthenticationService {
    private static Staff staffCurrentLogin ;
    private StaffRepository staffRepository;

    public AuthenticationService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public String register(Staff registerStaff) {
        if(findStaffByUsername(registerStaff.getUsername()) != null)
            return "Register Fail";
        registerStaff.setPassword(hash(registerStaff.getPassword()));
        staffRepository.save(registerStaff);
        return "Register Success";
    }

    private String hash(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    private Staff findStaffByUsername(String username) {
        List<Staff> staffs = staffRepository.findStaffByUsernameEquals(username);
        if(!staffs.isEmpty()) return staffs.get(0);
        return null;
    }

    public Staff findStaffById(int id) {
        try {
            return staffRepository.findById(id).get();
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public String login(String username, String password) {
        staffCurrentLogin = null;

        Staff staffTryLogin = findStaffByUsername(username);
        if(staffTryLogin != null) {
            String hashPassword = staffTryLogin.getPassword();

            if(BCrypt.checkpw(password, hashPassword)) {
                staffCurrentLogin = staffTryLogin;
                return "Login Success";
            }
        }
         return "Login Fail";
    }

    public void logout() {
        staffCurrentLogin = null;
    }

    public Staff getStaffCurrentLogin() {
        return staffCurrentLogin;
    }
}