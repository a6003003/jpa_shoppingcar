package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.users.UserDao;
import com.example.demo.entity.users.UserEntity;

import coustomresponse.CustomResponseEntity;


public interface IUserService {

     UserEntity saveUser(UserEntity userEntity);
     UserEntity updateUser(UserEntity userEntity);
     List<UserEntity> getdAllUser();
     
     
     
     CustomResponseEntity findAllUsersToken(String token);//檢查token
     CustomResponseEntity getAllUser();//所有人
     CustomResponseEntity getUser(String username);
     CustomResponseEntity login(String username,String password);//login邏輯 
     CustomResponseEntity register(String name,String username,String password,String phonenumber,String address);//註冊
     UserEntity findAllUsername(String username);//檢查帳號重複
     UserEntity findname(String name);//檢查名子重複
     
     
}