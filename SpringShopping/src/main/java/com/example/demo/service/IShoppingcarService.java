package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;

import coustomresponse.CustomResponseEntity;




public interface IShoppingcarService {
	ShoppingCarEntity saveshopping_car(ShoppingCarEntity shopping_carEntity);
	ShoppingCarEntity updateshopping_car(ShoppingCarEntity shopping_carEntity);
    
    
    
    CustomResponseEntity addShopping_car(String username,String item,Integer count);//新增購物車API
    CustomResponseEntity getAllShoppingCar(String username);//此帳戶購物車
   
   
}
