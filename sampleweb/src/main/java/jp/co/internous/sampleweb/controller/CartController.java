package jp.co.internous.sampleweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.sampleweb.model.domain.TblCart;
import jp.co.internous.sampleweb.model.domain.dto.CartDto;
import jp.co.internous.sampleweb.model.form.CartForm;
import jp.co.internous.sampleweb.model.mapper.TblCartMapper;
import jp.co.internous.sampleweb.model.session.LoginSession;

/**
 * カート情報に関する処理を行うコントローラー
 * @author 若林　賢太朗
 *
 */
@Controller
@RequestMapping("/sampleweb/cart")
public class CartController {

	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private TblCartMapper tblCartMapper;
	
	Gson gson = new Gson();	
	
	/**
	 * カート画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/")
	public String cartIndex(Model m) {
		//ユーザーIDの取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		
		//カート情報の取得
		List<CartDto> cartDtoList = tblCartMapper.findCart(userId);
		if(cartDtoList != null && cartDtoList.size() > 0) {
		m.addAttribute("cartDtoList", cartDtoList);
		}
		
		//page_header.htmlでセッションデータを表示させるため画面に送る処理
		m.addAttribute("loginSession", loginSession);
		
		return "cart";
	}
	
	/**
	 * カートに追加処理を行う
	 * @param f カート情報のForm
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		// ユーザーIDを取得
		int userId = loginSession.isLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		f.setUserId(userId);
		
		//カートテーブルに商品を挿入または更新
		TblCart c = new TblCart(f);
		
		int id = tblCartMapper.selectIdByUserIdAndProductId(userId, f.getProductId());
		
		if(id>0) {
			c.setId(id);
		}else {
			c.setId(tblCartMapper.selectMaxId());
		}
		tblCartMapper.insertOrUpdate(c);
		
		List<CartDto> cartDtoList = tblCartMapper.findCart(userId);
		if(cartDtoList != null && cartDtoList.size() > 0) {
			m.addAttribute("cartDtoList", cartDtoList);
		}
		
		//page_header.htmlでセッションデータを表示させるため画面に送る処理
		m.addAttribute("loginSession", loginSession);
		
		return "cart";
	}
	
	/**
	 * カート情報を削除する
	 * @param checkedIdList 選択したカート情報のIDリスト
	 * @return true:削除成功、false:削除失敗
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		int result = 0;
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		result = tblCartMapper.deleteById(checkedIds);
		return result > 0;
	}
}
