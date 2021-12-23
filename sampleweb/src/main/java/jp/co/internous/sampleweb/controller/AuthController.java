package jp.co.internous.sampleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jp.co.internous.sampleweb.model.domain.dto.MstUser;
import jp.co.internous.sampleweb.model.form.UserForm;
import jp.co.internous.sampleweb.model.mapper.MstUserMapper;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 認証に関する処理を行うコントローラー 
 * @author 若林　賢太朗
 *
 */
@RestController
@RequestMapping("/sampleweb/auth")
public class AuthController {
	@Autowired
	private MstUserMapper mstUserMapper;
	
	@Autowired
	private TblCartMapper tblCartMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	private Gson gson = new Gson();
	
	/**
	 * ログイン処理を行う
	 * @param f ユーザーフォーム
	 * @return ログインしたユーザー情報(JSON形式)
	 */
	@RequestMapping("/login")
	public String loginApi(@RequestBody UserForm f) {
	
		MstUser user = mstUserMapper.findByUserNameAndPassword(f.getUserName(), f.getPassword());
		
		// 仮IDでカート追加されていれば、本ユーザーIDに更新する。
		int tmpUserId = loginSession.getTmpUserId();
		if(user != null && tmpUserId != 0) {
			if(tblCartMapper.countByUserId(tmpUserId) > 0) {
				tblCartMapper.updateUserId(user.getId(), tmpUserId);
			}
		}
		
		if(user != null) {
			loginSession.setUserId(user.getId());
			loginSession.setTmpUserId(0);
			loginSession.setLogined(true);
			loginSession.setUserName(user.getUserName());
			loginSession.setPassword(user.getPassword());
		} else {
			loginSession.setUserId(0);
			loginSession.setLogined(false);
			loginSession.setUserName(null);
			loginSession.setPassword(null);
		}
		return gson.toJson(user);
		
	}
	
	/**
	 * ログアウト処理を行う
	 */
	@RequestMapping("/logout")
	public void logout() {
		loginSession.setUserId(0);
		loginSession.setUserName(null);
		loginSession.setPassword(null);
		loginSession.setLogined(false);
	}
	
}
