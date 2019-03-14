package com.phoenix.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AuthenticateFilter implements Filter {



    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        if (req instanceof HttpServletRequest){	//http请求
            HttpServletRequest request = (HttpServletRequest)req;
            String login = request.getParameter("login");
            if (null == login || "".equals(login)){	//非登录请求
                HttpSession session = request.getSession();
                String  username = (String) session.getAttribute("username");
                String sessionRoleName = (String) session.getAttribute("roleName");
                if (null != username&&!"".equals(username)){
                    chain.doFilter(request, resp);
                }else{
                    request.setAttribute("opTip", "你还没有登录，请登录后继续访问！");
                    request.getRequestDispatcher("/index.jsp").forward(request, resp);
                }
            }else{	//登录请求
                chain.doFilter(request, resp);
            }
        }else{	//其他请求
            chain.doFilter(req, resp);
        }

    }
}