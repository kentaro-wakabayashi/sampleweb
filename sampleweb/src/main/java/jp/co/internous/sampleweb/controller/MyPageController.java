package jp.co.internous.sampleweb.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sampleweb.model.domain.dto.MstUser;
import jp.co.internous.sampleweb.model.mapper.MstUserMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * マイページに関する処理を行うコントローラー
 * @author 若林　賢太朗
 *
 */
@Controller
@RequestMapping("/sampleweb/mypage")
public class MyPageController {
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstUserMapper mstUserMapper;
	
	/**
	 * マイページ画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return マイページ画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		//ユーザーIDの取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		//マイページ情報の取得
		MstUser userData = mstUserMapper.findByUserId(userId);
		
		//パスワードを文字数と同じ数の * に変換して設定
		if(userData != null) {
			int count = userData.getPassword().length();
			String password = String.join("", Collections.nCopies(count, "*"));
			userData.setPassword(password);
		}
		m.addAttribute("userData", userData);
		
		//page_header.htmlでセッションデータを表示させるため画面に送る処理
		m.addAttribute("loginSession", loginSession);
		
		return "my_page";
	}
}
