package com.example.demo.team13.Team13Controller.Team13Auth.Team13Login;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Team13LoginSession implements Serializable{
	private static final long serialVersionUID = 1L;
	private String shain_id;
	
	public void setShainId(String shain_id) {
		this.shain_id = shain_id;
	}
	public String getShainId() {
		return shain_id;
	}
}
