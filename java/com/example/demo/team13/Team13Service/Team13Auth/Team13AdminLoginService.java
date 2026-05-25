package com.example.demo.team13.Team13Service.Team13Auth;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.team13.Team13Entity.Team13Admin;
import com.example.demo.team13.Team13Repository.Team13AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team13AdminLoginService {

	private final Team13AdminRepository repository;
	//ID・メール認証
	public Boolean isPass(Team13Admin admin) {
		List <Team13Admin> result = repository.findByKanriIdAndKanriPass(admin.getKanriId(),admin.getKanriPass());
		if(result.size() > 0 ) {
			return true;
		}
		return false;
	}
	//社員情報取得
	public Optional<Team13Admin> getShainById(String kanri_id) {
		return repository.findById(kanri_id);
				
	}
}