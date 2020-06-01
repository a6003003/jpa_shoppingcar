package com.example.demo.dao.shoppingcar;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import java.util.List;
@Repository
public interface ShoppingCarDao extends JpaRepository <ShoppingCarEntity,Integer>{
	@Query(value = "SELECT * FROM  shoppingcar WHERE username = ?1 and item = ?2", nativeQuery = true)
		public ShoppingCarEntity getCar(String username,String itemname);
	@Query(value = "SELECT * FROM  shoppingcar WHERE username = ?1", nativeQuery = true)
	public List<ShoppingCarEntity> getAllShoppingCar(String username);
}