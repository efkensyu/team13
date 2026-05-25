package com.example.demo.team13.Session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope
@Data
public class Team13CartConfirmSession {
	private String shohin_id;
	private String shohin_nm;
	private int shohin_num;
	private int shohin_price;
	private String shohin_photo;
}
