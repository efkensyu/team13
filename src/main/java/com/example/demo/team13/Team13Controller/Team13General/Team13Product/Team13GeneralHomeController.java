package com.example.demo.team13.Team13Controller.Team13General.Team13Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team13.Session.Team13UserInfoSession;
import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Entity.Team13CartDB;
import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Service.Team13General.Team13Cart.Team13CartService;
import com.example.demo.team13.Team13Service.Team13General.Team13Product.Team13GeneralHomeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("count")
public class Team13GeneralHomeController {
	@Autowired
	Team13UserInfoSession team13UserInfoSession;
	private final Team13GeneralHomeService team13GeneralHomeService;
	private final Team13CartService team13CartService;
	
	//カート商品確認画面で変更した数量をホーム画面へ
	@GetMapping(value="/Team13_General_Home", name="count")
	public String add(Model model){
	if(team13UserInfoSession.getComp_flag() == 1) {
		 team13UserInfoSession.setCartInfo(null);
		 team13UserInfoSession.setComp_flag(0);
	 }
	
	if(team13UserInfoSession.getCartInfo() == null) {
		List<Team13CartDB>cartInfo = team13CartService.findbyCartShainId(team13UserInfoSession.getShain_id());
		System.out.println(cartInfo);
		if(cartInfo == null) {
			
		} else {
			for(Team13CartDB ca : cartInfo) {
				String shohin_id = ca.getCart_shohin_id();
				int shohin_num = ca.getCart_shohin_num();
				Team13Shohin shohin_info = team13GeneralHomeService.findById(shohin_id);
				List<Team13CartInfo> cart = new ArrayList<>();
				team13UserInfoSession.setCartInfo(cart);
				Team13CartInfo ci = new Team13CartInfo();
				ci.setShohin_id(shohin_id);
				ci.setShohin_nm(shohin_info.getShohin_nm());
		        ci.setShohin_price(shohin_info.getShohin_price());
		        ci.setShohin_num(shohin_num); // 新規なので count をセット
		        ci.setShohin_photo(team13GeneralHomeService.selectPhoto(shohin_id));
				cart.add(ci);
			}
			
		}
	}
	 List<Team13Shohin> shohinData = team13GeneralHomeService.findAll();
	 
	 for(int i = 0; i < shohinData.size(); i ++) {
		 Team13Shohin shohin = shohinData.get(i);
		 model.addAttribute("shohinData{" + i + "]",shohin);
	 }
	 
	 

	 System.out.println(team13UserInfoSession);

	 model.addAttribute("shohinData",shohinData);
	 model.addAttribute("team13UserInfoSession",team13UserInfoSession);
	 
	 
	 return "team13/Team13General/Team13_Home";
		
	}
	
	//カート商品確認画面での数量変更
	@PostMapping(value="/Team13_General_Home", name="count")
	public String add2(@RequestParam("shohin_id") List<String> shohinIdList, @RequestParam("count") List<Integer> countList,Model model) {

		for (int i = 0; i < shohinIdList.size(); i++) {
	        team13CartService.upDateCartCount(
	            shohinIdList.get(i),
	            countList.get(i)
	        );
	    }

//		System.out.println(shohinIdList);
//		System.out.println(countList);
		
		return "redirect:/Team13_General_Home";
	}
	
	@PostMapping(value="/Team13_Cart" ,params="shohin_id")
	public String send(@RequestParam("shohin_id") String shohin_id, @RequestParam("count") int count,Model model){
		Team13Shohin cartItem = team13GeneralHomeService.findById(shohin_id);
		List<Team13CartInfo> cartList = team13CartService.addCartList(cartItem,count,team13GeneralHomeService.selectPhoto(shohin_id));
		
		team13UserInfoSession.setCartInfo(cartList);
	    model.addAttribute("cartItem",cartItem);
	    model.addAttribute("count",count);
	    model.addAttribute("photo", team13GeneralHomeService.selectPhoto(shohin_id));
	    return "team13/Team13General/Team13_Cart";
	}

}
