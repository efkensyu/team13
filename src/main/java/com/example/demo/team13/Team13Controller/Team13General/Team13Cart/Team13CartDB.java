package com.example.demo.team13.Team13Controller.Team13General.Team13Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team13_cart_shohin_tbl")

@Data
public class Team13CartDB {
	private int cart_id;
	private String cart_shohin_id;
	private String cart_shain_id;
	private int cart_shohin_num;
}
