package com.example.demo.team13.Team13Controller.Team13Auth.Team13Login;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;

@Component
@SessionScope
public class Team13UserInfoSession implements Serializable{
	private static final long serialVersionUID = 1L;
	private String shain_id;
	private List<Team13CartInfo> cart_info;
	
	public void setShainId(String shain_id) {
		this.shain_id = shain_id;
	}
	public String getShainId() {
		return shain_id;
	}
	public void setCartShohinInfo(Team13CartInfo cart_info) {
		this.cart_info.add(cart_info);
	}
	public List<Team13CartInfo> getCartShohinInfo() {
		return cart_info;
	}
}
