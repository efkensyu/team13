package com.example.demo.team13.Team13Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team13.Team13Entity.Team13Admin;

@Repository
public interface Team13AdminRepository extends JpaRepository<Team13Admin,Object> {
	public List<Team13Admin> findAll();
	
	List<Team13Admin> findByKanriIdAndKanriPass(String kanriid, String kanripass);
}

