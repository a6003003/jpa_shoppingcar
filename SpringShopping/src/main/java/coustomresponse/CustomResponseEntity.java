package coustomresponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.chatroom.ChatRoomEntity;
import com.example.demo.entity.goodlist.GoodlistEntity;
import com.example.demo.entity.goods.GoodsEntity;
import com.example.demo.entity.selectstore.SelectstoreEntity;
import com.example.demo.entity.shoppingcar.ShoppingCarEntity;
import com.example.demo.entity.users.UserEntity;

public class CustomResponseEntity {
	@Autowired
	private GoodsEntity goodsEntity;
	@Autowired
	private List<GoodsEntity> goodsEntitys;
	@Autowired
	private ShoppingCarEntity shopping_carEntity;
	@Autowired
	private List<ShoppingCarEntity> shopping_carEntitys;
	@Autowired
	private UserEntity userEntity;
	@Autowired
	private List<UserEntity> userEntitys;
	
	@Autowired
	private GoodlistEntity goodlistEntity;
	@Autowired
	private List<GoodlistEntity> goodlistEntitys;
	
	@Autowired
	private SelectstoreEntity selectstoreEntity;
	@Autowired
	private List<SelectstoreEntity> selectstoreEntitys;
	
	@Autowired
	private ChatRoomEntity chatroomEntity;
	@Autowired
	private List<ChatRoomEntity> chatroomEntitys;   
	
	

	public String data;
	public String msg;
	public String status;
	public CustomResponseEntity() {
		this.goodsEntity = null;
		this.goodsEntitys = null;
		this.shopping_carEntity = null;
		this.shopping_carEntitys = null;
		this.userEntity = null;
		this.userEntitys = null;
		this.data = null;
		this.msg = null;
		this.status = null;
	}
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the goodsEntity
	 */
	public GoodsEntity getGoodsEntity() {
		return goodsEntity;
	}
	/**
	 * @param goodsEntity the goodsEntity to set
	 */
	public void setGoodsEntity(GoodsEntity goodsEntity) {
		this.goodsEntity = goodsEntity;
	}
	/**
	 * @return the goodsEntitys
	 */
	public List<GoodsEntity> getGoodsEntitys() {
		return goodsEntitys;
	}
	/**
	 * @param goodsEntitys the goodsEntitys to set
	 */
	public void setGoodsEntitys(List<GoodsEntity> goodsEntitys) {
		this.goodsEntitys = goodsEntitys;
	}
	/**
	 * @return the shopping_carEntity
	 */
	public ShoppingCarEntity getShopping_carEntity() {
		return shopping_carEntity;
	}
	/**
	 * @param shopping_carEntity the shopping_carEntity to set
	 */
	public void setShopping_carEntity(ShoppingCarEntity shopping_carEntity) {
		this.shopping_carEntity = shopping_carEntity;
	}
	/**
	 * @return the shopping_carEntitys
	 */
	public List<ShoppingCarEntity> getShopping_carEntitys() {
		return shopping_carEntitys;
	}
	/**
	 * @param shopping_carEntitys the shopping_carEntitys to set
	 */
	public void setShopping_carEntitys(List<ShoppingCarEntity> shopping_carEntitys) {
		this.shopping_carEntitys = shopping_carEntitys;
	}
	/**
	 * @return the userEntity
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}
	/**
	 * @param userEntity the userEntity to set
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	/**
	 * @return the userEntitys
	 */
	public List<UserEntity> getUserEntitys() {
		return userEntitys;
	}
	/**
	 * @param userEntitys the userEntitys to set
	 */
	public void setUserEntitys(List<UserEntity> userEntitys) {
		this.userEntitys = userEntitys;
		
		
	}
	/**
	 * @return the goodlistEntity
	 */
	public GoodlistEntity getGoodlistEntity() {
		return goodlistEntity;
	}
	/**
	 * @param goodlistEntity the goodlistEntity to set
	 */
	public void setGoodlistEntity(GoodlistEntity goodlistEntity) {
		this.goodlistEntity = goodlistEntity;
	}
	/**
	 * @return the goodlistEntitys
	 */
	public List<GoodlistEntity> getGoodlistEntitys() {
		return goodlistEntitys;
	}
	/**
	 * @param goodlistEntitys the goodlistEntitys to set
	 */
	public void setGoodlistEntitys(List<GoodlistEntity> goodlistEntitys) {
		this.goodlistEntitys = goodlistEntitys;
	}
	/**
	 * @return the chatroomEntity
	 */
	public ChatRoomEntity getChatroomEntity() {
		return chatroomEntity;
	}
	/**
	 * @param chatroomEntity the chatroomEntity to set
	 */
	public void setChatroomEntity(ChatRoomEntity chatroomEntity) {
		this.chatroomEntity = chatroomEntity;
	}
	/**
	 * @return the chatroomEntitys
	 */
	public List<ChatRoomEntity> getChatroomEntitys() {
		return chatroomEntitys;
	}
	/**
	 * @param chatroomEntitys the chatroomEntitys to set
	 */
	public void setChatroomEntitys(List<ChatRoomEntity> chatroomEntitys) {
		this.chatroomEntitys = chatroomEntitys;
	}
	/**
	 * @return the selectstoreEntity
	 */
	public SelectstoreEntity getSelectstoreEntity() {
		return selectstoreEntity;
	}
	/**
	 * @param selectstoreEntity the selectstoreEntity to set
	 */
	public void setSelectstoreEntity(SelectstoreEntity selectstoreEntity) {
		this.selectstoreEntity = selectstoreEntity;
	}
	/**
	 * @return the selectstoreEntitys
	 */
	public List<SelectstoreEntity> getSelectstoreEntitys() {
		return selectstoreEntitys;
	}
	/**
	 * @param selectstoreEntitys the selectstoreEntitys to set
	 */
	public void setSelectstoreEntitys(List<SelectstoreEntity> selectstoreEntitys) {
		this.selectstoreEntitys = selectstoreEntitys;
	}
	
	

	
}
