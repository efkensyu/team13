package com.example.demo.team13.Team13Controller.Team13Auth.Team13Logout;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Session.Team13AdminInfoSession;

@Controller
public class Team13AdminLogoutController {

	@Autowired Team13AdminInfoSession team13AdminInfoSession;
	
    @GetMapping("/Team13_Admin_Logout")
    public String logout(){
	  //ログイン認証
    if (team13AdminInfoSession.getKanri_id() == null) {
        return "redirect:/Team13_Admin_Login";
    }
    	
        return "team13/Team13Admin/Team13_Logout";
    }
    
    @PostMapping("/Team13_Admin_Logout_Exec")
    public String sendlogout(HttpSession session) {
    	session.invalidate(); 
        return "redirect:/Team13_Admin_Login";
    }
    
    @PostMapping(value="/Team13_Admin_Logout",params="back")
    public String backlogout() {
        return "redirect:/Team13_Admin_Profile";
    }
    

}
