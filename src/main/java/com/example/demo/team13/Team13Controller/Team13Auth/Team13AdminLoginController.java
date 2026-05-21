package com.example.demo.team13.Team13Controller.Team13Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13AdminLoginController {

    @GetMapping("/Team13_Admin_Login")
    public String login() {
        return "team13/Team13Admin/Team13_Login";
    }
    
    @PostMapping("/Team13_Admin_Login")
    public String login2() {
        return "team13/Team13Admin/Team13_Home";
    }
    
}
