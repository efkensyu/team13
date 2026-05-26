package com.example.demo.team13.Team13Controller.Team13Admin.Team13Stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team13.Session.Team13AdminInfoSession;
import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13Admin.Team13Stock.Team13UpdateStockService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team13AdminUpdateStockController {
	
	@Autowired Team13AdminInfoSession team13AdminInfoSession;
	private final Team13UpdateStockService team13UpdateStockService;
	
	@GetMapping("/Team13_Admin_Update")
    public String logout(){
	  //ログイン認証
    if (team13AdminInfoSession.getKanri_id() == null) {
        return "redirect:/Team13_Admin_Login";
    }
    	
        return "team13/Team13_Admin_Home";
    }
	
	
	@PostMapping(value="/Team13_Admin_Update", params="confirm")
	
	public String update_confirm(@RequestParam("shohin_id") String shohin_id, @RequestParam("count") int count,Model model){
		
		team13UpdateStockService.updateStock(shohin_id, count);
		
	 return "redirect:/Team13_Update_Stock_Complete";
	 
	}
	
	@PostMapping(value="/Team13_Admin_Update", params="back")
	
	public String back_confirm(Model model){
		
		List<Team13Shohin> shohinData = team13UpdateStockService.findAll();
		
		model.addAttribute("shohinData", shohinData);
	
    return "redirect:/Team13_Admin_Home";
 
	}

}
