package com.example.demo.dao.chatroom;

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

import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;
@Repository
public interface ChatRoomDao extends JpaRepository <ChatRoomEntity,Integer>{
	@Autowired
	@Query(value = "SELECT * FROM  chatroommaping WHERE Receiver = ?1 and Sender = ?2", nativeQuery = true)
	public ChatRoomEntity FindChatRoomByUserID(String receiver,String sender);
	
	@Query(value = "SELECT * FROM  chatroommaping WHERE Receiver = ?1 or Sender =?2", nativeQuery = true)
	public List<ChatRoomEntity> CheckinChatRoom(String receiver, String sender);
	 
	@Query(value = "SELECT * FROM  chatroommaping WHERE Sender =?1", nativeQuery = true)
	public List<ChatRoomEntity> SelectChatRoomByUserId(String UserId);
	
}