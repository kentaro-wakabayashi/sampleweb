package jp.co.internous.sampleweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.sampleweb.model.domain.dto.PurchaseHistoryDto;
import jp.co.internous.sampleweb.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 購入履歴情報に関する処理を行うコントローラー
 * @author 若林　賢太朗
 *
 */
@Controller
@RequestMapping("/sampleweb/history")
public class PurchaseHistoryController {
	@Autowired
	private TblPurchaseHistoryMapper tblPurchaseHistoryMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * 購入履歴画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return 購入履歴画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		//ユーザーIDの取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		List<PurchaseHistoryDto> purchaseHistoryDtoList = tblPurchaseHistoryMapper.findByUserId(userId);
		
		if(purchaseHistoryDtoList != null && purchaseHistoryDtoList.size() > 0) {
			m.addAttribute("purchaseHistoryDtoList", purchaseHistoryDtoList);
		}
		
		//page_header.htmlでセッションデータを表示させるため画面に送る処理
		m.addAttribute("loginSession", loginSession);
		return "purchase_history";
	}
	
	/**
	 * 購入履歴情報を論理削除する
	 * @return true:削除成功、false:削除失敗
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteHistory() {
		//ユーザーIDの取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		int dltHistoryCount = tblPurchaseHistoryMapper.updateByUserId(userId);
		
		return dltHistoryCount > 0 ;
	}
}
