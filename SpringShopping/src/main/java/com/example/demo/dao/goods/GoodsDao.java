package com.example.demo.dao.goods;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.users.UserEntity;
import java.util.List;
@Repository
public interface GoodsDao extends JpaRepository <GoodsEntity,Integer>{
	@Autowired
	@Query(value = "SELECT * FROM  items WHERE kind = ?1", nativeQuery = true)//找尋資料庫是否有kind=XX
		public List<GoodsEntity> goodskind(String kind);
	
	@Query(value = "SELECT * FROM  items WHERE title = ?1", nativeQuery = true)//自定義函數   ?1是參數 對應下面STRING
	public GoodsEntity findTitle(String title);
	
	
	@Query(value="SELECT *FROM items WHERE kind =?1 and price<=?2",nativeQuery=true)
	    public List<GoodsEntity> findPrice(String kind,Integer price);
	
	
	@Query(value="SELECT * FROM items WHERE kind LIKE ?1 and title LIKE ?2",nativeQuery=true)
    public List<GoodsEntity> findKeyWord(String kind,String title);
	
	
}