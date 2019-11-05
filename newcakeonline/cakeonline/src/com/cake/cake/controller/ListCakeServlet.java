package com.cake.cake.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cake.cake.service.CakeService;
import com.cake.entity.Cake;
import com.cake.util.Page;

/**
 * Servlet implementation class ListCakeServlet
 */
@WebServlet("/cake/list")
public class ListCakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCakeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int type = Integer.parseInt(request.getParameter("type"));
		String name = request.getParameter("name");
		String num = request.getParameter("pageNum");
		int pageNum = 1;
		if(num!=null && !num.equals("")) {
			pageNum = Integer.parseInt(num);
		}
		CakeService cakeService = new CakeService();
//		List<Cake> list = cakeService.listCakes(type, name);
		Page<Cake> page = cakeService.listCakes(type, name, pageNum, 9);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/products.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
