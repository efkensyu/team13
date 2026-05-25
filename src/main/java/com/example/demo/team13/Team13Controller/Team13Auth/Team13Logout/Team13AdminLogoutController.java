package com.example.demo.team13.Team13Controller.Team13Auth.Team13Logout;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Controller.Team13Auth.Team13Login.Team13LoginSession;

@Controller
public class Team13AdminLogoutController {

	@Autowired Team13LoginSession team13LoginSession;
	
    @GetMapping("/Team13_Admin_Logout")
    public String logout(){
        return "team13/Team13Admin/Team13_Logout";
    }
    
    @PostMapping(value="/Team13_Admin_Logout",params="back")
    public String backlogout() {
        return "team13/Team13Admin/Team13_Admin_Profile";
    }
    
    @PostMapping(value="/Team13_Admin_Logout",params="logout")
    public String sendlogout(HttpSession session) {
    	session.invalidate(); 
        return "team13/Team13Admin/Team13_Login";
    }
}
