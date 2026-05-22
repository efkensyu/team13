package com.example.demo.team13.Team13Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team13.Team13Entity.Team13Shain;

@Repository
public interface Team13ShainRepository extends JpaRepository<Team13Shain,Object> {
	public List<Team13Shain> findAll();
	
	List<Team13Shain> findByShainIdAndShainEmail(String shainid, String shainemail);
}

