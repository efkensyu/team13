package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Team13CartController {
	@Autowired Team13CartInfo cartInfo;
	@ModelAttribute("CartInfo")
	@PostMapping(value="/Team13_Buy" ,params="confirm")
	public String confirm_buy(){
		return "team13/Team13General/Team13_Cart_Confirm";
	}
	
	@PostMapping(value="/Team13_Buy" ,params="back")
	public String back_home(){
		return "team13/Team13General/Team13_Home";
	}
}
