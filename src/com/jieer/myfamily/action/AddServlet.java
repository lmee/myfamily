package com.jieer.myfamily.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jieer.myfamily.dao.FamilyMemberDao;
import com.jieer.myfamily.enity.FamilyMember;
import com.jieer.myfamily.utils.SessionCheck;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134096361140866070L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!SessionCheck.checkIsLogin(request, response)){
			return;
		}
		if(isTokenValidate(request)){
			FamilyMember fm =new FamilyMember();
			fm.setAppellation(request.getParameter("Appellation"));
			fm.setName(request.getParameter("Name"));
			fm.setAge(Integer.parseInt(request.getParameter("Age")));
			fm.setFavorite(request.getParameter("Favorite"));
			fm.setJob(request.getParameter("Job"));
			FamilyMemberDao fmd =new FamilyMemberDao();
			fmd.addFamilyMember(fm);
			fmd.destroyConnection();
			request.getSession().removeAttribute("token");
		}
		request.getRequestDispatcher("ShowAllResults").forward(request, response);
	}

	public boolean isTokenValidate(HttpServletRequest request){
		String client_token = request.getParameter("token");
		if(client_token == null){
			return false;
		}
		String server_token = (String)request.getSession().getAttribute("token");
		if(server_token == null){
			return false;
		}
		if(!client_token.equals(server_token)){
			return false;
		}
		return true;
	}
}
