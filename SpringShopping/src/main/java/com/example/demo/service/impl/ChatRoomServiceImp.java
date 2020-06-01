package com.example.demo.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.chatroom.ChatRoomDao;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.goodlist.GoodlistEntity;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.IChatRoomService;

import com.example.demo.service.IGoodsService;

import coustomresponse.CustomResponseEntity;



@Service
public class ChatRoomServiceImp implements IChatRoomService {
	@Autowired
	private ChatRoomDao chatroomDao;

	@Override
	public CustomResponseEntity CheckinChatRoom(String receiver, String sender) {//建立聊天室 給房號
	    CustomResponseEntity response =new  CustomResponseEntity() ;
		ChatRoomEntity tmp  =chatroomDao.FindChatRoomByUserID(receiver, sender);//找尋有無聊天室
		if(tmp == null)//沒有的話 建立聊天室
		{
			tmp = new ChatRoomEntity();
			tmp.setReceiver(receiver);
			tmp.setSender(sender);
			String sha = getSHA256(receiver+sender);//房間號碼
			tmp.setRoomID(sha);
			chatroomDao.save(tmp);
		}
		return null;
	}




    public static String getSHA256(String input){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(input.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }

	@Override
	public CustomResponseEntity SelectChatRoomByUserId(String UserId) {//當賣家按聊聊時 傳送者與接收者互換
		// TODO Auto-generated method stub
		CustomResponseEntity response =new  CustomResponseEntity() ;
		List<ChatRoomEntity> tmp= chatroomDao.SelectChatRoomByUserId(UserId);
		for(int i = 0 ; i <tmp.size() ;i++)
		{
			if(tmp.get(i).getReceiver().equals(UserId) ) {
				String change =tmp.get(i).getReceiver();
				tmp.get(i).setReceiver(tmp.get(i).getSender());
				tmp.get(i).setSender(change);
			}
		}
		response.setChatroomEntitys(tmp);
		return response;
		
	}



	
	



}
