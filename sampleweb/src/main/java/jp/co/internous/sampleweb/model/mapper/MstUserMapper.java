package jp.co.internous.sampleweb.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.MstUser;

/**
 * mst_userにアクセスするDAO
 * @author 若林　賢太朗
 *
 */
@Mapper
public interface MstUserMapper {
	/**
	 * ユーザー名とパスワードを条件にユーザー情報を取得する
	 * @param userName ユーザー名
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password}")
		MstUser findByUserNameAndPassword(
			@Param("userName") String userName,
			@Param("password") String password);
	
	/**
	 * ユーザーIDを条件にユーザー情報を取得する
	 * @param userId ユーザーID
	 * @return ユーザー情報
	 */
	@Select("SELECT * FROM mst_user WHERE id = #{userId}")
		MstUser findByUserId(@Param("userId") int userId);
}
