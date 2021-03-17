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

	/* 회원가입 */
	@Override
	public void insert(FMemberVO vo) throws Exception  {
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

	/* 회원정보 조회 */
	@Override
	public FMemberVO read(String memId) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(memId);
	}

	/* 회원정보 수정 */
	@Override
	public FMemberVO updateUI(String memId) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(memId);
	}

	/* 회원정보 수정 */
	@Override
	public int update(FMemberVO vo) throws Exception {
		int successCount = dao.update(vo);
		return successCount;
	}

	/* 회원정보 삭제 */
	@Override
	public void delete(String memId) throws Exception {
		dao.delete(memId);
		
	}

	/* 회원정보 목록 */
	@Override
	public List<FMemberVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	


}
