package com.example.demo.team13.Team13Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team13_cart_shohin_tbl")
@Data
public class Team13CartDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	private String shohin_id;
	private String cart_shain_id;
	private int cart_shohin_num;
}
