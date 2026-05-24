package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team13.Team13Controller.Team13Auth.Team13Login.Team13UserInfoSession;

@Controller
public class Team13CartController {
	@Autowired 
	Team13UserInfoSession userInfo;
	@ModelAttribute("userInfo")
	
	@GetMapping("/Team13_Cart")
	public String cart_index() {
		return "team13/Team13General/Team13_Cart";
	}
	
	@PostMapping(value="/Team13_Cart" ,params="shohin_id")
	public String confirm_buy(@RequestParam String shohin_id){
		return "team13/Team13General/Team13_Cart";
	}
	
	@PostMapping(value="/Team13_Cart" ,params="back")
	public String back_home(){
		return "team13/Team13General/Team13_Home";
	}
}
