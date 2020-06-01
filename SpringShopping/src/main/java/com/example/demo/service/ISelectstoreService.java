package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.selectstore.SelectstoreEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;




public interface ISelectstoreService {
	public SelectstoreEntity finduserStore(String ExtraData, String CVSStoreName);
   
}
