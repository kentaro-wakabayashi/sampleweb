package jp.co.internous.sampleweb.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sampleweb.model.domain.dto.PurchaseHistoryDto;

/**
 * tbl_purchase_historyにアクセスするDAO
 * @author 若林　賢太朗
 *
 */

@Mapper
public interface TblPurchaseHistoryMapper {
	/**
	 * 購入履歴情報を登録する
	 * @param userId ユーザーID
	 * @param productId 商品ID
	 * @param productCount 商品個数
	 * @param price 価格
	 * @param destinationId 宛先ID
	 * @return 件数
	 */	
	@Insert("INSERT INTO tbl_purchase_history (user_id,product_id,product_count,price,destination_id)" +
			"VALUES (#{userId},#{productId},#{productCount},#{price},#{destinationId})")
	int insert(@Param("userId") int userId,
			@Param("productId") int productId,
			@Param("productCount") int productCount,
			@Param("price") int price,
			@Param("destinationId") int destinationId);
	
	/**
	 * （for文を使わずに）
	 * 購入履歴情報を登録する
	 * @param parameter パラメーター(ユーザーID、宛先情報ID)
	 * @return 登録件数*/
//	int insert(Map<String, Object> parameter);
	
	/**
	 * ユーザーIDを条件に購入履歴を取得する
	 * @Param userId ユーザーID
	 * @Return 購入履歴リスト
	 * 
	 */
	List<PurchaseHistoryDto> findByUserId(@Param("userId") int userId);
	
	/**
	 * ユーザーIDを条件に論理削除する
	 * @param userId ユーザーID
	 * @return 削除件数
	 */
	@Update("UPDATE tbl_purchase_history SET status = 0, updated_at = now() WHERE user_id = #{userId}")
	int updateByUserId(@Param("userId") int userId);
	
}
