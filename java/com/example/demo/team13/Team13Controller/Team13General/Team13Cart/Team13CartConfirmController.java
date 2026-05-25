package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Controller.Team13Auth.Team13Login.Team13UserInfoSession;

@Controller

public class Team13CartConfirmController {
	@Autowired 
	Team13UserInfoSession userInfo;
	
	@PostMapping(value="/Team13_Cart_Confirm", params="index")
	public String Confirm_index() {
		System.out.println("デバッグ");
		return "team13/Team13General/Team13_Cart_Confirm";
	}
	
	@PostMapping(value="/Team13_Confirm" ,params="back")
	
	public String back_cart(){
	
		return "team13/Team13General/Team13_Home";
		
	}
}
