package com.example.demo.dao.users;

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

import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;
@Repository
public interface UserDao extends JpaRepository <UserEntity,Integer>{
	@Autowired
	
	 @Query(value = "SELECT * FROM  password WHERE token = ?1", nativeQuery = true)//找資料庫有沒有此token
	public UserEntity findAllUsersToken(String token);
	 
	@Query(value = "SELECT * FROM  password WHERE username = ?1", nativeQuery = true)//檢查帳號重複
		public UserEntity findAllUsername(String username);
	
	@Query(value = "SELECT * FROM  password WHERE name = ?1", nativeQuery = true)//檢查名子重複
	public UserEntity findname(String name);
	 
	 @Query(value = "SELECT * FROM  password WHERE username = ?1 and password =?2", nativeQuery = true)//找資料庫有沒有此組帳密
		public UserEntity login(String username,String password);
	 
	 
	
}