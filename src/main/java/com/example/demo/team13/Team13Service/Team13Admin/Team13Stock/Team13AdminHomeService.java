package com.example.demo.team13.Team13Service.Team13Admin.Team13Stock;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Repository.Team13ShohinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13AdminHomeService {

private final Team13ShohinRepository repository;
	
public List<Team13Shohin> findAll(){
	 return repository.findAll();
}

public Team13Shohin findById(String shohin_id) {
	
	return repository.findById(shohin_id).orElse(null);
	
}
	
}
