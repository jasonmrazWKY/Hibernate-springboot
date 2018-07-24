package com.dhht.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	private static final Logger log = Logger.getLogger(LoginInterceptor.class);

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("------进入preHandle------");
		System.out.println(request.getServletPath());
		// 获取session
//		HttpSession session = request.getSession(true);
//		// 判断用户ID是否存在，不存在就跳转到登录界面
//		if (session.getAttribute("userId") == null) {
//			log.info("------:跳转到login页面！");
//			System.out.println(request.getContextPath() + "/login");
//			response.sendRedirect("/user/gologin");
//			return false;
//		} else {
//			return true;
//		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
