package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Team13CartController {
	
	@PostMapping(value="/Team13_Cart_Confirm")
	public String confirm_buy(){
		return "team13/Team13General/Team13_Cart_Confirm";
	}
}
