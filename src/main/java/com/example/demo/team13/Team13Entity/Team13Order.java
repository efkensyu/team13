package com.example.demo.team13.Team13Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team13_order_tbl")

@Data
public class Team13Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tyumon_id;
	
	@Column(name="tyumon_product_id")
	private String shohin_id;
	
	@Column(name="tyumon_shain_id")
	private String shain_id;
	
	@Column(name="tyumon_at")
	private LocalDateTime order_at;
}
