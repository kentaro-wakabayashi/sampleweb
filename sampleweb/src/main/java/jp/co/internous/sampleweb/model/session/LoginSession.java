package jp.co.internous.sampleweb.model.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * セッション情報を管理
 * @author 若林　賢太朗
 *
 */
@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class LoginSession implements Serializable {
	private static final long serialVersionUID = -4505629762363906244L;
	
	private int userId;
	private String userName;
	private String password;
	private boolean isLogined;
	private int tmpUserId;
	
	public boolean isLogined() {
		return isLogined;
	}
	
	public void setLogined(boolean isLogined) {
		this.isLogined=isLogined;
	}
	
	public int getTmpUserId() {
		return tmpUserId;
	}
	
	public void setTmpUserId(int tmpUserId) {
		this.tmpUserId=tmpUserId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId=userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

}
