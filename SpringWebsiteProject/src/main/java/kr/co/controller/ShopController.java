package kr.co.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;
import kr.co.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	ShopService service;
	
	//카테고리 별 상품 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode,
						@RequestParam("l") int level, Model model) throws Exception{
		
		logger.info("get llist");
		
		List<GoodsViewVO> list = null;
		list = service.list(cateCode, level);
		list = service.list(cateCode);
		model.addAttribute("list", list);
	}

	//상품 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get view");
		
		GoodsViewVO view = service.goodsView(gdsNum);
		model.addAttribute("view", view);
		
		/*
		 * List<ReplyListVO> reply = service.replyList(gdsNum);
		 * model.addAttribute("reply", reply);
		 */
	}
	
	/*
	 * // 상품 조회 - 소감(댓글) 작성
	 * 
	 * @RequestMapping(value = "/view", method = RequestMethod.POST) public String
	 * registReply(ReplyVO reply, HttpSession session) throws Exception {
	 * logger.info("regist reply");
	 * 
	 * FMemberVO member = (FMemberVO)session.getAttribute("member");
	 * reply.setMemId(member.getMemId());
	 * 
	 * service.registReply(reply);
	 * 
	 * return "redirect:/shop/view?n=" + reply.getGdsNum(); }
	 */
	
	// 상품 소감(댓글) 작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply,  HttpSession session) throws Exception {
	 logger.info("regist reply");
	 
	 FMemberVO member = (FMemberVO)session.getAttribute("member");
	 reply.setMemId(member.getMemId());
	 
	 service.registReply(reply);
	} 
	
	// 상품 소감(댓글) 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
	 logger.info("get reply list");
	   
	 List<ReplyListVO> reply = service.replyList(gdsNum);
	 
	 return reply;
	} 
	
	// 상품 소감(댓글) 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyVO reply,  HttpSession session) throws Exception {
	 logger.info("post delete reply");

	 int result = 0;
	 
	 FMemberVO member = (FMemberVO)session.getAttribute("member");
	 String memId = service.replyMemIdCheck(reply.getRepNum());
	   
	 if(member.getMemId().equals(memId)) {
	  
	  reply.setMemId(member.getMemId());
	  service.deleteReply(reply);
	  
	  result = 1;
	 }
	 
	 return result; 
	}
	
	// 상품 소감(댓글) 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
	 logger.info("modify reply");
	 
	 int result = 0;
	 
	 FMemberVO member = (FMemberVO)session.getAttribute("member");
	 String memId = service.replyMemIdCheck(reply.getRepNum());
	 
	 if(member.getMemId().equals(memId)) {
	  
	  reply.setMemId(member.getMemId());
	  service.modifyReply(reply);
	  result = 1;
	 }
	 
	 return result;
	} 
	
	// 카트 담기
	@ResponseBody
	@RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
	public int addCart(CartVO cart, HttpSession session) throws Exception {
	 
		int result = 0;
		
	 FMemberVO member = (FMemberVO)session.getAttribute("member");
	 if(member != null) {
		  cart.setMemId(member.getMemId());
		  service.addCart(cart);
		  result = 1;
		 }
		 
		 return result;
		}
	
	// 카트 목록
	@RequestMapping(value = "/shop/cartList", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
	 logger.info("get cart list");
	 
	 FMemberVO member = (FMemberVO)session.getAttribute("member");
	 String memId = member.getMemId();
	 
	 List<CartListVO> cartList = service.cartList(memId);
	 
	 model.addAttribute("cartList", cartList);
	 
	}
}
