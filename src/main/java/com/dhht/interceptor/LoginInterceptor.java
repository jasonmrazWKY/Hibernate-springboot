package com.dhht.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dhht.entity.User;
import com.dhht.utils.WebUtil;

public class LoginInterceptor implements HandlerInterceptor{
	
	private static final Logger log = Logger.getLogger(LoginInterceptor.class);

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("------进入preHandle------");
		System.out.println("请求路径："+request.getServletPath());
		// 获取session
		HttpSession session = request.getSession(true);
		// 判断用户是否存在，不存在就跳转到登录界面
		User loginUser = WebUtil.getLoginUser();
        if(loginUser == null) {
        	//log.info("未登录。ip:" + WebUtil.getRemoteIp() + " 目标资源:" + path);
        	log.info("未登录IP:" + WebUtil.getRemoteIp() + " 目标资源:" + request.getServletPath());
        	response.sendRedirect("/user/gologin");
            return false;
        }
		
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
