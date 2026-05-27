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
		
		boolean found = false;

	    // 既存のカートアイテムをチェック
	    for (Team13CartInfo info : cartList) {
	        if (info.getShohin_id().equals(cartItem.getShohin_id())) {
	            // 同じ商品が既に存在する場合は数量を加算
	            info.setShohin_num(info.getShohin_num() + count);
	            found = true;
	            break;
	        }
	    }

	    // 存在しなければ新規追加
	    if (!found) {
	        Team13CartInfo cartInfo = new Team13CartInfo();
	        cartInfo.setShohin_id(cartItem.getShohin_id());
	        cartInfo.setShohin_nm(cartItem.getShohin_nm());
	        cartInfo.setShohin_price(cartItem.getShohin_price());
	        cartInfo.setShohin_num(count); // 新規なので count をセット
	        cartInfo.setShohin_photo(photo_path);
	        cartList.add(cartInfo);
	    }
	    
	    
	    return cartList;
	}
	
	
//		public void upDateCartCount(Team13CartInfo cartInfo) {
//			
//			List<Team13CartInfo> cartList = team13UserInfoSession.getCartInfo();
//			
//			if(count <= 0) {
//				
//				return;
//				
//			}
			
//		for(Team13CartInfo info : cartList) {
//			
//			if(info.getShohin_id().equals(cartInfo.getShohin_id())) {
//				
//				info.setShohin_num(cartInfo.getShohin_num());
//				
//				break;
//				
//				}
			
			public void upDateCartCount(String shohin_id, int count) {

			    List<Team13CartInfo> cartList = team13UserInfoSession.getCartInfo();

			    for (Team13CartInfo info : cartList) {
			        if (info.getShohin_id().equals(shohin_id)) {
			            info.setShohin_num(count);
			            break;
			        }
			    }
			}
			
		
}
	

