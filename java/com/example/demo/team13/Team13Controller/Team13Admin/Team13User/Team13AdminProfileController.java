package com.example.demo.team13.Team13Controller.Team13Admin.Team13User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Team13AdminProfileController {
	
	@GetMapping("/Team13_Admin_Profile")
	public String add(){
		
	 return "team13/Team13Admin/Team13_Admin_Profile";
	 
	}

}
