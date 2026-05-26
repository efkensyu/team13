package com.example.demo.team13.Team13Controller.Team13Admin.Team13User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.team13.Session.Team13AdminInfoSession;

@Controller
public class Team13AdminProfileController {
	@Autowired Team13AdminInfoSession team13AdminInfoSession;
	
	@GetMapping("/Team13_Admin_Profile")
	public String add(Model model){
		
		model.addAttribute("admin",team13AdminInfoSession);
		
		return "team13/Team13Admin/Team13_Admin_Profile";
	 
	}

}
