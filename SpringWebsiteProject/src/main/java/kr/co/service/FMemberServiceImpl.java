package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.FMemberVO;
import kr.co.repository.FMemberDAO;

@Service
public class FMemberServiceImpl implements FMemberService{

	@Inject
	FMemberDAO dao;

	@Override
	public void insert(FMemberVO vo) {
		dao.insert(vo);
		
	}

	/* 아이디 중복 검사 */
	@Override
	public int idCheck(String memId) throws Exception{
		// TODO Auto-generated method stub
		return dao.idCheck(memId);
	}

	/* 로그인 */
	@Override
	public FMemberVO memberLogin(FMemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberLogin(vo);
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
	public void delete(FMemberVO vo) {
		dao.delete(vo);
		
	}

	


}
