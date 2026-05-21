package com.example.demo.team13.Team13Controller.Team13General.Team13Product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13_General_Home_Controller {
	
	@GetMapping("/Team13_General_Home")
	public String add(){
		
	 return "team13/Team13General/Team13_Home";
	 
	}
	
	@PostMapping("/Team13_General_Home")
	public String send(){
	
    return "team13/Team13General/Team13_Cart";
 
}

}
