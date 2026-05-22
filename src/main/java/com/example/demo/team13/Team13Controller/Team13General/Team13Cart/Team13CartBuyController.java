package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Team13CartBuyController {
	@Autowired 
	Team13CartInfo cartInfo;
	@PostMapping(value="/Team13_Buy_Complete" ,params="complete")
	
	public String pay_complete(){
		
		return "team13/Team13General/Team13_Pay_Complete";
	}
	
	@PostMapping(value="/Team13_Buy_Complete" ,params="back")
	
	public String back_cart(){
	
		return "team13/Team13General/Team13_Cart";
		
	}
	
	
}
