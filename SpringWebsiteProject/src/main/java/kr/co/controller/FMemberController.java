package kr.co.controller;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.domain.FMemberVO;
import kr.co.service.FMemberService;

@Controller
@RequestMapping("/fmember")
public class FMemberController {

	@Inject
	private FMemberService fservice;

	@Inject
	private JavaMailSender mailSender;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	private static final Logger logger = LoggerFactory.getLogger(FMemberController.class);

	// 회원가입 페이지 이동
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		logger.info("회원가입 페이지 진입");
		System.out.println("sysout");

	}

	// 회원가입
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(FMemberVO vo) throws Exception {

		String rawPw = ""; // 인코딩 전 비밀번호
		String encodePw = ""; // 인코딩 후 비밀번호

		rawPw = vo.getMemPw(); // 비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(rawPw); // 비밀번호 인코딩
		vo.setMemPw(encodePw); // 인코딩된 비밀번호 member객체에 다시 저장

		/* 회원가입 쿼리 실행 */
		fservice.insert(vo);

		return "redirect:/";
	}

	// 로그인 페이지 이동

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("로그인 페이지 진입");
	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memIdChkPOST(String memId) throws Exception {

		int result = fservice.idCheck(memId);
		System.out.println("결과값 =" + result);
		if (result != 0) {
			return "fail";
		} else {
			return "success";
		}
	} // memIdChkPOST() 종료

	/* 이메일 인증 */
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {

		/* 뷰(view)로 부터 넘어온 데이터 확인 */
		System.out.println("이메일 데이터 전송 확인");
		System.out.println("인증번호 :" + email);

		/* 인증번호(난수) 생성 */
		Random random = new Random();
		int checkNum = random.nextInt(8888) + 1111;
		System.out.println("인증번호 :" + checkNum);

		/* 이메일 보내기 */
		String setFrom = "patrm@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는" + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		/*
		 * try {
		 * 
		 * MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
		 * helper = new MimeMessageHelper(message, true, "utf-8");
		 * helper.setFrom(setFrom); helper.setTo(toMail); helper.setSubject(title);
		 * helper.setText(content, true); mailSender.send(message);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		String num = Integer.toString(checkNum);

		return num;
	}

	/* 로그인 */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, FMemberVO vo, RedirectAttributes rttr) throws Exception {

		/*
		 * System.out.println("login 메서드 진입"); System.out.println("전달된 데이터 : " + vo);
		 */

		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";

		FMemberVO lvo = fservice.memberLogin(vo); // 제출한아이디와 일치하는 아이디 있는지

		if (lvo != null) { // 일치하는 아이디 존재시

			rawPw = vo.getMemPw(); // 사용자가 제출한 비밀번호
			encodePw = lvo.getMemPw(); // 데이터베이스에 저장한 인코딩된 비밀번호

			if (true == pwEncoder.matches(rawPw, encodePw)) { // 비밀번호 일치여부 판단

				lvo.setMemPw(""); // 인코딩된 비밀번호 정보 지움
				session.setAttribute("member", lvo); // session에 사용자의 정보 저장
				return "redirect:/"; // 메인페이지 이동

			} else {

				rttr.addFlashAttribute("result", 0);
				return "redirect:/fmember/login"; // 로그인 페이지로 이동

			}

		} else { // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)

			rttr.addFlashAttribute("result", 0);
			return "redirect:/fmember/login"; // 로그인 페이지로 이동

		}
	}

	/* 메인페이지 로그아웃 */
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request) throws Exception {

		logger.info("logoutMainGET메서드 진입");

		HttpSession session = request.getSession();

		session.invalidate();

		return "redirect:/";
	}

	/* 비동기방식 로그아웃 메서드 */
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	@ResponseBody
	public void logoutPOST(HttpServletRequest request) throws Exception {

		logger.info("비동기 로그아웃 메서드 진입");

		HttpSession session = request.getSession();

		session.invalidate();

	}
	
	
	/* 회원정보 리스트 이동 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void List(Model model) throws Exception{
		
		List<FMemberVO> list = fservice.list();
		model.addAttribute("list", list);
	}
	
	/* 회원정보 리스트 조회 */
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("memId") String memId, Model model) throws Exception {
		
		FMemberVO vo = fservice.read(memId);
		
		model.addAttribute("read", vo);
	}
	
	/* 회원정보 수정조회 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(@RequestParam("memId") String memId, Model model) throws Exception {
		
		FMemberVO vo = fservice.updateUI(memId);
		model.addAttribute("vo", vo);
		
		
	}
	
	
	/* 회원정보 수정 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(FMemberVO vo) throws Exception {
		int successCount = fservice.update(vo);
		
		
		if(successCount >= 1) {
			return "redirect:/read";
		}else {
			return "redirect:/update?memId=${vo.memId}";
		}
	}
	   
	/* 회원정보 삭제 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam("memId") String memId) throws Exception{
		fservice.delete(memId);
		
		return "redirect:/fmember/list";
	}
	
	 /* 회원정보 삭제 */
	   @RequestMapping(value = "delete", method = RequestMethod.GET)
	   public void deleteConfirm(@RequestParam("memId") String memId, Model model) throws Exception {
	      model.addAttribute("delete", memId);
	   }
	
	
}
