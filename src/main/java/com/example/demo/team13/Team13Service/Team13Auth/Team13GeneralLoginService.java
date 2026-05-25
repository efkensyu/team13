package com.example.demo.team13.Team13Service.Team13Auth;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Entity.Team13Shain;
import com.example.demo.team13.Team13Repository.Team13ShainRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13GeneralLoginService {
	
	private final Team13ShainRepository repository;
	//ID・メール認証
	public Boolean isPass(Team13Shain shain) {
		List <Team13Shain> result = repository.findByShainIdAndShainEmail(shain.getShainId(),shain.getShainEmail());
		if(result.size() > 0 ) {
			return true;
		}
		return false;
	}
	//社員情報取得
	public Optional<Team13Shain> getShainById(String shain_id) {
		return repository.findById(shain_id);
				
	}
	
	
}
