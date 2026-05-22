package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;

@SessionAttributes("User")
@Controller
@RequiredArgsConstructor
public class Team13CartConfirmController {
	
	@PostMapping(value="/Team13_Cart_Confirm" ,params="complete")
	
	public String pay_complete(){
		
		return "team13/Team13General/Team13_Cart_Complete";
		
	}
	
	@PostMapping(value="/Team13_Cart_Confirm" ,params="back")
	
	public String back_cart(){
	
		return "team13/Team13General/Team13_Cart";
		
	}
	
	
}
