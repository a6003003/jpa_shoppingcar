package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.chatroomHistory.ChatRoomHistoryEntity;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.impl.ChatRoomServiceImp;
import com.example.demo.service.impl.ChatRoomhistoryServiceImp;
import com.example.demo.service.impl.GoodsServiceImpl;
import com.example.demo.service.impl.ShoppingcarServiceImpl;

import com.google.gson.Gson;
import coustomresponse.CustomResponseEntity;




@RestController
@RequestMapping("/chat")
public class ChatRoomController {
	@Autowired
	ChatRoomServiceImp chatroomService;
    @Autowired
	private ChatRoomhistoryServiceImp chatroomhistoryService;
    
    
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/get/{receiver}/{sender}")
	public CustomResponseEntity CheckinChatRoom(@PathVariable(name = "receiver") String receiver,@PathVariable(name = "sender") String sender)
	
	{
		
		return  chatroomService.CheckinChatRoom(receiver, sender);
	}
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/selectchatroom/{UserId}")
	public CustomResponseEntity SelectChatRoomByUserId(@PathVariable(name = "UserId") String UserId)
	
	{
		
		return  chatroomService.SelectChatRoomByUserId(UserId);
	}	
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/selectchatroombyroomid/{roomid}")
	public String SelectChatRoomByRoomId(@PathVariable(name = "roomid") String roomid)
	{
		System.out.print(roomid);
		 List<ChatRoomHistoryEntity> tmp =chatroomhistoryService.SelectChatRoomByRoomId(roomid);
		 Gson gson = new Gson();
		 System.out.print( gson.toJson(tmp ));
		return   gson.toJson(tmp );
	}	
	
	

}
