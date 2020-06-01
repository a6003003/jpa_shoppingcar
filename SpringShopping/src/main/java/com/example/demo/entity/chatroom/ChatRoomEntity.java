package com.example.demo.entity.chatroom;

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

@Table(name ="chatroommapping", catalog ="goods")//資料表 資料庫
public class ChatRoomEntity {
	@Id 
	@GeneratedValue(generator="system_uuid") @GenericGenerator(name="system_uuid",strategy="uuid")
	@Column (name="roomID")
	private String roomID;
	@Column (name="Sender")
	private String Sender;
	@Column (name="Receiver")
	private String Receiver;
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
	
	
	
	
	
	
	
	
	
}