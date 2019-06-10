package com.empsys.paylevel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empsys.entity.PayLevel;

/**
 * Servlet implementation class PayLevelShowServlet
 */
@WebServlet("/paylevel/show")
public class PayLevelShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayLevelShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj = request.getAttribute("paylevels");
		if(obj!=null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head><meta charset='utf-8' /></head><body>");
			out.print("<a href='add.html'>add</a><br>");
			
			out.print("<table align='center' border='1'");
			//绘制表头
			out.print("<tr><td>id</td><td>名称</td><td>薪资</td></tr>");
			List<PayLevel> list = (List<PayLevel>)obj;
			for(PayLevel pl:list) {
				out.print("<td>"+pl.getId()+"</td>");
				out.print("<td>"+pl.getName()+"</td>");
				out.print("<td>"+pl.getBasePay()+"</td>");
			}
			out.print("</table>");
			out.print("</body></html>");
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
