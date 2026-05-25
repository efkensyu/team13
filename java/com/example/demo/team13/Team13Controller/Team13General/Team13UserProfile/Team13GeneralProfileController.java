package com.example.demo.team13.Team13Controller.Team13General.Team13UserProfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Team13GeneralProfileController {
	
	@GetMapping("/Team13_General_Profile")
	public String profile(){
		
	 return "team13/Team13General/Team13_General_Profile";
	 
	}

}
