package jp.co.internous.sampleweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.sampleweb.model.domain.dto.CartDto;
import jp.co.internous.sampleweb.model.domain.dto.MstDestination;
import jp.co.internous.sampleweb.model.mapper.MstDestinationMapper;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * 決済に関する処理を行うコントローラー
 * @author 若林　賢太朗
 *
 */
@Controller
@RequestMapping("/sampleweb/settlement")
public class SettlementController {
	
	@Autowired
	private MstDestinationMapper mstDestinationMapper;
	
	@Autowired
	private TblPurchaseHistoryMapper tblPurchaseHistoryMapper;
	
	@Autowired
	private TblCartMapper tblCartMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * 宛先選択・決済画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return 宛先選択・決済画面
	 */
	@RequestMapping("/")
	public String settlement(Model m) {
		//ユーザーIDの取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		List<MstDestination> mstDestinationList = mstDestinationMapper.findByUserId(userId);
		m.addAttribute("mstDestinationList", mstDestinationList);
		
		//page_header.htmlでセッションデータを表示させるため画面に送る処理
		m.addAttribute("loginSession", loginSession);
		return "settlement";
	}
	
	/**
	 * 決済処理を行う
	 * @param d 宛先情報ID
	 * @return true:決済処理成功、false:決済処理失敗
	 */
	@RequestMapping("/complete")
	@ResponseBody
	public boolean finishSettlement(@RequestBody MstDestination d) {
		
		//ユーザーIDの取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		List<CartDto> tblCartList = tblCartMapper.findCart(userId);
		for(CartDto c : tblCartList) {
			int productId = c.getProductId();
			int productCount = c.getProductCount();
			int price = c.getPrice();
			tblPurchaseHistoryMapper.insert(userId,productId,productCount,price,d.getId());
		}
		
		/**
		 * for文を使わずに購入履歴情報を登録する
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		String id = map.get("destinationId");
		
		int userId = loginSession.getUserId();
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("destinationId", id);
		parameter.put("userId", userId);
		int insertCount = purchaseHistoryMapper.insert(parameter);
		*/
		int dltCount = tblCartMapper.deleteByUserId(userId);
		
		return dltCount > 0;
	}

}
