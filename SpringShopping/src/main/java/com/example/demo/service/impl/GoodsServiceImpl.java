package com.example.demo.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.IGoodsService;

import coustomresponse.CustomResponseEntity;



@Service
public class GoodsServiceImpl implements IGoodsService {
	@Autowired
	private GoodsDao goodsDao;


	@Override
	public CustomResponseEntity saveGoods(GoodsEntity goodsEntity) {
		// TODO Auto-generated method stub
		CustomResponseEntity response =new  CustomResponseEntity();
		response.setMsg("上架商品成功");
		goodsDao.save(goodsEntity);
		return response;
	}


	@Override
	public GoodsEntity updateGoods(GoodsEntity goodsEntity) {
		// TODO Auto-generated method stub
		return goodsDao.saveAndFlush(goodsEntity);
	}


	@Override
	public CustomResponseEntity getdAllGoods(){
		// TODO Auto-generated method stub
		CustomResponseEntity response =new  CustomResponseEntity ();
		response.setGoodsEntitys(goodsDao.findAll());
		return response;
	}


	
	@Override
	public CustomResponseEntity goodskind(String kind) {
		CustomResponseEntity response =new  CustomResponseEntity ();
		List<GoodsEntity> tmp = goodsDao.goodskind(kind);//宣告一個tmp list存資料庫找到的種類
		if(tmp != null) {
		   response.setGoodsEntitys(tmp);
		   return response;
		}
		else 
			return null;
	}


	


	@Override
	public CustomResponseEntity findKeyWord(String kind, String title) {
		// TODO Auto-generated method stub
		CustomResponseEntity response =new  CustomResponseEntity ();
		String tmp = kind.equals("*") ? "%" : kind;
		String tmp2 = title.equals("*") ? "%" : title;//if(title.equlas("*") tmp2="%" else tmp=titte
		response.setGoodsEntitys(goodsDao.findKeyWord(tmp,tmp2+"%"));
		return response;
	}
	



}
