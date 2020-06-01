package com.example.demo.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.dao.shoppingcar.ShoppingCarDao;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.IGoodsService;
import com.example.demo.service.IShoppingcarService;

import coustomresponse.CustomResponseEntity;



@Service
public class ShoppingcarServiceImpl implements IShoppingcarService{
	@Autowired
	private ShoppingCarDao shopping_carDao;
	@Autowired
	private GoodsDao goodDao;
	@Override
	public ShoppingCarEntity saveshopping_car(ShoppingCarEntity shopping_carEntity) {
		// TODO Auto-generated method stub
		return shopping_carDao.save(shopping_carEntity);	
	}

	@Override
	public ShoppingCarEntity updateshopping_car(ShoppingCarEntity shopping_carEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public CustomResponseEntity addShopping_car(String username,String item,Integer count) {
		CustomResponseEntity response =new CustomResponseEntity();
		ShoppingCarEntity userCar = shopping_carDao.getCar(username,item);//尋找當前購物車內有沒有這筆資料
		GoodsEntity goods = goodDao.findTitle(item);
		if (userCar == null) {//如果沒有 代表要新增一筆
			userCar = new ShoppingCarEntity();
			userCar.setUsername(username);
			if(goods !=null) {
				userCar.setItem(item);
				userCar.setImg(goods.getImg());
				userCar.setCount(count);
				userCar.setPrice(userCar.getCount()*(goods.getPrice()));
					shopping_carDao.save(userCar);//新增一筆
					response.setMsg(item+"已加入購物車");
					return response;
			}
		}
		else {//如果有這筆 代表想要那個物品再多買
			userCar.setCount(userCar.getCount()+count);
			userCar.setPrice(userCar.getCount()*(goods.getPrice()));
			shopping_carDao.saveAndFlush(userCar);//更新此筆資料
			response.setMsg(item+"已加入購物車");
			return response;
		}
		
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public CustomResponseEntity getAllShoppingCar(String username) {//此帳戶購物車
		CustomResponseEntity response =new  CustomResponseEntity();
		response.setShopping_carEntitys(shopping_carDao.getAllShoppingCar(username));
		return response;
	}
	

	
	
	



}
