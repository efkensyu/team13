package com.example.demo.team13.Team13Controller.Team13Auth.Team13Logout;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Session.Team13UserInfoSession;

@Controller
public class Team13GeneralLogoutController {
	
	@Autowired Team13UserInfoSession team13UserInfoSession;

    @GetMapping("/Team13_General_Logout")
    public String logout(){
    	  //ログイン認証
//        if (team13UserInfoSession.getShain_id() == null) {
//            return "redirect:/Team13_General_Login";
//        }
        return "team13/Team13General/Team13_Logout";
    }
    
    @PostMapping("/Team13_General_Logout_Exec")
    public String sendlogout(HttpSession session) {
    	session.invalidate(); 
        return "redirect:/Team13_General_Login";
    }
    
    @PostMapping(value="/Team13_General_Logout",params="back")
    public String backlogout() {
        return "redirect:/Team13_General_Profile";
    }
    
}
