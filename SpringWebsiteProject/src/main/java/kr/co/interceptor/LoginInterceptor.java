package kr.co.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;





public class LoginInterceptor extends HandlerInterceptorAdapter {

   @Override
   public boolean preHandle(HttpServletRequest request, 
                     HttpServletResponse response, 
                     Object handler)
         throws Exception {
      System.out.println(":::::::preHandle::::::::::::::");
      request.getSession();
      //session이 있으면, 누군가가 로그인을 했다는 신호
      //null이라면, 로그인을 한 사람이 없다는 뜻
      HttpSession session = request.getSession();
      Object login = session.getAttribute("login");
      if(login != null) {
    	  session.removeAttribute("login");
    	  //누군가가 로그인 했다는 뜻으로, login이라는 이름으로 바인딩 된 데이터를 삭제
      }
      return true;
   }

   @Override
   public void postHandle(HttpServletRequest request, 
                     HttpServletResponse response, 
                     Object handler,
                     ModelAndView modelAndView) 
                              throws Exception {
      System.out.println(":::::::::::postHandle::::::::::::::");
      HttpSession session = request.getSession();
      
      Object login = modelAndView.getModel().get("login");
      //Object login이 null 인 상황 : id, pw 오류 등의 정보가 다른경우
      
      if(login != null) {
    	  session.setAttribute("login", login);
    	  //로그인 성공의 경우
    	  
    	  String dest = (String) session.getAttribute("dest");
    	  response.sendRedirect(dest != null? dest : "/");
    	  //response.sendRedirect("/");
    	  // response.sendRedirect("/member/list"); 같은 페이지
      } else {
    	  response.sendRedirect("/member/login");
      }
      
      
      
   }

   
   
}