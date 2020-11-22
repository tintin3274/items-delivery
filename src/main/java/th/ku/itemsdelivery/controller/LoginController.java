package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ku.itemsdelivery.model.Staff;
import th.ku.itemsdelivery.service.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/items-delivery/login")
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public String getLoginPage(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    @PostMapping
    public String login(Model model, HttpServletRequest request, @RequestParam String username, @RequestParam String password){
        authenticationService.login(username.trim(), password.trim());
        Staff staff=authenticationService.getStaffCurrentLogin();
        if(staff == null)
            return "login";
        else if(staff.getRole().equals("INSTALLER")){
            return "redirect:/items-delivery/home";
        }
        else if(staff.getRole().equals("INVENTORY MANAGER")){
            return "redirect:/items-delivery/import_item";
        }
        else {authenticationService.logout(); return "login";}

    }

    @GetMapping("/logout")
    public String logout(){
        authenticationService.logout();
        return "redirect:/items-delivery/login";
    }
}
