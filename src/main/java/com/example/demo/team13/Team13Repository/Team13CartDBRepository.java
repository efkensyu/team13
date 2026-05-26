package com.example.demo.team13.Team13Repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.team13.Team13Entity.Team13CartDB;

public interface Team13CartDBRepository extends JpaRepository<Team13CartDB,Integer>{
	
	@Modifying
	@Transactional
	@Query(value="""
    insert into team13_cart_shohin_tbl(cart_shohin_id, cart_shain_id, cart_shohin_num)
    values(:#{#cart.cart_shain_id},
           :#{#cart.cart_shohin_id},
           :#{#cart.cart_shohin_num})
    """, nativeQuery=true)
	public void InsertIntoCartShohinTbl(@Param("cart") Team13CartDB cartDB);
}
