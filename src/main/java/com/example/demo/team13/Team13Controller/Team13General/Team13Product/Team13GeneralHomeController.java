package com.example.demo.team13.Team13Controller.Team13General.Team13Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team13.Session.Team13LoginSession;
import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13General.Team13Product.Team13GeneralHomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@Data
public class Team13GeneralHomeController {
	@Autowired
	Team13LoginSession team13loginSession;
	private final Team13GeneralHomeService team13GeneralHomeService;
	
	
	@GetMapping("/Team13_General_Home")
	public String add(Model model){
	 List<Team13Shohin> shohinData = team13GeneralHomeService.findAll();
	 model.addAttribute("shohinData",shohinData);
	 return "team13/Team13General/Team13_Home";
	 
	}
	
	@PostMapping(value="/Team13_Cart" ,params="shohin_id")
	public String send(@RequestParam("shohin_id") String shohin_id, @RequestParam("count") int count,Model model){
		
		Team13Shohin cartItem = team13GeneralHomeService.findById(shohin_id);
		System.out.println(cartItem);
	    model.addAttribute("cartItem",cartItem);
	    
	    System.out.println("商品情報を送る");
	    
	    model.addAttribute("count",count);
		
		System.out.println("商品個数を送る");
	
    return "team13/Team13General/Team13_Cart";

 
	}

}
