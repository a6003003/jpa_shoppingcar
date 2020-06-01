package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.impl.ShoppingcarServiceImpl;

import coustomresponse.CustomResponseEntity;


@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCarController {
	@Autowired
	ShoppingcarServiceImpl Shopping_carService;
//	
//	@CrossOrigin(origins = "http://localhost:8080")//
//	@PostMapping("/save")
//	public ShoppingCarEntity save (@RequestBody ShoppingCarEntity Shopping_carEntity)
//	{
//		return Shopping_carService.saveshopping_car(Shopping_carEntity);
//	}
//	@CrossOrigin(origins = "http://localhost:8080")//
//	@PutMapping("/update")	
//	public ShoppingCarEntity update(@RequestBody ShoppingCarEntity Shopping_carEntity)
//	{
//		return  Shopping_carService.updateshopping_car(Shopping_carEntity);
//	}
	
	
//	@GetMapping("/login/token/{token}")
//	public  UserEntity login(@PathVariable(name = "token") String token)
	
//	@CrossOrigin(origins = "http://localhost:8080")//
//	@GetMapping("/getAll")
//	public List<ShoppingCarEntity> getAllShopping_car()
//	{
//		return   Shopping_carService.getdAllShopping_car();
//	}
	@CrossOrigin(origins = "https://61.71.47.141:8080")//加入購物車
	@GetMapping("/add/{username}/{item}/{count}")
	public CustomResponseEntity addShopping_car(@PathVariable(name = "username") String username,@PathVariable(name = "item")
	String item,@PathVariable(name = "count") Integer count)
	{
		return  Shopping_carService.addShopping_car(username,item,count);
	}

	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//此帳戶的購物車
	@GetMapping("/get/{username}")
	public CustomResponseEntity getAllShoppingCar(@PathVariable(name = "username") String username)
	{
		return  Shopping_carService.getAllShoppingCar(username);
	}

	
	
	

}