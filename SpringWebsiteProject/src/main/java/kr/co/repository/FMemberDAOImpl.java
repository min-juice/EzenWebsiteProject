package kr.co.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.FMemberVO;

@Repository
public class FMemberDAOImpl implements FMemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private final String FNS = "kr.co.fmember";

	@Override
	public void insert(FMemberVO vo) throws Exception {
		sqlSession.insert(FNS+".insert", vo);
		
	}

	@Override
	public int idCheck(String memId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(FNS+".idCheck", memId);
	}

	@Override
	public FMemberVO memberLogin(FMemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(FNS+".memberLogin", vo);
	}

	@Override
	public FMemberVO read(String memId)  throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectOne(FNS+".read", memId);
	}

	@Override
	public int update(FMemberVO vo) throws Exception {
		int successCount = sqlSession.update(FNS+".update", vo);
		
		return successCount;
	}

	@Override
	public void delete(String memId) throws Exception {
		sqlSession.delete(FNS+".delete", memId);
		
	}

	@Override
	public List<FMemberVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(FNS+".list");
	}

	

}
