package com.example.demo.team13.Team13Controller.Team13Admin.Team13Stock;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13Admin.Team13Stock.Team13AdminHomeService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@Data
public class Team13AdminHomeController {
	
	private final Team13AdminHomeService team13AdminHomeService;
	
	@GetMapping("/Team13_Admin_Home")
	public String add(Model model){
		 List<Team13Shohin> shohinData = team13AdminHomeService.findAll();
		 model.addAttribute("shohinData",shohinData);
		
	 return "team13/Team13Admin/Team13_Home";
	 
	}
	
	@PostMapping(value="/Team13_Update_Stock" ,params="shohin_id")
	public String send(@RequestParam("shohin_id") String shohin_id, @RequestParam("count") int count,Model model){
		
		Team13Shohin shohin = team13AdminHomeService.findById(shohin_id);
		
	    model.addAttribute("shohin",shohin);
	    
	    System.out.println("更新情報を送る");
	    
	    model.addAttribute("count",count);
		
		System.out.println("更新個数を送る");
		
    return "team13/Team13Admin/Team13_Update_Stock";
 
	}

}
