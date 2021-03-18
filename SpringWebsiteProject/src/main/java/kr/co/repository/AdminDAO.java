package kr.co.repository;

import java.util.List;

import kr.co.domain.CategoryVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;

public interface AdminDAO {
	public List<FMemberVO> list();

	public FMemberVO read(String memId);

	public int update(FMemberVO vo);
	
	//카테고리
	public List<CategoryVO> category() throws Exception;
	
	//상품등록
	public void register(GoodsVO vo) throws Exception;
	
	//상품목록
	public List<GoodsViewVO> goodslist() throws Exception;
	
	//상품조회 + 카테고리 조인
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품 수정
	public void goodsModify(GoodsVO vo)  throws Exception;
	
	//상품 삭제
	public void goodsDelete(int gdsNum) throws Exception;

}
