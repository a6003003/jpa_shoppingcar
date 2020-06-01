package com.example.demo.dao.goodlist;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext; 

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.goodlist.GoodlistEntity;    
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;
@Repository
public interface GoodlistDao extends JpaRepository <GoodlistEntity,Integer>{
	@Autowired
	@Query(value = "SELECT * FROM  goodlist WHERE seller = ?1", nativeQuery = true)//賣家定單
	public List <GoodlistEntity> findUsergoodlistBySeller(String seller);
	 
	@Query(value = "SELECT * FROM  goodlist WHERE username = ?1", nativeQuery = true)//買家定單
	public List <GoodlistEntity> findUsergoodlistByUsername(String username);
	
	@Query(value = "SELECT * FROM  goodlist WHERE MerchantTradeNo = ?1", nativeQuery = true)//定單編號找定單
	public GoodlistEntity findUsergoodlistByMerchantTradeNo(String MerchantTradeNo);
	
}