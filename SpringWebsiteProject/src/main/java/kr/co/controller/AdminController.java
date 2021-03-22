package kr.co.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.domain.CategoryVO;
import kr.co.domain.FMemberVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;
import kr.co.service.AdminService;
import kr.co.utils.UploadFileUtils;
import net.sf.json.JSONArray;


@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AdminService aservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	/* 관리자 메인 페이지 이동 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {

		System.out.println("관리자 페이지 이동");
	}

	//회원목록 조회
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(String memId, Model model) throws Exception {
		FMemberVO vo = aservice.read(memId);
		model.addAttribute("vo", vo);
	}

	//회원 수정
	@RequestMapping(value = "update/{memId}", method = RequestMethod.GET)
	public String update(@PathVariable("memId") String memId, Model model) throws Exception {
		FMemberVO vo = aservice.updateUI(memId);
		model.addAttribute("vo", vo);
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(FMemberVO vo, Model model) throws Exception{
		
		int successCount = aservice.update(vo);
		
		if(successCount >= 1) {
			return"redirect: /list";
		} else {
			model.addAttribute("errmsg", "업데이트 실패");
		}
		
		return "redirect:/update/"+vo.getMemId();
	}
	
	//상품등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception{
		logger.info("get goods register");
		
		List<CategoryVO> category = null;
		category = aservice.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	//상품등록
		@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
		public String postGoodRegister(GoodsVO vo, MultipartFile file) throws Exception {
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = null;

			if(file != null) {
			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			} else {
			 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			}

			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
			aservice.register(vo);
			
			return "redirect:/admin/main";
		}
	
	//상품 목록
		@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
		public void getGoodsList(Model model) throws Exception{
			logger.info("get goods list");
			
			List<GoodsViewVO> list = aservice.goodslist();
			
			model.addAttribute("list", list);
		}
		
		
		// 상품 조회
		@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
		public void getGoodsview(@RequestParam("n") int gdsNum, Model model) throws Exception {
		 logger.info("get goods view");
		 
		 GoodsViewVO goods = aservice.goodsView(gdsNum);
		 
		 model.addAttribute("goods", goods);
		}
		  
		 // 상품 수정
		  @RequestMapping(value = "/goods/modify", method = RequestMethod.GET) public
		 void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws
		  Exception{ logger.info("get goods modify");
		  
		 GoodsViewVO goods = aservice.goodsView(gdsNum);
		 
		  model.addAttribute("goods", goods);
		  
		 List<CategoryVO> category = null;
		 category = aservice.category();
		 model.addAttribute("category", JSONArray.fromObject(category));}
		 
		// 상품 수정
		  @RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
		  public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		   logger.info("post goods modify");

		   // 새로운 파일이 등록되었는지 확인
		   if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		    // 기존 파일을 삭제
		    new File(uploadPath + req.getParameter("gdsImg")).delete();
		    new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
		    
		    // 새로 첨부한 파일을 등록
		    String imgUploadPath = uploadPath + File.separator + "imgUpload";
		    String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		    String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		    
		    vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		    vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		    
		   } else {  // 새로운 파일이 등록되지 않았다면
		    // 기존 이미지를 그대로 사용
		    vo.setGdsImg(req.getParameter("gdsImg"));
		    vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		    
		   }
		   
		   aservice.goodsModify(vo);
		   
		   return "redirect:/admin/main";
		  }
		  
		// 상품 삭제
		  @RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
		  public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		   logger.info("post goods delete");

		   aservice.goodsDelete(gdsNum);
		   
		   return "redirect:/admin/main";
		  }
		  
		// ck 에디터에서 파일 업로드
			@RequestMapping(value = "/goods/ckUpload", method = RequestMethod.POST)
			public void postCKEditorImgUpload(HttpServletRequest req,
											  HttpServletResponse res,
											  @RequestParam MultipartFile upload) throws Exception {
				logger.info("post CKEditor img upload");
				
				// 랜덤 문자 생성
				UUID uid = UUID.randomUUID();
				
				OutputStream out = null;
				PrintWriter printWriter = null;
						
				// 인코딩
				res.setCharacterEncoding("utf-8");
				res.setContentType("text/html;charset=utf-8");
				
				try {
					
					String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
					byte[] bytes = upload.getBytes();
					
					// 업로드 경로
					String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
					
					out = new FileOutputStream(new File(ckUploadPath));
					out.write(bytes);
					out.flush();  // out에 저장된 데이터를 전송하고 초기화
					
					String callback = req.getParameter("CKEditorFuncNum");
					printWriter = res.getWriter();
					String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면
					
					// 업로드시 메시지 출력
					printWriter.println("<script type='text/javascript'>"
								+ "window.parent.CKEDITOR.tools.callFunction("
								+ callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
								+"</script>");
					
					printWriter.flush();
					
				} catch (IOException e) { e.printStackTrace();
				} finally {
					try {
						if(out != null) { out.close(); }
						if(printWriter != null) { printWriter.close(); }
					} catch(IOException e) { e.printStackTrace(); }
				} 
				
				return;	
			}
			
			// 주문 목록
			@RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
			public void getOrderList(Model model) throws Exception {
				logger.info("get order list");
						
				List<OrderVO> orderList = aservice.orderList();
				
				model.addAttribute("orderList", orderList);
			}
			 
			// 주문 상세 목록
			@RequestMapping(value = "/shop/orderView", method = RequestMethod.GET)
			public void getOrderList(@RequestParam("n") String orderId,
									OrderVO order, Model model) throws Exception {
				logger.info("get order view");
				
				order.setOrderId(orderId);		
				List<OrderListVO> orderView = aservice.orderView(order);
				
				model.addAttribute("orderView", orderView);
			}
			
			// 주문 상세 목록 - 상태 변경
			@RequestMapping(value = "/shop/orderView", method = RequestMethod.POST)
			public String delivery(OrderVO order) throws Exception {
				logger.info("post order view");
						
				aservice.delivery(order);
				
				// 새로운 Service → DAO → Mapper 를 사용하지 않고, 기존에 있던 Service를 사용
				List<OrderListVO> orderView = aservice.orderView(order);	
				
				// 생성자 사용
				GoodsVO goods = new GoodsVO();
						
				for(OrderListVO i : orderView) {
					goods.setGdsNum(i.getGdsNum());
					goods.setGdsStock(i.getCartStock());
					aservice.changeStock(goods);
				}
			
				return "redirect:/admin/shop/orderView?n=" + order.getOrderId();
			}
			
			// 모든 소감(댓글)
			@RequestMapping(value = "/shop/allReply", method = RequestMethod.GET)
			public void getAllReply(Model model) throws Exception {
				logger.info("get all reply");
						
				List<ReplyListVO> reply = aservice.allReply();
				
				model.addAttribute("reply", reply);
			}

			// 모든 소감(댓글)
			@RequestMapping(value = "/shop/allReply", method = RequestMethod.POST)
			public String postAllReply(ReplyVO reply) throws Exception {
				logger.info("post all reply");
						
				aservice.deleteReply(reply.getRepNum());
				
				return "redirect:/admin/shop/allReply";
			}	

		}
