package com.example.demo.dao.chatroomhistory;

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

import com.example.demo.entity.chatroomHistory.ChatRoomHistoryEntity;
import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;
@Repository
public interface ChatRoomHistoryDao extends JpaRepository <ChatRoomHistoryEntity,Integer>{
	@Autowired
	@Query(value = "SELECT * FROM  chatroom WHERE roomid = ?1", nativeQuery = true)
	public List<ChatRoomHistoryEntity> SelectChatRoomByRoomId(String roomid);
	
	
}