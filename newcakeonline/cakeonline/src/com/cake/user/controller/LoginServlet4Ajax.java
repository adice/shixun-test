package com.cake.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cake.entity.User;
import com.cake.user.service.UserService;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServlet4Ajax
 */
@WebServlet("/login4Ajax")
public class LoginServlet4Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet4Ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		User user = userService.login(email, password);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			PrintWriter out = response.getWriter();
//			out.print("{\"r\": \"ok\",\"name\": \""+user.getNickName()+"\"}");
			Gson gson = new Gson();
			String json = gson.toJson(user);
			out.print(json);
		}else {
			PrintWriter out = response.getWriter();
			out.print("{\"result\":\"fail\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
