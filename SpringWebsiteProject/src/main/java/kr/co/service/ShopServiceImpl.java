package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;
import kr.co.repository.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService{

	@Inject
	private ShopDAO dao;
	
	// 카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
	 
	 int cateCodeRef = 0; 
	 
	 if(level == 1) {  // lavel 1 = 1차 분류.
	  
	  cateCodeRef = cateCode;
	  return dao.list(cateCode, cateCodeRef);
	  
	  
	 } else {  // lavel 2 = 2차 분류
	  
	  return dao.list(cateCode);
	  
	 }
	 
	}

	// 카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(cateCode);
	}

	//상품조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.goodsView(gdsNum);
	}

	//상품리뷰 댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
		
	}

	//상품리뷰 댓글 리스트
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyList(gdsNum);
	}

	// 댓글삭제 용 아이디 체크
	@Override
	public String replyMemIdCheck(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyMemIdCheck(repNum);
	}

	//상품리뷰 댓글 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		dao.deleteReply(reply);
		
	}

	//상품리뷰 댓글 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		dao.modifyReply(reply);
		
	}

	//카트 담기
	@Override
	public void addCart(CartVO cart) throws Exception {
		dao.addCart(cart);
		
	}

	@Override
	public List<CartListVO> cartList(String memId) throws Exception {
		// TODO Auto-generated method stub
		return dao.cartList(memId);
	}
	
	
}
