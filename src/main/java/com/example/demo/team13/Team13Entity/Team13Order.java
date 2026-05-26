package com.example.demo.team13.Team13Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team13_order_tbl")

@Data
public class Team13Order {
	@Id
	private int tyumon_id;
	private String tyumon_product_id;
	private String tyumon_shain_id;
	private String tyumon_at;
}
