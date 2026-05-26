package com.example.demo.team13.Session;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope
@Data
public class Team13AdminInfoSession implements Serializable{
	private static final long serialVersionUID = 1L;

	private String kanri_id;
	private String kanri_nm;
	private String kanri_pass;
}
