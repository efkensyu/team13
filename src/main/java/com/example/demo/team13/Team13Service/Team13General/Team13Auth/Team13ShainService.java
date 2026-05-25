package com.example.demo.team13.Team13Service.Team13General.Team13Auth;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Entity.Team13Shain;
import com.example.demo.team13.Team13Repository.Team13ShainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13ShainService {
	private final Team13ShainRepository repository;
	
	public List<Team13Shain> findAll(){
		return repository.findAll();
	}
}
