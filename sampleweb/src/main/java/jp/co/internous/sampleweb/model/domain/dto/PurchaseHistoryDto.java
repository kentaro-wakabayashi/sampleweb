package jp.co.internous.sampleweb.model.domain.dto;

/**
 * 購入履歴画面に表示するためのDTO
 * @author 若林　賢太朗
 *
 */

public class PurchaseHistoryDto {
	private String purchasedAt;
	private String productName;
	private int price;
	private int productCount;
	private String familyName;
	private String firstName;
	private String address;
	
	/**
	 * 購入履歴を取得する
	 * @return purchasedAt
	 */
	public String getPurchasedAt() {
		return purchasedAt;
	}
	
	/**
	 * 購入履歴を設定する
	 * @param purchasedAt 購入履歴
	 */
	public void setPurchasedAt(String purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	
	/**
	 * 商品名を取得する
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 商品名を設定する
	 * @param productName 商品名
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * 価格を取得する
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * カ
	 * 価格を設定する
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 商品個数を取得する
	 * @return productCount
	 */
	public int getProductCount() {
		return productCount;
	}

	/**
	 * 商品個数を設定する
	 * @param productCount 商品個数
	 */
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	/**
	 * 姓を取得する
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	
	/**
	 * 姓を設定する
	 * @param familyName 姓
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**
	 * 名を取得する
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 名を設定する
	 * @param firstName 名
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 住所を取得する
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 住所を設定する
	 * @param address 住所
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
