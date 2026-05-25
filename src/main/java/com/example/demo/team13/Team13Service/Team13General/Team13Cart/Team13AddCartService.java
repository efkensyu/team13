package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.team13.Session.Team13UserInfoSession;
import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Entity.Team13Shohin;

@Service
public class Team13AddCartService {
	@Autowired 
	private Team13CartInfo cartInfo; 
	@Autowired
	private Team13UserInfoSession team13UserInfoSession;
	public List<Team13CartInfo> addCartList(Team13Shohin cartItem,int count,String photo_path) {
		List<Team13CartInfo> cartList = team13UserInfoSession.getCartInfo();
//		System.out.println(cartList);
		if(cartList == null) {
			cartList = new ArrayList<>();
			team13UserInfoSession.setCartInfo(cartList);
		}  
		
		cartInfo = new Team13CartInfo();
		
		cartInfo.setShohin_id(cartItem.getShohin_id());
		cartInfo.setShohin_nm(cartItem.getShohin_nm());
		cartInfo.setShohin_price(cartItem.getShohin_price());
		cartInfo.setShohin_num(cartInfo.getShohin_num() + count);
		cartInfo.setShohin_photo(photo_path);
		
		cartList.add(cartInfo);
		return cartList;
	}
}
