package com.jieer.myfamily.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jieer.myfamily.dao.FamilyMemberDao;
import com.jieer.myfamily.utils.SessionCheck;

public class ShowAllResults extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7921515504810627408L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
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
		HttpSession session = request.getSession();
		FamilyMemberDao fmd =new FamilyMemberDao();
		session.setAttribute("memberlist", fmd.queryMemberList());
		session.setAttribute("editid", request.getParameter("editid"));
		request.getRequestDispatcher("/results.jsp").forward(request, response);
		fmd.destroyConnection();
	}

}
