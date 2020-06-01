package com.example.demo.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.chatroom.ChatRoomDao;
import com.example.demo.dao.chatroomhistory.ChatRoomHistoryDao;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.chatroomHistory.ChatRoomHistoryEntity;
import com.example.demo.entity.goodlist.GoodlistEntity;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.IChatRoomService;
import com.example.demo.service.IChatRoomhistoryService;

import com.example.demo.service.IGoodsService;

import coustomresponse.CustomResponseEntity;



@Service
public class ChatRoomhistoryServiceImp implements IChatRoomhistoryService {
	@Autowired
	private ChatRoomHistoryDao chatroomhistoryDao;


	@Override
	public ChatRoomHistoryEntity InsertRoomID(String roomid, String receiver, String sender, String msg) {
		// TODO Auto-generated method stub
		ChatRoomHistoryEntity tmp = new ChatRoomHistoryEntity();
		tmp.setRoomID(roomid);
		tmp.setReceiver(receiver);
		tmp.setSender(sender);
		tmp.setMassageHistory(msg);
		return chatroomhistoryDao.save(tmp);
		
		//return chatroomhistoryDao.save();
	}

	@Override
	public List<ChatRoomHistoryEntity> SelectChatRoomByRoomId(String roomid) {
		// TODO Auto-generated method stub
		return chatroomhistoryDao.SelectChatRoomByRoomId(roomid);
	}




	
	



}
