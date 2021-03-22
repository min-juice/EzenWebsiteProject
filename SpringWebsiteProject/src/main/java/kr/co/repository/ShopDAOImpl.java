package kr.co.repository;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.OrderDetailVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
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

	/* 
	 * 메서드명은 list 로 똑같지만, 매개변수가 다르기 떄문에 오버로딩 가능
	 */

	// 상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sqlSession.selectOne("com.kubg.mappers.adminMapper"
						+ ".goodsView", gdsNum);
	}

	// 상품 소감(댓글) 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sqlSession.insert(SNS + ".registReply", reply);
	}

	// 상품 소감(댓글) 리스트
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return sqlSession.selectList(SNS + ".replyList", gdsNum);
	}

	// 상품 소감(댓글) 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sqlSession.delete(SNS + ".deleteReply", reply);
	}

	// 아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sqlSession.selectOne(SNS + ".replyUserIdCheck", repNum);
	}

	// 상품 소감(댓글) 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sqlSession.update(SNS + ".modifyReply", reply);
	}

	// 카트 담기
	@Override
	public void addCart(CartListVO cart) throws Exception {
		sqlSession.insert(SNS + ".addCart", cart);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(String memId) throws Exception {
		return sqlSession.selectList(SNS + ".cartList", memId);
	}

	// 카트 삭제
		@Override
		public void deleteCart(CartVO cart) throws Exception {
			sqlSession.delete(SNS + ".deleteCart", cart);
		}
		
		// 주문 정보
		@Override
		public void orderInfo(OrderVO order) throws Exception {
			sqlSession.insert(SNS + ".orderInfo", order);
		}
		
		// 주문 상세 정보
		@Override
		public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
			sqlSession.insert(SNS + ".orderInfo_Details", orderDetail);
		}

		// 카트 비우기
		@Override
		public void cartAllDelete(String memId) throws Exception {
			sqlSession.delete(SNS + ".cartAllDelete", memId);
		}

		// 주문 목록
		@Override
		public List<OrderVO> orderList(OrderVO order) throws Exception {
			return sqlSession.selectList(SNS + ".orderList", order);
		}

		// 특정 주문 목록
		@Override
		public List<OrderListVO> orderView(OrderVO order) throws Exception {
			return sqlSession.selectList(SNS + ".orderView", order);
		}
}
