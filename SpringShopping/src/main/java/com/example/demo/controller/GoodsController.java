package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.goodlist.GoodlistDao;
import com.example.demo.dao.goods.GoodsDao;
import com.example.demo.dao.selectstore.SelectstoreDao;
import com.example.demo.dao.shoppingcar.ShoppingCarDao;
import com.example.demo.dao.users.UserDao;
import com.example.demo.entity.goodlist.GoodlistEntity;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.selectstore.SelectstoreEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;
import com.example.demo.service.impl.GoodsServiceImpl;
import com.example.demo.service.impl.ShoppingcarServiceImpl;

import coustomresponse.CustomResponseEntity;

import ecpay.logistics.integration.AllInOne;
import ecpay.logistics.integration.domain.CreateCVSObj;
import ecpay.logistics.integration.domain.CreateHomeObj;
import ecpay.logistics.integration.domain.CreateTestDataObj;
import ecpay.logistics.integration.domain.ExpressMapObj;
import ecpay.logistics.integration.domain.PrintTradeDocumentObj;
import ecpay.logistics.integration.domain.QueryLogisticsTradeInfoObj;
import ecpay.logistics.integration.domain.UpdateShipmentInfoObj;
import ecpay.logistics.integration.domain.UpdateStoreInfoObj;


@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	public static AllInOne all;
	
	@Autowired
	GoodsServiceImpl GoodsService;
	
	@Autowired
	ShoppingcarServiceImpl Shopping_carService;
	
	@Autowired
	private SelectstoreDao selectstoreDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private GoodlistDao goodlistDao;
	
	@Autowired
	private ShoppingCarDao shopping_carDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	@CrossOrigin(origins ="https://61.71.47.141:8080")//
	@PostMapping("/save")
	public CustomResponseEntity saveGoods(@RequestBody GoodsEntity goodsEntity)
	{
		return GoodsService.saveGoods(goodsEntity);
	}
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@PutMapping("/update")		
	public GoodsEntity update(@RequestBody GoodsEntity goodsEntity)
	{
		return  GoodsService.updateGoods(goodsEntity);
	}
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/getAll")
	public CustomResponseEntity getAllGoods()
	{
		return GoodsService.getdAllGoods();
	}
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/get/{kind}")
	public 	CustomResponseEntity goodskind(@PathVariable(name = "kind") String employeeId)
	{
		
		return  GoodsService.goodskind(employeeId);
	}
	



	
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/findKeyWord/{kind}/{title}")
	public 	CustomResponseEntity findKeyWord(@PathVariable(name = "kind") String kind,@PathVariable(name = "title") String title)
	{

		
		return  GoodsService.findKeyWord(kind, title);//SELECT * FROM `items` WHERE `title`    LIKE "可%"
	}
	
	
	
	/*
	@CrossOrigin(origins = "https://61.71.47.141:8080")
	@GetMapping("/postCreateHome")
	public 	String postCreateHome()
	{
		
		CustomResponseEntity haha = null ;
		 postCreateHome2();
		 
		 System.out.println("map"+postExpressMap());
		 return  "haha";
	}
	*/
	@CrossOrigin(origins = "https://61.71.47.141:8080")
	@PostMapping("/selectStoreMap")
	public String selectStoreMap(@RequestBody Map<String, Object> payload)//前端發送帳號 姓名 所選擇的商店類型EX:萊爾富.....
	{
		String map =postExpressMap(payload.get("name").toString(),payload.get("LogisticsSubType").toString());//呼叫電子地圖API
		map =map.replace("<form ", "<form target=\"_blank\"  " );
		map =map.replace("<script language=\"JavaScript\">postForm.submit()</script>", "<button id=\"chargeForm\" style=\"display:none;\" ref=\"myBtn\" type=\"submit\" form=\"postForm\" value=\"Submit\">Submit</button>" );
		return  map ;
	}


	public static String postExpressMap(String name,String storeType){
		
		all = new AllInOne();
		ExpressMapObj obj = new ExpressMapObj();
		obj.setLogisticsSubType(storeType);//商店類型
		obj.setIsCollection("N");//是否離島
		obj.setExtraData(name);//姓名
		obj.setServerReplyURL("https://61.71.47.141:8090/goods/printMap");//Server端回覆網址
		return all.expressMap(obj);
	}

	@CrossOrigin(origins = "*")//選擇門市的測試網站
	@PostMapping("/printMap")

	public 	String printMap(@RequestParam Map<String, String> body )//選擇完地圖會回傳該門市的response 
	{
    
	    SelectstoreEntity userstore = selectstoreDao.getStoredataByUser(body.get("ExtraData"),body.get("CVSStoreID"));
		UserEntity tmp2=userDao.findname(body.get("ExtraData"));
		if(userstore==null) {
			userstore = new SelectstoreEntity();
			userstore.setMerchantID(body.get("MerchantID"));//廠商編號
			userstore.setMerchantTradeNo(body.get("MerchantTradeNo"));//廠商交易編號
			userstore.setLogisticsSubType(body.get("LogisticsSubType"));//商店類型
			userstore.setCVSStoreID(body.get("CVSStoreID").toString());//門市ID
			userstore.setCVSStoreName(body.get("CVSStoreName"));//門市名稱
			userstore.setCVSAddress(body.get("CVSAddress"));//門市地址
			userstore.setCVSTelephone(body.get("CVSTelephone"));//門市連絡電話
			userstore.setCVSOutSide("0");
			userstore.setExtraData(body.get("ExtraData"));//寄件人
			selectstoreDao.save(userstore);//新增一筆
		}
			
		System.out.print("HEYYO"+body.get("CVSStoreName"));
		System.out.print(body.get("CVSStoreID"));
		System.out.print(body.get("ExtraData"));
		return  body.get("CVSStoreName");
	}
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//前端列印門市資訊API
	@GetMapping("/userstore/{ExtraData}/{storeType}")//依前端所選擇名子 商店類型來找
	public CustomResponseEntity userstore(@PathVariable(name = "ExtraData")String ExtraData,@PathVariable(name = "storeType")String storeType)
	{
		CustomResponseEntity response =new  CustomResponseEntity();
	    List<SelectstoreEntity> userStore = selectstoreDao.getUserStorelist(ExtraData,storeType);
		if(userStore!=null) {
			response.setSelectstoreEntitys(userStore);
		}
		
		 
		return response;
	}
	

	@CrossOrigin(origins = "https://61.71.47.141:8080")//下定單API
	@PostMapping("/sendOrder")
	public String sendOrder(@RequestBody Map<String, Object> payload)//帳號 使用者 商店類型 商店名稱
	{
		CustomResponseEntity tmp = new CustomResponseEntity ();
		List<ShoppingCarEntity> tmp2=shopping_carDao.getAllShoppingCar(payload.get("username").toString());//找這個帳號的購物車
		
		//有幾樣就下幾筆訂單
		for( int i = 0 ;  i < tmp2.size() ; i++)
		{
			System.out.print(tmp2.get(i).getItem());
			System.out.print(tmp2.get(i).getPrice());
			System.out.print(tmp2.get(i).getSeller()+"\n");
		    postCreateCVS(tmp2.get(i).getItem(),tmp2.get(i).getPrice(),tmp2.get(i).getSeller(),payload.get("name").toString(),payload.get("username").toString(),payload.get("LogisticsSubType").toString(),payload.get("CVSStoreName").toString());
		    
		}
		
		return  "haha";
		
	}
	public String postCreateCVS(String AllgoodName ,Integer AllPrice ,String Seller ,String Customer,String username,String storeType,String storeName){
		//變力傷電
		System.out.println("所有物品:"+AllgoodName);
		all = new AllInOne();
		Date date = new Date(); 
		UserEntity userinfo=userDao.findAllUsername(username);//使用者資料
		GoodsEntity goods=goodsDao.findTitle(AllgoodName);
		SelectstoreEntity userStore=selectstoreDao.finduserStore(Customer,storeName);//找尋顧客選取的那家門市
		System.out.println(username);
		System.out.println(storeName);
		System.out.println("Hello Store:"+userStore);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(formatter.format(date));
		CreateCVSObj obj = new CreateCVSObj();
		System.out.println("----------------------------------");
		System.out.println("商店類型:"+storeType);
		System.out.println("商店名稱:"+storeName);
		System.out.println("----------------------------------");
	
		
		long tradeId = goodlistDao.count()+1;
		
			
			
			GoodlistEntity goodlist=new GoodlistEntity(); 
			goodlist = new GoodlistEntity();
			goodlist.setGoodsName(AllgoodName);//商品名稱
			goodlist.setGoodsPrice(AllPrice);//價格
			goodlist.setReceiverName(Customer);//顧客
			goodlist.setUsername(userinfo.getUsername());//顧客帳號
			goodlist.setImg(goods.getImg());//商品圖片
            goodlist.setFlag("已儲存");
            goodlist.setSenderName(Seller);//寄件人
            goodlist.setCVSStoreName(storeName);//取貨門市
            goodlist.setCVSStoreID(userStore.getCVSStoreID());
			obj.setMerchantTradeNo("NewWorhgfhfgld"+tradeId);//定單編號
			obj.setMerchantTradeDate(formatter.format(date)+"");//定單日期
			goodlist.setMerchantTradeNo(obj.getMerchantTradeNo());//定單編號
			goodlistDao.save(goodlist);//新增一筆清單
		
		  
			
		
        obj.setReceiverStoreID(userStore.getCVSStoreID());//取貨門市ID 幹
		obj.setLogisticsSubType(storeType);
		obj.setGoodsAmount(AllPrice.toString());
		obj.setGoodsName(AllgoodName);
		obj.setSenderName(Seller);
		obj.setReceiverName(Customer);
		obj.setReceiverCellPhone(userinfo.getPhonenumber());
							
		obj.setServerReplyURL("https://61.71.47.141:8090/goods/postCreateCVSresp");
		
		System.out.print(Customer+"\n");
		System.out.print(AllgoodName+"\n");
		
		return all.create(obj);
		
		
	}
	
//	@CrossOrigin(origins = "*")//選擇門市的測試網站
//	@PostMapping("/postCreateCVSback2")
//	public String postCreateCVSback2(@RequestParam Map<String, String> body)
//	
	@CrossOrigin(origins = "*")
	@PostMapping("/postCreateCVSresp")
	public String postCreateCVSresp(@RequestParam Map<String, String> body)
	{
		
		
		System.out.println("上架日期"+body.get("CVSStoreName"));
		System.out.println("檢查碼"+body.get("CheckMacValue"));
		System.out.println("定單編號"+body.get("MerchantTradeNo"));
		
		GoodlistEntity usergoodlist=goodlistDao.findUsergoodlistByMerchantTradeNo(body.get("MerchantTradeNo"));//利用定單邊號找尋定單
		
		System.out.println(body.get("MerchantTradeNo"));
		if(usergoodlist!=null) {//如果有那筆訂單
			usergoodlist.setAllPayLogisticsID(body.get("AllPayLogisticsID"));
			usergoodlist.setUpdateStatusDate(body.get("UpdateStatusDate"));
			usergoodlist.setRtnCode(body.get("RtnCode"));
			usergoodlist.setMerchantID(body.get("MerchantID"));
			usergoodlist.setCheckMacValue(body.get("CheckMacValue"));
			
			
			String html_resp=postPrintTradeDocument(body.get("AllPayLogisticsID"),body.get("MerchantID"),body.get("CheckMacValue"));
			String randstring = getRandomString(20);
			html_resp=html_resp.replace("<form ", "<form target=\"_blank\" style=\"width:auto; height:auto;\"   " );
			html_resp=html_resp.replace("<script language=\"JavaScript\">postForm.submit()</script>", "<button id=\"chargeForm\" ref=\"myBtn\" type=\"submit\" form=\"postForm\" value=\"Submit\">Submit</button>" );
			html_resp=html_resp.replace("postForm",randstring);
			System.out.println("Your HTML:"+html_resp);
			usergoodlist.setHtmlbutton(html_resp);
			goodlistDao.saveAndFlush(usergoodlist);
		
		}
		ShoppingCarEntity usercar=shopping_carDao.getCar(usergoodlist.getUsername(),usergoodlist.getGoodsName());
		System.out.println("who"+usergoodlist.getUsername()+"what"+usergoodlist.getGoodsName()+"id"+usercar.getId());
		
		shopping_carDao.deleteById(usercar.getId());
		
		return  "test";
	}
	
	
	
	
	

	
	
	
	public static String getRandomString(int length)
	{
	String str="abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
	Random random=new Random();
	StringBuffer sf=new StringBuffer();
	for(int i=0;i<length;i++)
	{
	 int number=random.nextInt(62);//0~61
	 sf.append(str.charAt(number));
	 

	}
	return sf.toString();
	}
	public String postPrintTradeDocument(String AllPayLogisticsID,String merchantID,String checkMacValue){
		all = new AllInOne();
		PrintTradeDocumentObj obj = new PrintTradeDocumentObj();
		System.out.println("交易編號:"+AllPayLogisticsID);
		System.out.println("ID:"+merchantID);
		System.out.println("檢查碼:"+checkMacValue);
		obj.setAllPayLogisticsID(AllPayLogisticsID);
		obj.setMerchantID(merchantID);
		obj.setCheckMacValue(checkMacValue);
		System.out.println("交易編號:"+obj.getAllPayLogisticsID());
		System.out.println("ID:"+obj.getMerchantID());
		System.out.println("檢查碼:"+obj.getCheckMacValue());
		System.out.println("Trade:"+all.printTradeDocument(obj));
		//obj.setServerReplyURL("https://57607e52.ngrok.io/goods/postPrintTradeDocumentBack");
		return all.printTradeDocument(obj);
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/postPrintTradeDocumentBack")

	public 	String postPrintTradeDocumentBack(@RequestParam Map<String, String> body)
	{
		
		return  "test";
	}
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")
	@PostMapping("/tradeInfo")
	public String tradeInfo(@RequestBody Map<String, Object> payload)//前端發送帳號 姓名 所選擇的商店類型EX:萊爾富.....
	{
	    
		System.out.println(payload.get("allPayLogisticsID").toString());
		System.out.println(payload.get("merchantID").toString());
		System.out.println(payload.get("checkMacValue").toString());
		String tradeInfo =postQueryLogisticsTradeInfo(payload.get("allPayLogisticsID").toString(),payload.get("merchantID").toString(),payload.get("checkMacValue").toString());
		System.out.println("查詢訂單:"+tradeInfo);
		return  tradeInfo ;
	}
	public static boolean cmprChkMacValue(String tmp , String tmp2){
		Hashtable<String, String> dict = new Hashtable<String, String>();
		dict.put("MerchantID", tmp);
		dict.put("CheckMacValue", tmp2);
		return all.compareCheckMacValue(dict);
	}
	public String postQueryLogisticsTradeInfo(String AllPayLogisticsID,String MerchantID,String CheckMacValue){
		all = new AllInOne();
		QueryLogisticsTradeInfoObj obj = new QueryLogisticsTradeInfoObj();
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
	//	System.out.println(cmprChkMacValue(MerchantID,CheckMacValue));
		System.out.println("Your交易編號:"+AllPayLogisticsID);
		System.out.println("Your定單編號:"+MerchantID);
		System.out.println(CheckMacValue);
		obj.setAllPayLogisticsID(AllPayLogisticsID);
		obj.setTimeStamp(getNowTimeStamp());
		obj.setMerchantID(MerchantID);
		
	//	obj.setCheckMacValue(CheckMacValue);
		//obj.setServerReplyURL("https://logistics-stage.ecpay.com.tw/Helper/QueryLogisticsTradeInfo/V2");
		System.out.println("Time:"+obj.getTimeStamp());
		
		return all.queryLogisticsTradeInfo(obj);
	}
	public static String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        return nowTimeStamp;
    }
	
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/getgoodlist/{username}")
	public CustomResponseEntity getgoodlist(@PathVariable(name = "username")String username)
	{
		
		
		CustomResponseEntity response =new  CustomResponseEntity();
		List<GoodlistEntity> Allusersgoodlist =goodlistDao.findUsergoodlistByUsername(username);
		
		
			
		
		if(Allusersgoodlist!=null) {
			
			response.setGoodlistEntitys(Allusersgoodlist);
			
			
		}
		
		
		return response;
		
	}
	
	@CrossOrigin(origins = "https://61.71.47.141:8080")//
	@GetMapping("/getsellerlist/{seller}")
	public CustomResponseEntity getsellerlist(@PathVariable(name = "seller")String seller)
	{
		
		
		CustomResponseEntity response =new  CustomResponseEntity();
		List<GoodlistEntity> Allusersgoodlist =goodlistDao.findUsergoodlistBySeller(seller);
		if(Allusersgoodlist!=null) {
			
			response.setGoodlistEntitys(Allusersgoodlist);
			
			
		}
		
		
		return response;
		
	}
	
}
