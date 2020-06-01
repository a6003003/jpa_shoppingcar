package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.goods.GoodsEntity;

import coustomresponse.CustomResponseEntity;




public interface IChatRoomService {
	
	public CustomResponseEntity CheckinChatRoom(String receiver, String sender);
	public CustomResponseEntity SelectChatRoomByUserId(String UserId);
	//public List<ChatRoomEntity> SelectChatRoomByUserId(String UserId);
}
