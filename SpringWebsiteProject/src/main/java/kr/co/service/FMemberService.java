package kr.co.service;

import java.util.List;

import kr.co.domain.FMemberVO;

public interface FMemberService {

	/* 회원가입 */
	public void insert(FMemberVO vo) throws Exception;

	/* 아이디 중복 검사 */
	public int idCheck(String memId) throws Exception;
	
	/* 로그인 */
    public FMemberVO memberLogin(FMemberVO vo) throws Exception;

    /* 회원정보 조회 */
	public FMemberVO read(String memId) throws Exception;

	/* 회원정보 수정 */
	public FMemberVO updateUI(String memId) throws Exception;

	/* 회원정보 수정 */
	public int update(FMemberVO vo) throws Exception;

	/* 회원정보 목록 */
	public List<FMemberVO> list() throws Exception;
	
	/* 회원정보 삭제 */
	public void delete(String memId) throws Exception;

}
