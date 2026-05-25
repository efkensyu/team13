package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Team13CartSession implements Serializable{
	private static final long serialVersionUID = 1L;
	private Team13CartInfo cartInfo;
	public void setCartInfo(@ModelAttribute Team13CartInfo cartInfo) {
		this.cartInfo = cartInfo;
	}
	public Team13CartInfo getCartInfo() {
		return cartInfo;
	}
}
