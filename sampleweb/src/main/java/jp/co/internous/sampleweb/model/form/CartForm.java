package jp.co.internous.sampleweb.model.form;

import java.io.Serializable;

/**
 * カートフォーム
 * @author 若林　賢太朗
 *
 */
public class CartForm implements Serializable {
	private static final long serialVersionUID = 3196941519811683765L;
	
	private int id;
	private int userId;
	private int productId;
	private int productCount;
	
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
	
	
}
