package kr.co.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	System.out.println("::::::preHandle:::::::");
	HandlerMethod method = (HandlerMethod)handler;
	Method m = method.getMethod();
	//특정 메서드에 대한 정보
	System.out.println(m);
	
	Object bean = method.getBean();
	// 특정 컨트롤러에 대한 정보
	System.out.println(bean);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("::::::postHandle:::::::");
		Object result = modelAndView.getModel().get("result");
		System.out.println(result);
		//test에는 model이라는 객체가 없으니, null이 나옴.
		
		if(result == null) {
			modelAndView.addObject("result", "test!!!");
		}
		result = modelAndView.getModel().get("result");
		System.out.println(result);
		//null이면 "test!!!"를 넣어달라고 구현하여, 데이터를 조작함.
		
		if(result != null) {
			response.sendRedirect("/board/list");
		}
		
	}

}
