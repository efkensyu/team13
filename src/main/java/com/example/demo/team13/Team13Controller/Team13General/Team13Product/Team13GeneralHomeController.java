package com.example.demo.team13.Team13Controller.Team13General.Team13Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team13.Session.Team13UserInfoSession;
import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13General.Team13Cart.Team13CartService;
import com.example.demo.team13.Team13Service.Team13General.Team13Product.Team13GeneralHomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team13GeneralHomeController {
	@Autowired
	Team13UserInfoSession team13UserInfoSession;
	private final Team13GeneralHomeService team13GeneralHomeService;
	private final Team13CartService team13AddCartService;
	
	@GetMapping("/Team13_General_Home")
	public String add(Model model){
	if(team13UserInfoSession.getComp_flag() == 1) {
		 team13UserInfoSession.setCartInfo(null);
		 team13UserInfoSession.setComp_flag(0);
	 }
	 List<Team13Shohin> shohinData = team13GeneralHomeService.findAll();
	 
	 for(int i = 0; i < shohinData.size(); i ++) {
		 Team13Shohin shohin = shohinData.get(i);
		 model.addAttribute("shohinData{" + i + "]",shohin);
	 }
	 
	 
	 
	 model.addAttribute("shohinData",shohinData);
	 model.addAttribute("team13UserInfoSession",team13UserInfoSession);
	 return "team13/Team13General/Team13_Home";
	 
	}
	
	@PostMapping(value="/Team13_Cart" ,params="shohin_id")
	public String send(@RequestParam("shohin_id") String shohin_id, @RequestParam("count") int count,Model model){
		Team13Shohin cartItem = team13GeneralHomeService.findById(shohin_id);
		List<Team13CartInfo> cartList = team13AddCartService.addCartList(cartItem,count,team13GeneralHomeService.selectPhoto(shohin_id));
		
		team13UserInfoSession.setCartInfo(cartList);
	    model.addAttribute("cartItem",cartItem);
	    model.addAttribute("count",count);
	    model.addAttribute("photo", team13GeneralHomeService.selectPhoto(shohin_id));
	    return "team13/Team13General/Team13_Cart";
	}

}
