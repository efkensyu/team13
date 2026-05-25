package com.example.demo.team13.Team13Controller.Team13General.Team13Product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13General.Team13Auth.Team13ShainService;
import com.example.demo.team13.Team13Service.Team13General.Team13Product.Team13GeneralHomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team13GeneralHomeController {
	
	private final Team13ShainService team13ShainService;
	
	private final Team13GeneralHomeService team13GeneralHomeService;
	
	@GetMapping("/Team13_General_Home")
	public String add(Model model){
		
	List<Team13Shohin> shohinData = team13GeneralHomeService.findAll();
		 model.addAttribute("shohinData",shohinData);
		 System.out.println("商品データ出力");
		 
	 return "team13/Team13General/Team13_Home";
	 
	}
	
	
	@PostMapping(value="/Team13_General_Home", params="shohin_id")
//  @PostMapping(value="/Team13_General_Home")
	public String send(Model model){
		
		System.out.println("商品情報を送る");
	
    return "team13/Team13General/Team13_Cart";
 
}
	
	
}
