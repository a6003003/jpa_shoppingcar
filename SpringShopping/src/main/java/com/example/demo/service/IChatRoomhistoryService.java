package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.users.UserDao;
import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.chatroomHistory.ChatRoomHistoryEntity;
import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;


public interface IChatRoomhistoryService {

	ChatRoomHistoryEntity InsertRoomID(String roomid,String receiver,String sender ,String msg);
     
     List<ChatRoomHistoryEntity> SelectChatRoomByRoomId(String roomid);
    
     
}