package jp.co.internous.sampleweb.model.domain.dto;

import java.sql.Timestamp;

import jp.co.internous.sampleweb.model.form.CartForm;

/**
 * tbl_cartのドメイン
 * @author 若林　賢太朗
 *
 */
public class TblCart {
	private int id;
	private int userId;
	private int productId;
	private int productCount;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public TblCart() {}
	
	public TblCart(CartForm f) {
		this.userId=f.getUserId();
		this.productId=f.getProductId();
		this.productCount=f.getProductCount();
	}
	
	/**
	 * IDを取得する
	 * @return ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * IDを設定する
	 * @param id ID
	 */
	public void setId(int id) {
		this.id=id;
	}
	
	/**
	 * ユーザーIDを取得する
	 * @return ユーザーID
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * ユーザーIDを設定する
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId=userId;
	}
	
	/**
	 * 商品IDを取得する
	 * @return 商品ID
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * 商品IDを設定する
	 * @param productId 商品ID
	 */
	public void setProductId(int productId) {
		this.productId=productId;
	}
	
	/**
	 * 商品個数を取得する
	 * @return 商品個数
	 */
	public int getProductCount() {
		return productCount;
	}
	
	/**
	 * 商品個数を設定する
	 * @param productCount 商品個数
	 */
	public void setProductCount(int productCount) {
		this.productCount=productCount;
	}
	
	/**
	 * 登録日時を取得する
	 * @return 登録日時
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * 登録日時を設定する
	 * @param createdAt 登録日時
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt=createdAt;
	}
	
	/**
	 * 更新日時を取得する
	 * @return 更新日時
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * 更新日時を設定する
	 * @param updatedAt 更新日時
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt=updatedAt;
	}
}
