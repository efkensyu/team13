package com.example.demo.team13.Team13Controller.Team13Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Team13UserLogoutController {

    @GetMapping("/Team13_User_Logout")
    public String logout(){
        return "team13/Team13Admin/Team13_Logout";
    }
    

    
}
