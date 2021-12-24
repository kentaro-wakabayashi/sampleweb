package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sampleweb.model.domain.TblCart;
import jp.co.internous.sampleweb.model.domain.dto.CartDto;

/**
 * tbl_cartにアクセスするDAO
 * @author 若林　賢太朗
 *
 */
@Mapper
public interface TblCartMapper {
	
	/**
	 * ユーザーIDを条件にカート情報を取得する
	 * @param userId ユーザーID
	 * @return カート情報リスト
	 */
	List<CartDto> findCart(@Param ("userId") int userId);
	
	/**
	 * ユーザーIDと商品IDを条件に主キーを取得する
	 * @param userId ユーザーID
	 * @Param productId 商品ID　
	 * @return 主キー,idが存在しない場合は0
	 */
	@Select("SELECT IF(count(id)>0, id, 0) FROM tbl_cart WHERE user_id = #{userId} AND product_id = #{productId}")
	int selectIdByUserIdAndProductId(@Param("userId") int userId,
										@Param("productId") int productId);
	
	/**
	 * 主キーの最大値 + 1 を取得する
	 * @return 主キー + 1, 存在しない場合は1 
	 */
	@Select("SELECT IF(count(id)>0, MAX(id)+1, 1) FROM tbl_cart")
	int selectMaxId();
	
	/**
	 * ユーザーIDを条件に件数を取得する
	 * @param userId ユーザーID
	 * @return 件数
	 */
	@Select("SELECT COUNT(user_id) FROM tbl_cart WHERE user_id = #{userId}")
	int countByUserId(@Param("userId") int userId);
	
	/**
	 * ユーザーIDを条件にユーザーIDを更新する
	 * @param userId ユーザーID
	 * @param tmpUserId 仮ユーザーID
	 * @return 更新件数
	 */
	@Update("UPDATE tbl_cart SET user_id = #{userId}, updated_at = now() WHERE user_id = #{tmpUserId}")
	int updateUserId(@Param("userId") int userId, @Param("tmpUserId") int tmpUserId);
	
	/**
	 * カート情報を登録または更新する
	 * @param tblCart カート情報
	 * @return なし
	 */
	@Insert("INSERT INTO tbl_cart (id, user_id, product_id, product_count) " +
			"VALUES (#{id}, #{userId}, #{productId}, #{productCount})" +
			"ON DUPLICATE KEY UPDATE product_count = product_count + #{productCount},updated_at = now()")
	void insertOrUpdate(TblCart tblCart);
	
	/**
	 * ユーザーIDを条件にカート情報を削除する
	 * @param userId ユーザーID
	 * @return 削除件数
	 */
	@Delete("DELETE FROM tbl_cart WHERE user_id = #{userId}")
	int deleteByUserId(@Param("userId") int userId);
	
	/**
	 * IDを条件にカート情報を削除する
	 * @param checkedIds
	 * @return 削除件数
	 */
	int deleteById(@Param("checkedIds") List<String> checkedIds);
}
