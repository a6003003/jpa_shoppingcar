package com.example.demo.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.users.UserDao;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.IUserService;

import coustomresponse.CustomResponseEntity;



@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;


	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
	    
		return userDao.save(userEntity);
	}


	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userDao.saveAndFlush(userEntity);
	}


	


	/*@Override
	public UserEntity getUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId).get();

	}*/


	/*@Override
	public void delUser(Integer userId) {
		// TODO Auto-generated method stub
		userDao.deleteById(userId);
	}*/
	@Override
	public UserEntity findAllUsername(String username) {
		UserEntity tmp = userDao.findAllUsername(username);//建一個表tmp=Dao層找到的username
		if(tmp!=null)//如果不等於null 代表有找到
			return tmp;//回傳那筆資料
		else
		    return null;
	}
	
	@Override
	public CustomResponseEntity login(String username,String password) {
		CustomResponseEntity response =new  CustomResponseEntity () ;
		UserEntity tmp=userDao.login(username,password);
		if(tmp!=null) {
			tmp.setToken(getSHA256(username));//登入成功頒發token
			userDao.saveAndFlush(tmp);
			response.setMsg("login Success");
			response.setUserEntity(tmp);
		}
		else {
		response.setMsg("login fail");
		}
		
		return response;
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
	public CustomResponseEntity register(String name,String username,String password,String phonenumber,String address) {
		// TODO Auto-generated method stub
		CustomResponseEntity response =new  CustomResponseEntity ();
		UserEntity checkUsername=userDao.findAllUsername(username);//檢查帳號重複
		UserEntity checkName=userDao.findname(name);//檢查名子重複
		if(checkUsername==null&&checkName==null) {
			checkUsername = new UserEntity();
			checkUsername.setUsername(username);
			checkUsername.setPassword(password);
			checkUsername.setName(name);
			checkUsername.setAddress(address);
			checkUsername.setPhonenumber(phonenumber);
			checkUsername.setRole("[{\"name\":\"首頁\",\"path\":\"/\"},{\"name\":\"使用者資訊\",\"path\":\"/UserInfo\"},{\"name\":\"賣家中心\",\"path\":\"/Seller\"},{\"name\":\"購物清單\",\"path\":\"/goodlist\"},{\"name\":\"聊聊\",\"path\":\"/Chatroom\"},{\"name\":\"註冊\",\"path\":\"/register\"},{\"name\":\"拍賣中心\",\"path\":\"/sales\"},{\"name\":\"購物車\",\"path\":\"/shoppingcar\"},{\"name\":\"飲料\",\"path\":\"/drink\"}, {\"name\":\"美食\",\"path\":\"/food\"},{\"name\":\"點心\",\"path\":\"/dessert\"}, {\"name\":\"健身必吃\",\"path\":\"/workout\"}]");
			userDao.save(checkUsername);//新增一筆
			response.setStatus("200");
			response.setData("staus:ok");
			response.setMsg("註冊成功");
			response.setUserEntity(checkUsername);
			return response;
			
		}
		else if(checkUsername!=null&&checkName==null){
			response.setStatus("404");
			response.setData("staus:fail");
			response.setMsg("帳號已有人使用");
			return response;
		}
		else if(checkUsername==null&&checkName!=null){
			response.setStatus("404");
			response.setData("staus:fail");
			response.setMsg("名子已有人使用");
			return response;
		}
		return response;
		
	}
	@Override
	public CustomResponseEntity getUser(String username) {
		CustomResponseEntity response =new  CustomResponseEntity () ;
		UserEntity tmp=userDao.findAllUsername(username);
		if(tmp!=null) {
			response.setUserEntity(tmp);
			return response;
		}
		
		return response;
	}


	@Override
	public CustomResponseEntity getAllUser() {
		// TODO Auto-generated method stub
		CustomResponseEntity response =new  CustomResponseEntity();
		response.setUserEntitys(userDao.findAll());
		return response;
	}


	@Override
	public CustomResponseEntity findAllUsersToken(String token) {
		CustomResponseEntity response =new  CustomResponseEntity () ;
		UserEntity userstoken=userDao.findAllUsersToken(token);
		if(userstoken!=null) {
			response.setStatus("200");
			response.setMsg("isLogin");
			response.setUserEntity(userstoken);
		}
		else{
			response.setStatus("404");
			response.setMsg("notLogin");
		}
		
		return response;
	}


	@Override
	public List<UserEntity> getdAllUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserEntity findname(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}