package com.example.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.users.UserDao;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.impl.*;

import coustomresponse.CustomResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	

	@CrossOrigin(origins = "http://localhost:8080")//
	@PostMapping("/save")
	public UserEntity saveUser(@RequestBody UserEntity userEntity)
	{
	
		return userService.saveUser(userEntity);
	}
	@CrossOrigin(origins = "http://localhost:8080")//
	@PutMapping("/update")	
	public UserEntity update(@RequestBody UserEntity userEntity)
	{
		return  userService.updateUser(userEntity);
	}
	@CrossOrigin(origins = "http://localhost:8080")//
	@GetMapping("/getAll")
	public List<UserEntity> getAllUser()
	{
		return   userService.getdAllUser();
	}
	@CrossOrigin(origins = "http://localhost:8080")//
	@GetMapping("/get/{id}")
	public 	UserEntity getUserById(@PathVariable(name = "username") String employeeId)
	{

		return  userService.findAllUsername(employeeId);
	}
	


	@CrossOrigin(origins = "https://61.71.47.141:8080")//login
	@PostMapping("/login")
	public CustomResponseEntity login(@RequestBody Map<String, Object> payload)
	{
		return  userService.login(payload.get("username").toString(),payload.get("password").toString());
	}
	

	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//register
	@PostMapping("/register")
	public CustomResponseEntity register(@RequestBody Map<String, Object> payload)
	{
		return  userService.register(payload.get("name").toString(),payload.get("username").toString(),
		payload.get("password").toString(),payload.get("phonenumber").toString(),payload.get("address").toString());
	}
	
	
	
	
	
}