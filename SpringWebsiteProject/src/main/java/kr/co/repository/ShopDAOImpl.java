package kr.co.repository;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;

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

	//상품조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("kr.co.mappers.adminMapper"+".goodsView", gdsNum);
	}

	//상품리뷰 댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sqlSession.insert(SNS+".registReply", reply);
		
	}

	//상품리뷰 댓글 리스트
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(SNS+".replyList", gdsNum);
	}

	//상품리뷰 댓글 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sqlSession.delete(SNS+".deleteReply", reply);
		
	}

	// 댓글삭제 용 아이디 체크
	@Override
	public String replyMemIdCheck(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(SNS+".replyMemIdCheck", repNum);
	}

	//상품리뷰 댓글 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sqlSession.update(SNS+".modifyReply", reply);
		
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		sqlSession.insert(SNS+".addCart", cart);
		
	}

	@Override
	public List<CartListVO> cartList(String memId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(SNS+".cartList", memId);
	}
}
