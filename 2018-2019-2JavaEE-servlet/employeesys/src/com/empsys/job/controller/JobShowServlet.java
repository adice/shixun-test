package com.empsys.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JobShowServlet
 */
@WebServlet("/job/show")
public class JobShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj = request.getAttribute("jobs");
		if(obj!=null) {
			List<Map<String, Object>> jobs = (List<Map<String, Object>>)obj;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head><meta charset='utf-8' /></head><body>");
			out.print("<a href='add.html'>add</a><br>");
			
			out.print("<table align='center' border='1'");
			//绘制表头
			out.print("<tr>");
			Set<String> cols = jobs.get(0).keySet();
			for(String col:cols) {
				out.print("<td>"+col+"</td>");
			}
			out.print("<td>操作</td>");
			out.print("</tr>");
			//绘制数据
			for(Map<String, Object> map:jobs) {
				out.print("<tr>");
				for(String col:cols) {
					out.print("<td>"+map.get(col)+"</td>");
				}
				out.print("<td><a href='edit?id="+map.get("id")+"'>修改</a>"
						+ " <a href='delete?id="+map.get("id")+"'>删除</a></td>");
				out.print("</tr>");
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
