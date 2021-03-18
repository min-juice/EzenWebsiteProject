package kr.co.repository;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.GoodsViewVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Inject
	private SqlSession sqlSession;
	
	//mapper
	private static String SNS = "kr.co.shop";
	
	// 카테고리별 상품 리스트 : 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
	 
	 HashMap<String, Object> map = new HashMap<String, Object>();
	 
	 map.put("cateCode", cateCode);
	 map.put("cateCodeRef", cateCodeRef);
	 
	 return sqlSession.selectList(SNS + ".list_1", map);
	}

	// 카테고리별 상품 리스트 : 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
	 
	 return sqlSession.selectList(SNS + ".list_2", cateCode);
	}
}
