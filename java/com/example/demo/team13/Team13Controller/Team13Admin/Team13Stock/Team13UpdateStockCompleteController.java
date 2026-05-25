package com.example.demo.team13.Team13Controller.Team13Admin.Team13Stock;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Team13UpdateStockCompleteController {
//	private final Team13CartService team13CartService;
	
	

	@GetMapping("/Team13_Update_Stock_Complete")
	public String index(Model model) {
		
		return "team13/Team13Admin/Team13_Home";
	}
	
}
