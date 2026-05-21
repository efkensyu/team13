package com.example.demo.team13.Team13Controller.Team13Admin.Stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13_Admin_Home_Controller {
	
	@GetMapping("/Team13_Admin_Home")
	public String index(){
		
	 return "team13/Team13Admin/Team13_Home";
	 
	}
	
	@PostMapping("/Team13_Admin_Home")
	public String send(){
	
    return "team13/Team13Admin/Team13_Home";
 
}

}
