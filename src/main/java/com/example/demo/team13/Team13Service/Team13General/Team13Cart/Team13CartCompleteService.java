package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Session.Team13UserInfoSession;
import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;
import com.example.demo.team13.Team13Entity.Team13Order;
import com.example.demo.team13.Team13Repository.Team13OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13CartCompleteService {
	private final Team13OrderRepository team13OrderRepository;
	public String InsertIntoOrderTable(Team13UserInfoSession userInfo) {
//		System.out.println(userInfo);
		Team13Order order = new Team13Order();
		List<Team13CartInfo> cartData = userInfo.getCartInfo();
		for(int i = 0;i < cartData.size(); i ++) {
			LocalDateTime now = LocalDateTime.now();
			order.setShain_id(userInfo.getShain_id());
			System.out.println(userInfo.getShain_id());
			order.setShohin_id(cartData.get(i).getShohin_id());
			order.setOrder_at(now);
			team13OrderRepository.InsertIntoOrderTable(order);
		}
			
		return "Success";
	}
}
