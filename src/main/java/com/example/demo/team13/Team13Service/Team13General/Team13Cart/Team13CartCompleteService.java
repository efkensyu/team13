package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Repository.Team13OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13CartCompleteService {
	private final Team13OrderRepository team13OrderRepository;
	public String InsertIntoOrderTable() {
		team13OrderRepository.InsertIntoOrderTable();
		return "Success";
	}
}
