package th.ku.itemsdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import th.ku.itemsdelivery.service.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public String getLoginPage(HttpServletRequest request, HttpServletResponse response){
        return "";
    }

    @PostMapping
    public String login(Model model, HttpServletRequest request, @RequestParam String username, @RequestParam String password){
        authenticationService.login(username, password);
        return  "";
    }
}
