package com.example.demo.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.selectstore.SelectstoreDao;
import com.example.demo.dao.users.UserDao;
import com.example.demo.entity.selectstore.SelectstoreEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.ISelectstoreService;
import com.example.demo.service.IUserService;

import coustomresponse.CustomResponseEntity;



@Service
public class SelectstoreServiceImpl implements ISelectstoreService {
	@Autowired
	private SelectstoreDao selectstoreDao;

	
	@Override
	public SelectstoreEntity finduserStore(String ExtraData, String CVSStoreName) {
		// TODO Auto-generated method stub
		SelectstoreEntity tmp=selectstoreDao.finduserStore(ExtraData, CVSStoreName);
		if(tmp!=null) {
			return tmp;
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}