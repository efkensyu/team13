package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Team13CartController {
	
	@PostMapping(value="/Team13_Cart" ,params="confirm")
	public String confirm_buy(){
		return "team13/Team13General/Team13_Cart_Confirm";
	}
	
	@PostMapping(value="/Team13_Cart" ,params="back")
	public String back_home(){
		return "team13/Team13General/Team13_Home";
	}
}
