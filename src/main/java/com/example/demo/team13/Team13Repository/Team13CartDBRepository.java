package com.example.demo.team13.Team13Repository;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team13.Team13Entity.Team13CartDB;

@Repository
public interface Team13CartDBRepository extends JpaRepository<Team13CartDB,Integer>{
	
	@Modifying
	@Transactional
	@Query(value="""
    insert into team13_cart_shohin_tbl(cart_shohin_id, cart_shain_id, cart_shohin_num)
    values(:#{#cart.cart_shohin_id},
           :#{#cart.cart_shain_id},
           :#{#cart.cart_shohin_num})
    """, nativeQuery=true)
	public void InsertIntoCartShohinTbl(@Param("cart") Team13CartDB cartDB);
	
	
	@Modifying
	@Transactional
	@Query(value="""
		    delete from team13_cart_shohin_tbl
		    where cart_shain_id = :shain_id
		    """, nativeQuery=true)
	public void DeleteFromCartShohinRecordByShainId(@Param("shain_id") String shain_id);
	
	@Query(value="""
		    select * from team13_cart_shohin_tbl
		    where cart_shain_id = :shain_id
		    """, nativeQuery=true)
	public List<Team13CartDB> findByCartShainId(@Param("shain_id")String shain_id);
}
