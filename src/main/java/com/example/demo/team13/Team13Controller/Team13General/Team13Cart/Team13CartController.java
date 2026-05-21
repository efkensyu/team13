package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;

@SessionAttributes("User")
@Controller
@RequiredArgsConstructor
public class Team13CartController {

	@GetMapping("/Team13_CartIndex")
	public String index() {
		return "team13/Team13General/Team13_Cart";
	}
	
}
