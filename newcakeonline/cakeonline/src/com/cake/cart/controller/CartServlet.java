package com.cake.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cake.cake.service.CakeService;
import com.cake.cart.service.Cart;
import com.cake.entity.Cake;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		PrintWriter out = response.getWriter();
		if(obj==null) {
			out.print("{\"result\":\"nologin\"}");
			out.flush();
			out.close();
		}else {
			String id = request.getParameter("id");
			String q = request.getParameter("q");
			Cake cake = new CakeService().getCake(Integer.parseInt(id));
			Cart cart = null;
			Object objCart = session.getAttribute("cart");
			if(objCart==null) {
				cart = new Cart();
			}else {
				cart = (Cart)objCart;
			}
			cart.add(cake, Integer.parseInt(q));
			session.setAttribute("cart", cart);
			out.print("{\"result\":\""+cart.getInfo()+"\"}");
			out.flush();
			out.close();
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
