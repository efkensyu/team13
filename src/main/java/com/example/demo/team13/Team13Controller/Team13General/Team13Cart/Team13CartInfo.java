package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Team13CartInfo {
	private String shohin_id;
	private String shohin_nm;
	private int shohin_num;
	private int shohin_price;
}
