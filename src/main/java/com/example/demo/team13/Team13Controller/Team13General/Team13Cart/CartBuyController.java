package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CartBuyController {
	@GetMapping("/Buy")
	public String confirm_buy(){
		return "team13/Team13General/Team13_Cart_Confirm";
	}
}
