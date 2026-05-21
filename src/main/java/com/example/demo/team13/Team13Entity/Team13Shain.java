package com.example.demo.team13.Team13Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team13_shain_tbl")

@Data
public class Team13Shain {
	@Id
	private String shain_id;
	private String shain_nm;
	private String shain_adress;
	private String shain_email;
	private String shain_tell;
	
}
