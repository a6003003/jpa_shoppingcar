package com.example.demo.dao.selectstore;

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

import com.example.demo.entity.selectstore.SelectstoreEntity;
import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;
@Repository
public interface SelectstoreDao extends JpaRepository <SelectstoreEntity,Integer>{
	@Autowired
	
	 @Query(value = "SELECT * FROM  selectstore WHERE ExtraData = ?1 and CVSStoreName=?2", nativeQuery = true)
	 public SelectstoreEntity finduserStore(String ExtraData, String CVSStoreName);
	
	
	@Query(value = "SELECT * FROM  selectstore WHERE ExtraData = ?1 and storeType=?2", nativeQuery = true)
	 public List <SelectstoreEntity> getUserStorelist(String ExtraData,String storeType);
	
	@Query(value = "SELECT * FROM  selectstore WHERE ExtraData = ?1 and CVSStoreID=?2", nativeQuery = true)
	 public SelectstoreEntity getStoredataByUser(String ExtraData,String CVSStoreID);
	
	
	
	
}