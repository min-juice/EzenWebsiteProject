package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CategoryVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
import kr.co.domain.ReplyListVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Inject
	private SqlSession sqlSession;
	
	private final String ANS = "kr.co.admin";
	
	@Override
	public List<FMemberVO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ANS+".list");
	}

	@Override
	public FMemberVO read(String memId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ANS+".read", memId);
	}

	@Override
	public int update(FMemberVO vo) {
		int successCount = sqlSession.update(ANS+".update", vo);
		return successCount;
		
	}

	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ANS+".category");
	}

	//상품등록
	@Override
	public void register(GoodsVO vo)  throws Exception{
		// TODO Auto-generated method stub
		sqlSession.insert(ANS+".register", vo);
	}
	
	//상품목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ANS+".goodslist");
	}
	
	//상품조회 + 카테고리 조인
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ANS+".goodsView", gdsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sqlSession.update(ANS+".goodsModify", vo);
		
	}

	//상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sqlSession.delete(ANS+"goodsDelete", ANS);
		
	}
	
	// 주문 목록
		@Override
		public List<OrderVO> orderList() throws Exception {
			return sqlSession.selectList(ANS + ".orderList");
		}

		// 특정 주문 목록 
		@Override
		public List<OrderListVO> orderView(OrderVO order) throws Exception {
			return sqlSession.selectList(ANS + ".orderView", order);
		}

		// 배송 상태
		@Override
		public void delivery(OrderVO order) throws Exception {
			sqlSession.update(ANS + ".delivery", order);
		}
		
		// 상품 수량 조절
		@Override
		public void changeStock(GoodsVO goods) throws Exception {		
			sqlSession.update(ANS + ".changeStock", goods);
		}

		// 모든 소감(댓글)
		@Override
		public List<ReplyListVO> allReply() throws Exception {
			return sqlSession.selectList(ANS + ".allReply");
		}

		// 소감(댓글) 삭제
		@Override
		public void deleteReply(int repNum) throws Exception {
			sqlSession.delete(ANS + ".deleteReply", repNum);
		}
	

}
