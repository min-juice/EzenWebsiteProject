package kr.co.service;

import java.util.List;

import kr.co.domain.CategoryVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;

public interface AdminService {

	public List<FMemberVO> list();

	public FMemberVO read(String memId);

	public FMemberVO updateUI(String memId);

	public int update(FMemberVO vo);
	
	//카테고리
	public List<CategoryVO> category() throws Exception;

	public void register(GoodsVO vo);

	public List<GoodsVO> goodslist();

	public GoodsViewVO goodsView(int fNum);


}
