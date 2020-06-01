package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.goods.GoodsEntity;

import coustomresponse.CustomResponseEntity;




public interface IGoodsService {
	CustomResponseEntity getdAllGoods();
	CustomResponseEntity goodskind(String kind);
	CustomResponseEntity findKeyWord(String kind, String title);
	
	CustomResponseEntity saveGoods(GoodsEntity goodsEntity);
    GoodsEntity updateGoods(GoodsEntity goodsEntity);
    
    
}
