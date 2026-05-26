package com.example.demo.team13.Team13Controller.Team13Admin.Team13Stock;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13Admin.Team13Stock.Team13UpdateStockService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team13AdminUpdateStockController {
	
	private final Team13UpdateStockService team13UpdateStockService;
	
	@PostMapping(value="/Team13_Admin_Update", params="confirm")
	
	public String update_confirm(@RequestParam("shohin_id") String shohin_id, @RequestParam("count") int count,Model model){
		
		team13UpdateStockService.updateStock(shohin_id, count);
		
	 return "team13/Team13Admin/Team13_Update_Stock_Complete";
	 
	}
	
	@PostMapping(value="/Team13_Admin_Update", params="back")
	
	public String back_confirm(Model model){
		
		List<Team13Shohin> shohinData = team13UpdateStockService.findAll();
		
		model.addAttribute("shohinData", shohinData);
	
    return "team13/Team13Admin/Team13_Home";
 
	}

}
