package com.example.demo.team13.Team13Repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team13.Team13Entity.Team13Order;

@Repository
public interface Team13OrderRepository extends JpaRepository<Team13Order,Integer>{
	@Modifying
	@Transactional
	@Query(value="""
		    insert into team13_order_tbl(tyumon_shain_id, tyumon_product_id, tyumon_at)
		    values(:#{#order.shain_id},
		           :#{#order.shohin_id},
		           :#{#order.order_at})
		    """, nativeQuery=true)
	public void InsertIntoOrderTable(@Param(value = "order")Team13Order order);
}
