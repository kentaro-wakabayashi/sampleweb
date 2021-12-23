package jp.co.internous.sampleweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sampleweb.model.domain.dto.MstProduct;
import jp.co.internous.sampleweb.model.mapper.MstProductMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author 若林　賢太朗
 *
 */
@Controller
@RequestMapping("/sampleweb")
public class IndexController {
	@Autowired
	private MstProductMapper mstProductMapper;
	
	@Autowired
	private LoginSession loginSession;

	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		//仮ユーザーID設定
		if(!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			while(tmpUserId > -100000000) {
				//9桁にする
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		
		//商品情報の取得
		List<MstProduct> mstProductList = mstProductMapper.findAll();
		if(mstProductList != null && mstProductList.size() > 0) {
			m.addAttribute("mstProductList", mstProductList);
		}
		
		//page_header.htmlでセッションデータを表示させるため画面に送る処理
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
	
}
