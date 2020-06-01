package com.example.demo.entity.chatroomHistory;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity//標記 Class 告訴Spring Boot 這是一個Entity物件

@Table(name ="chatroom", catalog ="goods")//資料表 資料庫
public class ChatRoomHistoryEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Integer id;
	@Column (name="roomID")
	private String roomID;
	@Column (name="Sender")
	private String Sender;
	@Column (name="Receiver")
	private String Receiver;
	@Column (name="MassageHistory")
	private String MassageHistory;
	@Column (name="Time")
	private Date time;
	@Column (name="isself")
	private Integer isself;
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
	 * @return the roomID
	 */
	public String getRoomID() {
		return roomID;
	}
	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	/**
	 * @return the sender
	 */
	public String getSender() {
		return Sender;
	}
	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		Sender = sender;
	}
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return Receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	/**
	 * @return the massageHistoryr
	 */
	public String getMassageHistory() {
		return MassageHistory;
	}
	/**
	 * @param massageHistoryr the massageHistoryr to set
	 */
	public void setMassageHistory(String massageHistory) {
		MassageHistory = massageHistory;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the isself
	 */
	public Integer getIsself() {
		return isself;
	}
	/**
	 * @param isself the isself to set
	 */
	public void setIsself(Integer isself) {
		this.isself = isself;
	}
	
	
	
	
	
	
	
	
	
	
}