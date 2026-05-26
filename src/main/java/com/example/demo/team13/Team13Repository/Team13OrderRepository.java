package com.example.demo.team13.Team13Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team13.Team13Entity.Team13Order;

public interface Team13OrderRepository extends JpaRepository<Team13Order,String>{
	@Query(value="insert into order_tbl values(:shohin_id,:shain_id,:tyumon_at)")
	public void InsertIntoOrderTable();
}
