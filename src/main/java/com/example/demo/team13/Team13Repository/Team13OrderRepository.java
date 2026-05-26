package com.example.demo.team13.Team13Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team13.Team13Entity.Team13Order;

public interface Team13OrderRepository extends JpaRepository<Team13Order,Integer>{
//	@Query(value="insert into order_tbl values();", nativeQuery=true)
//	public void InsertIntoOrderTable(@Param(value = "cartData")Team13CartInfo cartData);
//	@Query(value="select * from bumon_tbl where bumon_cd = :code",nativeQuery = true)
//	public List<Bumon> findBumonCd(@Param("code") String code);
}
