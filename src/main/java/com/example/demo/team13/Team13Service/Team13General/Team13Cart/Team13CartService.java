package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.team13.Session.Team13UserInfoSession;
import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Entity.Team13CartDB;
import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Repository.Team13CartDBRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13CartService {
	@Autowired
	private Team13CartDBRepository cartDBRepository;
	@Autowired 
	private Team13CartInfo cartInfo; 
	@Autowired
	private Team13UserInfoSession team13UserInfoSession;
	
	private Team13CartDB cartDB;
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
	        cartList.add(cartInfo);}

	    Team13CartDB cart = new Team13CartDB();
	    cart.setCart_shain_id(team13UserInfoSession.getShain_id());
	    cart.setCart_shohin_id(cartItem.getShohin_id());
	    cart.setCart_shohin_num(count);
	    cartDBRepository.InsertIntoCartShohinTbl(cart);
//	    cartDB.setCart_shain_id(team13UserInfoSession.getShain_id());
	    
	    return cartList;
	    
	}

			public void upDateCartCount(String shohin_id, int count) {

			    List<Team13CartInfo> cartList = team13UserInfoSession.getCartInfo();

			    for (Team13CartInfo info : cartList) {
			        if (info.getShohin_id().equals(shohin_id)) {
			            info.setShohin_num(count);
			            break;
			        }
			    }
			}
			
		

	
	public List<Team13CartDB> findbyCartShainId(String shain_id) {
		return cartDBRepository.findByCartShainId(shain_id);
	}
	
}

	

