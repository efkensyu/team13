package com.example.demo.team13.Team13Controller.Team13Admin.Team13Stock;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13AdminUpdateStockController {
	
	@PostMapping(value="/Team13_Admin_Update", params="confirm")
	
	public String update_confirm(){
		
	 return "team13/Team13Admin/Team13_Update_Stock_Complete";
	 
	}
	
	@PostMapping(value="/Team13_Admin_Update", params="back")
	
	public String back_confirm(){
	
    return "team13/Team13Admin/Team13_Home";
 
	}

}
