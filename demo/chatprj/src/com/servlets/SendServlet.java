package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendServlet
 */
@WebServlet("/send")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String msg=request.getParameter("msg");
		String name=request.getSession().getAttribute("myname").toString();
		String temp=name+"หตฃบ"+msg;
		Object obj=this.getServletContext().getAttribute("msgs");
		if(obj==null) {
			List list=new ArrayList();
			list.add(temp);
			this.getServletContext().setAttribute("msgs", list);
		}else {
			List<String> list=(ArrayList)obj;
			list.add(temp);
			this.getServletContext().setAttribute("msgs", list);
		}
		response.sendRedirect("send.jsp");
	}

}
