package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Service.Team13General.Team13Cart.MakeRecipt;

@Controller
public class Team13CartCompleteController {
	public  HttpServletResponse responce;
	@GetMapping("/Team13_Cart_Complete")
	public String index() {
		
		return "team13/Team13General/Team13_Cart_Complete";
	}
	
	@SuppressWarnings("finally")
	@PostMapping("/Team13_Cart_Complete")
	public String recipit() throws IOException {
		try {
			MakeRecipt rec = new MakeRecipt();
			rec.makeXSSF(responce);
		} catch(IOException e) {
			System.out.println();
		} finally {
			return "team13/Team13General/Team13_General_Home";
		}
	}
	
}
