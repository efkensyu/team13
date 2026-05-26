package com.example.demo.team13.Team13Service.Team13General.Team13Product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Repository.Team13ShohinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13GeneralHomeService {
	
	private final Team13ShohinRepository repository;
	
	public List<Team13Shohin> findAll(){
		 return repository.findAll();
	}
	
	public Team13Shohin findById(String shohin_id) {
		
		return repository.findById(shohin_id).orElse(null);
		
	}
	
	public String selectPhoto(String shohin_id) {
		
		switch (shohin_id) {
		case "A0001":{
			return "/Team13/Team13images/Team13ボルT.png";
		}
		case "A0002":{
			return "/Team13/Team13images/Team13ボールドペン.png";
		}
		case "A0003":{
			return "/Team13/Team13images/Team13ボルシャツ.png";
		}
		case "A0004":{
			return "/Team13/Team13images/Team13ボルパカ.png";
		}
		case "A0005":{
			return "/Team13/Team13images/Team13社章.png";
		}
		}
		
		return "";
	}
	 
	public String selectPhoto(List<Team13CartInfo> cartList) {
		
	for(int i = 0 ; i < cartList.size(); i ++ ) {
		String shohin_id = cartList.get(i).getShohin_id();
		switch (shohin_id) {
		case "A0001":{
			return "/Team13/Team13images/Team13ボルT.png";
		}
		case "A0002":{
			return "/Team13/Team13images/Team13ボールドペン.png";
		}
		case "A0003":{
			return "/Team13/Team13images/Team13ボルシャツ.png";
		}
		case "A0004":{
			return "/Team13/Team13images/Team13ボルパカ.png";
		}
		case "A0005":{
			return "/Team13/Team13images/Team13社章.png";
		}
		}
	}
		return "";
	}
}


