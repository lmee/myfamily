package com.jieer.myfamily.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class SessionCheck {
	
	public static boolean checkIsLogin(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

		if(request.getSession().getAttribute("isLogin")==null || !(Boolean)request.getSession().getAttribute("isLogin")){
			response.sendRedirect("/myfamily/index.jsp");
			return false;
		}
		return true;
	}

}
