package jp.co.internous.sampleweb.model.domain.dto;

/**
 * カート画面に表示するためのDTO
 * @author 若林　賢太朗
 *
 */
public class CartDto {
	private int id;
	private int productId;
	private String imageFullPath;
	private String productName;
	private int price;
	private int productCount;
	private int subTotal;
	
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
	 * 画像フルパスを取得する
	 * @return 画像フルパス
	 */
	public String getImageFullPath() {
		return imageFullPath;
	}
	
	/**
	 * 画像フルパスを設定する
	 * @param imageFullPath 画像フルパス
	 */
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath=imageFullPath;
	}
	
	/**
	 * 商品名を取得する
	 * @return 商品名
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 商品名を設定する
	 * @param productName 商品名
	 */
	public void setProductName(String productName) {
		this.productName=productName;
	}
	
	/**
	 * 商品価格を取得する
	 * @return 商品価格
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 商品価格を設定する
	 * @param price 商品価格
	 */
	public void setPrice(int price) {
		this.price=price;
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
	 * 小計を取得する
	 * @return 小計
	 */
	public int getSubTotal() {
		return subTotal;
	}
	
	/**
	 * 小計を設定する
	 * @param subTotal 小計
	 */
	public void setSubTotal(int subTotal) {
		this.subTotal=subTotal;
	}
	
}
