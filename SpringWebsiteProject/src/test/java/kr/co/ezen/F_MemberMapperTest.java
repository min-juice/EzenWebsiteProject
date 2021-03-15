package kr.co.ezen;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.domain.FMemberVO;
import kr.co.repository.FMemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class F_MemberMapperTest {

	@Inject
	private FMemberDAO dao;

	/*
	 * @Test public void insert() { FMemberVO vo = new FMemberVO();
	 * 
	 * vo.setMemId("test1"); vo.setMemPw("test1"); vo.setMemName("test1");
	 * vo.setMemMail("test1"); vo.setMemAd1("test1"); vo.setMemAd2("test1");
	 * vo.setMemAd3("test1");
	 * 
	 * dao.insert(vo); }
	 */

	/*
	 * @Test public void memIdChk() throws Exception{ String id = "admin"; String
	 * id2 = "test100"; dao.idCheck(id); dao.idCheck(id2); }
	 */

	/* 로그인 쿼리 mapper 메서드 테스트 */
	@Test
	public void memberLogin() throws Exception {

		FMemberVO member = new FMemberVO(); // FMemberVO 변수 선언 및 초기화

		/*
		 * 올바른 아이디 비번 입력경우 member.setMemId("test1"); member.setMemPw("test1");
		 */

		/* 올바른 않은 아이디 비번 입력경우 */
		 member.setMemId("test1123");
		 member.setMemPw("test1321321");

		dao.memberLogin(member);
		System.out.println("결과 값 : " + dao.memberLogin(member));

	}

}
