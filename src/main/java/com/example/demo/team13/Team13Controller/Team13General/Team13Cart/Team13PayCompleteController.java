package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Service.Team13General.Team13Cart.Team13MakeRecipt;

@Controller
public class Team13PayCompleteController {
	@Autowired
	public  HttpServletResponse response;
	@GetMapping("/Team13_Pay_Complete")
	public String index() {
		
		return "team13/Team13General/Team13_Pay_Complete";
	}
	
	@PostMapping("/Team13_Pay_Complete")
	public String recipit() throws IOException {
		try {
			Team13MakeRecipt rec = new Team13MakeRecipt();
			rec.makeXSSF(response,"a");
		} catch(IOException e) {
			return "Team13_Error";
		} finally {
			System.out.println("判定");
		}
		
		return "team13/Team13General/Team13_Pay_Complete";
	}
	
}
