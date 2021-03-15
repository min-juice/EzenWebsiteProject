package kr.co.service;

import java.util.List;

import kr.co.domain.FMemberVO;
public interface FMemberService {

	public void insert(FMemberVO vo);

	public int idCheck(String memId) throws Exception;
	
	/* 로그인 */
    public FMemberVO memberLogin(FMemberVO vo) throws Exception;

	public FMemberVO read(String memId);

	public FMemberVO updateUI(String memId);

	public int update(FMemberVO vo);

	public void delete(FMemberVO vo);

}
