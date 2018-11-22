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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//1、获取昵称
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("username");
		if(name==null || name.equals("")) {
			request.setAttribute("msg", "请填写用户名！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			//2、
			Object obj=this.getServletContext().getAttribute("names");
			if(obj==null) {
				request.getSession().setAttribute("myname", name);
				List list=new ArrayList();
				list.add(name);
				this.getServletContext().setAttribute("names", list);
				response.sendRedirect("main.jsp");
			}else {
				boolean isExist=false;
				List<String> list=(ArrayList)obj;
				for(String temp:list) {
					if(temp.equals(name)) {
						isExist=true;
						break;
					}
				}
				if(isExist) {
					request.setAttribute("msg", "您的昵称已被使用，请换一个！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					request.getSession().setAttribute("myname", name);
					list.add(name);
					this.getServletContext().setAttribute("names", list);
					response.sendRedirect("main.jsp");
				}
			}
		}
		
	}

}
