package com.example.demo.team13.Session;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope

@Data
public class Team13LoginSession implements Serializable{
	private static final long serialVersionUID = 1L;
	private String shain_id;
	private String shain_nm;
	private String shain_adress;
	private String shain_tell;
	private String shain_email;
	
}
