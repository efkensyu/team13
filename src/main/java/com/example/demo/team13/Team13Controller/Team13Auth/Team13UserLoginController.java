package com.example.demo.team13.Team13Controller.Team13Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13UserLoginController {

    @GetMapping("/Team13_User_Login")
    public String login() {
        return "team13/Team13General/Team13_Login";
    }
    
    @PostMapping("/Team13_User_Login")
    public String login2() {
        return "team13/Team13General/Team13_Home";
    }
    
}
