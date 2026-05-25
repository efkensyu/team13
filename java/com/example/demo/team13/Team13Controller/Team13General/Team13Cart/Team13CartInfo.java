package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Team13CartInfo {
	private String shohin_id;
	private Integer shohin_nm;
	private Integer shohin_num;
	private String shohin_price;
}
