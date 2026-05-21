package com.example.demo.team13.Team13Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team13.Team13Entity.Team13CartShohin;

@Repository
public interface Team13CartShohinRepository extends JpaRepository<Team13CartShohin, String> {
	public List<Team13CartShohin> findAll();
}
