package com.example.demo.team13.Team13Service.Team13Admin.Team13Stock;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Entity.Team13Shohin;
import com.example.demo.team13.Team13Repository.Team13ShohinRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class Team13UpdateStockService {
	
	private final Team13ShohinRepository team13ShohinRepository;
	
	public List<Team13Shohin> findAll(){
		 return team13ShohinRepository.findAll();
	}
	
	public void updateStock(String shohin_id, int count) {
	
		Team13Shohin shohin = team13ShohinRepository.findById(shohin_id).orElse(null);
		
		if(shohin != null) {
			
			int newStock = shohin.getShohin_stock() + count;
						
             if(newStock < 0) {
			
			     newStock = 0;
			
		 }
             
         shohin.setShohin_stock(newStock);
         
         team13ShohinRepository.save(shohin);
         
         System.out.println("shohin_id = " + shohin_id);
         System.out.println("count = " + count);
         System.out.println("shohin = " + shohin);
		
		}
}
}

