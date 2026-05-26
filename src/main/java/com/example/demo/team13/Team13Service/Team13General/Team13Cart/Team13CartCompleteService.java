package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Repository.Team13OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13CartCompleteService {
	private final Team13OrderRepository team13OrderRepository;
	public String InsertIntoOrderTable(List<Team13CartInfo> cartList) {
		for(Team13CartInfo cartData : cartList ) {
			System.out.println(cartData);
//			team13OrderRepository.InsertIntoOrderTable(cartData);
		}
		return "Success";
	}
}
