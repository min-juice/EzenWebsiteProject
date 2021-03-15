package kr.co.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object login = session.getAttribute("login");
		if(login == null) {
			
			String uri = request.getRequestURI(); // /board/insert
			String query = request.getQueryString(); // id=m001&pw=1234
			
			if (query == null || query.equalsIgnoreCase("null")) {
				query="";
				// query에 아무것도 없다면, /board/insert 만 있는 형태.
			} else {
				query = "?"+query;
				//uri와 query사이에 ? 이 없어서 null이 뜰 수 있으니, 물음표 추가 "?id=m001&pw=1234"
			}
			
			if(request.getMethod().equalsIgnoreCase("GET")) {
				session.setAttribute("dest", uri+query);
				// /board/insert?id=m001&pw=1234
			}
			response.sendRedirect("/member/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}	
	
}
