package kr.co.repository;

import java.util.List;

import kr.co.domain.FMemberVO;

public interface FMemberDAO {

	/* 회원가입 */
	public void insert(FMemberVO vo);

	/* 아이디 중복 검사 */
	public int idCheck(String memId);
	
	/* 로그인 */
	public FMemberVO memberLogin(FMemberVO vo);

	public FMemberVO read(String memId);

	public int update(FMemberVO vo);

	public void delete(FMemberVO vo);

	


}
