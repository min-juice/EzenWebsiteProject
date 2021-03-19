package kr.co.service;

import java.util.List;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;

public interface ShopService {
	
	//카테고리별 상품 리스트
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;

	// 카테고리별 상품 리스트
	public List<GoodsViewVO> list(int cateCode) throws Exception;

	//상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	//상품리뷰 댓글 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	//상품리뷰 댓글 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;

	// 댓글삭제 용 아이디 체크
	public String replyMemIdCheck(int repNum) throws Exception;

	//상품리뷰 댓글 삭제
	public void deleteReply(ReplyVO reply) throws Exception;

	//상품리뷰 댓글 수정
	public void modifyReply(ReplyVO reply) throws Exception;

	//카트 담기
	public void addCart(CartVO cart) throws Exception;

	//카트 목록
	public List<CartListVO> cartList(String memId) throws Exception;

}
