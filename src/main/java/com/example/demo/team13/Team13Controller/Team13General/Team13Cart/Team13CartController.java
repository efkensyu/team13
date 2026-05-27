package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Session.Team13UserInfoSession;

@Controller

public class Team13CartController {
	@Autowired
	private Team13UserInfoSession team13UserInfoSession;
	@PostMapping(value="/Team13_Cart_Confirm")
	public String confirm_buy(Model model){
		List<Team13CartInfo> cartList = team13UserInfoSession.getCartInfo();
		int sumPrice = 0;
		for(Team13CartInfo ci : cartList) {
			sumPrice = sumPrice + ci.getShohin_price() * ci.getShohin_num();
		}
		model.addAttribute("sumPrice",sumPrice);
		model.addAttribute("cartList",cartList);
		return "team13/Team13General/Team13_Cart_Confirm";
	}
}
