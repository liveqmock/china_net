package com.neusoft.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.vo.User;

/**
 * �ж��û��Ƿ��¼ �� ���������ַ���
 */
public class NetcomFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		User user=(User) req.getSession().getAttribute("user");
		
		if((!req.getServletPath().equals("/login.jsp"))&&(!req.getServletPath().equals("/login.do"))){
			if(user==null){
				HttpServletResponse res=(HttpServletResponse) response;
				//System.out.println("û�е�¼��������--------");
				res.sendRedirect("login.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
}