package com.empsys.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empsys.entity.Job;
import com.empsys.job.service.JobServiceImpl;

/**
 * Servlet implementation class JobEditServlet
 */
@WebServlet("/job/edit")
public class JobEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Job job = null;
		if(id!=null && !id.equals("")) {
			job = new JobServiceImpl().getJob(Integer.parseInt(id));
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='utf-8' /></head><body>");
		out.print("<form action='edit' method='post'>");
		out.print("<input type='hidden' name='id' value='"+id+"'/>");
		out.print("<input type='text' name='name' value='"+job.getName()+"'/>");
		out.print("<input type='submit' value='保存'>");
		out.print("</form>");
		out.print("</body></html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Job job = new Job();
		job.setId(Integer.parseInt(id));
		job.setName(name);
		boolean isEdited = new JobServiceImpl().editJob(job);
		if(isEdited)
			response.sendRedirect("list");
		else
			response.sendRedirect("edit?id="+id);
	}

}
