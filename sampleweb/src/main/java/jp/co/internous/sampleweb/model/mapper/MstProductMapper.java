package jp.co.internous.sampleweb.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.sampleweb.model.domain.dto.MstProduct;

/**
 * mst_productにアクセスするDAO
 * @author 若林　賢太朗
 *
 */

@Mapper
public interface MstProductMapper {
	/**
	 * 商品情報を取得する
	 * @return 商品情報リスト
	 */
	@Select("SELECT * FROM mst_product")
	List<MstProduct> findAll();

}
