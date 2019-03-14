package com.phoenix.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter{
	
	 public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
	 
		  req.setCharacterEncoding("utf-8");
	       resp.setCharacterEncoding("utf-8");

	       chain.doFilter(req, resp);
	 
	 }
	

}
