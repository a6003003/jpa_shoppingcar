package com.example.demo.entity.selectstore;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;//快阿
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity//標記 Class 告訴Spring Boot 這是一個Entity物件

@Table(name ="selectstore", catalog ="goods")//資料表 資料庫
public class SelectstoreEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Integer id;
	
	
	
	
	
	@Column (name="LogisticsSubType")
	private String LogisticsSubType;
	

	@Column (name="MerchantID")
	private String MerchantID;
	
	@Column (name="MerchantTradeNo")
	private String MerchantTradeNo;
	
	
	
	
	
	@Column (name="	CVSStoreName")
	private String CVSStoreName;
	@Column (name="CVSStoreID")
	private String CVSStoreID;
	@Column (name="CVSAddress")
	private String CVSAddress;
	@Column (name="CVSTelephone")
	private String CVSTelephone;
	@Column (name="CVSOutSide")
	private String CVSOutSide;
	@Column (name="ExtraData")
	private String ExtraData;
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
	 * @return the cVSAddress
	 */
	public String getCVSAddress() {
		return CVSAddress;
	}
	/**
	 * @param cVSAddress the cVSAddress to set
	 */
	public void setCVSAddress(String cVSAddress) {
		CVSAddress = cVSAddress;
	}
	/**
	 * @return the cVSTelephone
	 */
	public String getCVSTelephone() {
		return CVSTelephone;
	}
	/**
	 * @param cVSTelephone the cVSTelephone to set
	 */
	public void setCVSTelephone(String cVSTelephone) {
		CVSTelephone = cVSTelephone;
	}
	/**
	 * @return the cVSOutSide
	 */
	public String getCVSOutSide() {
		return CVSOutSide;
	}
	/**
	 * @param cVSOutSide the cVSOutSide to set
	 */
	public void setCVSOutSide(String cVSOutSide) {
		CVSOutSide = cVSOutSide;
	}
	/**
	 * @return the extraData
	 */
	public String getExtraData() {
		return ExtraData;
	}
	/**
	 * @param extraData the extraData to set
	 */
	public void setExtraData(String extraData) {
		ExtraData = extraData;
	}
	
	

	
	
    
	
	
	
}
