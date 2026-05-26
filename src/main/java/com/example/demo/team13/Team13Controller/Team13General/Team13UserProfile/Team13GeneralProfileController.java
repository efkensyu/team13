package com.example.demo.team13.Team13Controller.Team13General.Team13UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.team13.Session.Team13UserInfoSession;

@Controller

public class Team13GeneralProfileController {
	@Autowired Team13UserInfoSession team13UserInfoSession;
	
	@GetMapping("/Team13_General_Profile")
	public String profile(Model model){
		
		
		model.addAttribute("user",team13UserInfoSession);
		
		return "team13/Team13General/Team13_General_Profile";
	 
	}

}
