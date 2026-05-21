package com.example.demo.team13.Team13Controller.Team13Auth.Team13Logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13GeneralLogoutController {

    @GetMapping("/Team13_General_Logout")
    public String logout(){
        return "team13/Team13General/Team13_Logout";
    }
    
    @PostMapping("/Team13_General_Logout")
    public String sendlogou() {
        return "team13/Team13General/Team13_Login";
    }
    
}
