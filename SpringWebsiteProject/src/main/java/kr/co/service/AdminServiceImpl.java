package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.CategoryVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;
import kr.co.repository.AdminDAO;
import kr.co.repository.FMemberDAO;

@Service
public class AdminServiceImpl implements AdminService{

	@Inject
	private AdminDAO dao;
	
	@Override
	public List<FMemberVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public FMemberVO read(String memId) {
		// TODO Auto-generated method stub
		return dao.read(memId);
	}

	@Override
	public FMemberVO updateUI(String memId) {
		// TODO Auto-generated method stub
		return dao.read(memId);
	}

	@Override
	public int update(FMemberVO vo) {
		int successCount = dao.update(vo);
		return successCount;
		
	}

	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}

	@Override
	public void register(GoodsVO vo) {
		// TODO Auto-generated method stub
		dao.register(vo);
	}

	@Override
	public List<GoodsVO> goodslist() {
		// TODO Auto-generated method stub
		return dao.goodslist();
	}

	@Override
	public GoodsViewVO goodsView(int fNum) {
		// TODO Auto-generated method stub
		return dao.goodsView(fNum);
	}

}
