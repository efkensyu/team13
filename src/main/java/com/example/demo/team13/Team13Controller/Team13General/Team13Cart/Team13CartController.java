package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;

@SessionAttributes("User")
@Controller
@RequiredArgsConstructor
public class Team13CartController {
	
	@PostMapping(value="/Team13_CartIndex" ,params="confirm")
	
	public String pay_complete(){
		
		return "team13/Team13General/Team13_Pay_Complete";
		
	}
	
	@PostMapping(value="/Team13_CartIndex" ,params="back")
	
	public String back_cart(){
	
		return "team13/Team13General/Team13_Cart";
		
	}
	
}
