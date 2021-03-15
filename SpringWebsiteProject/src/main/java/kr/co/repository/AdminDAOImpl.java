package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.CategoryVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;

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

	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ANS+".category");
	}

	@Override
	public void register(GoodsVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(ANS+".register", vo);
	}

	@Override
	public List<GoodsVO> goodslist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ANS+".goodslist");
	}

	@Override
	public GoodsViewVO goodsView(int fNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ANS+".goodsView", fNum);
	}

}
