package com.example.demo.team13.Team13Controller.Team13General.Team13UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.team13.Session.Team13LoginSession;

@Controller

public class Team13GeneralProfileController {
	@Autowired Team13LoginSession team13LoginSession;
	
	@GetMapping("/Team13_General_Profile")
	public String profile(Model model){
		
		
		model.addAttribute("login",team13LoginSession);
		
		return "team13/Team13General/Team13_General_Profile";
	 
	}

}
