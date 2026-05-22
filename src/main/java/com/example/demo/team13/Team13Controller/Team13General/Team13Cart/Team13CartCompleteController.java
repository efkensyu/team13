package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Service.Team13General.Team13Cart.Team13MakeRecipt;

@Controller

public class Team13CartCompleteController {
	@Autowired
	public Team13MakeRecipt rec;
	@Autowired 
	private Team13CartInfo cartInfo;
	@GetMapping("/Team13_Cart_Complete")
	public String index() {
		
		return "team13/Team13General/Team13_Cart_Complete";
	}
	
	@PostMapping("/Team13_Cart_Complete")
	public void recipit(HttpServletResponse response) throws IOException {
			rec.makeXSSF(response,cartInfo);
			
	}
	
}
