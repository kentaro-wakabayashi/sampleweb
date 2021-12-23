package jp.co.internous.sampleweb.model.domain.dto;

import java.sql.Timestamp;

/**
 * mst_productのドメイン
 * @author 若林　賢太朗
 *
 */
public class MstProduct {
	private int id;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int price;
	private String imageFullPath;
	private String releaseDate;
	private String releaseCompany;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
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
	 * 商品名（かな）を取得する
	 * 
	 * @return 商品名（かな）
	 */
	public String getProductNameKana() {
		return productNameKana;
	}
	
	/**
	 * 商品名（かな）を設定する
	 * @param productNameKana 商品名（かな）
	 */
	public void setProductNameKana(String productNameKana) {
		this.productNameKana=productNameKana;
	}
	
	/**
	 * 商品詳細を取得する
	 * @return 商品詳細
	 */
	public String getProductDescription() {
		return productDescription;
	}
	
	/**
	 * 商品詳細を設定する
	 * @param productDescription 商品詳細
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription=productDescription;
	}
	
	/**
	 * カテゴリーを取得する
	 * @return カテゴリー
	 */
	public int getCategoryId() {
		return categoryId;
	}
	
	/**
	 * カテゴリーを設定する
	 * @param category カテゴリー
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId=categoryId;
	}
	
	/**
	 * 価格を取得する
	 * @return 価格
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 価格を設定する
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price=price;
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
	 * 発売年月日を取得する
	 * @return 発売年月日
	 */
	public String getReleaseDate() {
		return releaseDate;
	}
	
	/**
	 * 発売年月日を設定する
	 * @param releaseDate 発売年月日
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	/**
	 * 販売会社を取得する
	 * @return 販売会社
	 */
	public String getReleaseCompany() {
		return releaseCompany;
	}
	
	/**
	 * 販売会社を設定する
	 * @param releaseCompany 販売会社
	 */
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
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
		this.createdAt = createdAt;
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
		this.updatedAt = updatedAt;
	}
}
