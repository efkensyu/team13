package com.example.demo.team13.Team13Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team13_shohin_tbl")

@Data
public class Team13Shohin {
	@Id
	private String shohin_id;
	private String shohin_nm;
	private String shohin_price;
	private String shohin_stock;
	
}
