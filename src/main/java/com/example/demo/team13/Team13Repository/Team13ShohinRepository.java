package com.example.demo.team13.Team13Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team13.Team13Entity.Team13Shohin;

@Repository
public interface Team13ShohinRepository extends JpaRepository<Team13Shohin,String> {
	public List<Team13Shohin> findAll();
}

