package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("User")
@Controller
public class Team13PayCompleteController {
//	private final Team13CartService team13CartService;
	
	@ModelAttribute("User")
	public User setupSession() {
		return new User();
	}

	@GetMapping("/Team13_Pay_Complete")
	public String index(Model model) {
		
		return "team13/Team13General/Team13_Cart";
	}
	
}
