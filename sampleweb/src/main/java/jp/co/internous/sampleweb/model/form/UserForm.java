package jp.co.internous.sampleweb.model.form;

import java.io.Serializable;

/**
 * ユーザーフォーム
 * @author 若林　賢太朗
 *
 */
public class UserForm implements Serializable {
	private static final long serialVersionUID = 8063794324019083369L;

	private int id;
	private String userName;
	private String password;
	
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
	 * ユーザー名を取得する
	 * @return ユーザー名
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * ユーザー名を設定する
	 * @param userName ユーザー名
	 */
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	/**
	 * パスワードを取得する
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワードを設定する
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password=password;
	}
}
