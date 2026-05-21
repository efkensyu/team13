package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.util.List;

import com.example.demo.team13.Team13Entity.Team13CartShohin;
import com.example.demo.team13.Team13Repository.Team13CartShohinRepository;

public class Team13CartService {
	private  Team13CartShohinRepository repository;
	public List<Team13CartShohin> findAll(String shain_id){
		return repository.findAll();
	}
}
