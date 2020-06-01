package com.example.demo.entity.goodlist;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//標記 Class 告訴Spring Boot 這是一個Entity物件

@Table(name ="goodlist", catalog ="goods")//資料表 資料庫
public class GoodlistEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Integer id;
	@Column (name="username")
	private String username;
	@Column (name="GoodsPrice")
	private Integer GoodsPrice;
	@Column (name="GoodsName")
	private String GoodsName;
	@Column (name="SenderName")
	private String SenderName;
	@Column (name="ReceiverName")
	private String ReceiverName;
	@Column (name="AllPayLogisticsID")
	private String AllPayLogisticsID;
	@Column (name="BookingNote")
	private String BookingNote;
	@Column (name="CheckMacValue")
	private String CheckMacValue;
	@Column (name="CVSPaymentNo")
	private String CVSPaymentNo;
	@Column (name="CVSValidationNo")
	private String CVSValidationNo;
	@Column (name="LogisticsSubType")
	private String LogisticsSubType;
	@Column (name="LogisticsType")
	private String LogisticsType;
	@Column (name="MerchantID")
	private String MerchantID;
	@Column (name="MerchantTradeNo")
	private String MerchantTradeNo;
	@Column (name="ReceiverAddress")
	private String ReceiverAddress;
	@Column (name="ReceiverCellPhone")
	private String ReceiverCellPhone;
	@Column (name="ReceiverEmail")
	private String ReceiverEmail;
	@Column (name="img")
	private String img;
	@Column (name="ReceiverPhone")
	private String ReceiverPhone;
	@Column (name="RtnCode")
	private String RtnCode;
	@Column (name="	UpdateStatusDate")
	private String UpdateStatusDate;
	@Column (name="	flag")
	private String flag;
	@Column (name="	CVSStoreName")
	private String CVSStoreName;
	@Column (name="CVSStoreID")
	private String CVSStoreID;
	@Column (name="htmlbutton")
	private String htmlbutton;
	@Column (name="printTrade")
	private String printTrade;
	/**
	 * @return the printTrade
	 */
	public String getPrintTrade() {
		return printTrade;
	}
	/**
	 * @param printTrade the printTrade to set
	 */
	public void setPrintTrade(String printTrade) {
		this.printTrade = printTrade;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the goodsPrice
	 */
	public Integer getGoodsPrice() {
		return GoodsPrice;
	}
	/**
	 * @param goodsPrice the goodsPrice to set
	 */
	public void setGoodsPrice(Integer goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return GoodsName;
	}
	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return SenderName;
	}
	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	/**
	 * @return the receiverName
	 */
	public String getReceiverName() {
		return ReceiverName;
	}
	/**
	 * @param receiverName the receiverName to set
	 */
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	/**
	 * @return the allPayLogisticsID
	 */
	public String getAllPayLogisticsID() {
		return AllPayLogisticsID;
	}
	/**
	 * @param allPayLogisticsID the allPayLogisticsID to set
	 */
	public void setAllPayLogisticsID(String allPayLogisticsID) {
		AllPayLogisticsID = allPayLogisticsID;
	}
	/**
	 * @return the bookingNote
	 */
	public String getBookingNote() {
		return BookingNote;
	}
	/**
	 * @param bookingNote the bookingNote to set
	 */
	public void setBookingNote(String bookingNote) {
		BookingNote = bookingNote;
	}
	/**
	 * @return the checkMacValue
	 */
	public String getCheckMacValue() {
		return CheckMacValue;
	}
	/**
	 * @param checkMacValue the checkMacValue to set
	 */
	public void setCheckMacValue(String checkMacValue) {
		CheckMacValue = checkMacValue;
	}
	/**
	 * @return the cVSPaymentNo
	 */
	public String getCVSPaymentNo() {
		return CVSPaymentNo;
	}
	/**
	 * @param cVSPaymentNo the cVSPaymentNo to set
	 */
	public void setCVSPaymentNo(String cVSPaymentNo) {
		CVSPaymentNo = cVSPaymentNo;
	}
	/**
	 * @return the cVSValidationNo
	 */
	public String getCVSValidationNo() {
		return CVSValidationNo;
	}
	/**
	 * @param cVSValidationNo the cVSValidationNo to set
	 */
	public void setCVSValidationNo(String cVSValidationNo) {
		CVSValidationNo = cVSValidationNo;
	}
	/**
	 * @return the logisticsSubType
	 */
	public String getLogisticsSubType() {
		return LogisticsSubType;
	}
	/**
	 * @param logisticsSubType the logisticsSubType to set
	 */
	public void setLogisticsSubType(String logisticsSubType) {
		LogisticsSubType = logisticsSubType;
	}
	/**
	 * @return the logisticsType
	 */
	public String getLogisticsType() {
		return LogisticsType;
	}
	/**
	 * @param logisticsType the logisticsType to set
	 */
	public void setLogisticsType(String logisticsType) {
		LogisticsType = logisticsType;
	}
	/**
	 * @return the merchantID
	 */
	public String getMerchantID() {
		return MerchantID;
	}
	/**
	 * @param merchantID the merchantID to set
	 */
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	/**
	 * @return the merchantTradeNo
	 */
	public String getMerchantTradeNo() {
		return MerchantTradeNo;
	}
	/**
	 * @param merchantTradeNo the merchantTradeNo to set
	 */
	public void setMerchantTradeNo(String merchantTradeNo) {
		MerchantTradeNo = merchantTradeNo;
	}
	/**
	 * @return the receiverAddress
	 */
	public String getReceiverAddress() {
		return ReceiverAddress;
	}
	/**
	 * @param receiverAddress the receiverAddress to set
	 */
	public void setReceiverAddress(String receiverAddress) {
		ReceiverAddress = receiverAddress;
	}
	/**
	 * @return the receiverCellPhone
	 */
	public String getReceiverCellPhone() {
		return ReceiverCellPhone;
	}
	/**
	 * @param receiverCellPhone the receiverCellPhone to set
	 */
	public void setReceiverCellPhone(String receiverCellPhone) {
		ReceiverCellPhone = receiverCellPhone;
	}
	/**
	 * @return the receiverEmail
	 */
	public String getReceiverEmail() {
		return ReceiverEmail;
	}
	/**
	 * @param receiverEmail the receiverEmail to set
	 */
	public void setReceiverEmail(String receiverEmail) {
		ReceiverEmail = receiverEmail;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the receiverPhone
	 */
	public String getReceiverPhone() {
		return ReceiverPhone;
	}
	/**
	 * @param receiverPhone the receiverPhone to set
	 */
	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
	}
	/**
	 * @return the rtnCode
	 */
	public String getRtnCode() {
		return RtnCode;
	}
	/**
	 * @param rtnCode the rtnCode to set
	 */
	public void setRtnCode(String rtnCode) {
		RtnCode = rtnCode;
	}
	/**
	 * @return the updateStatusDate
	 */
	/**
	 * @return the updateStatusDate
	 */
	public String getUpdateStatusDate() {
		return UpdateStatusDate;
	}
	/**
	 * @param updateStatusDate the updateStatusDate to set
	 */
	public void setUpdateStatusDate(String updateStatusDate) {
		UpdateStatusDate = updateStatusDate;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the cVSStoreName
	 */
	public String getCVSStoreName() {
		return CVSStoreName;
	}
	/**
	 * @param cVSStoreName the cVSStoreName to set
	 */
	public void setCVSStoreName(String cVSStoreName) {
		CVSStoreName = cVSStoreName;
	}
	/**
	 * @return the cVSStoreID
	 */
	public String getCVSStoreID() {
		return CVSStoreID;
	}
	/**
	 * @param cVSStoreID the cVSStoreID to set
	 */
	public void setCVSStoreID(String cVSStoreID) {
		CVSStoreID = cVSStoreID;
	}
	/**
	 * @return the htmlbutton
	 */
	public String getHtmlbutton() {
		return htmlbutton;
	}
	/**
	 * @param htmlbutton the htmlbutton to set
	 */
	public void setHtmlbutton(String htmlbutton) {
		this.htmlbutton = htmlbutton;
	}
	
	
	
	
	
	
	
	
}
