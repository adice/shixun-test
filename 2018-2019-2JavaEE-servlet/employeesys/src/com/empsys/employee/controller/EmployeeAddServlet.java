package com.empsys.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empsys.employee.service.EmployeeServiceImpl;
import com.empsys.entity.Employee;
import com.empsys.entity.Job;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/employee/add")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Job> list = new EmployeeServiceImpl().listJobs();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='utf-8' /></head><body>");
		out.print(request.getAttribute("msg"));
		out.print("<form action='add' method='post'>");
		out.print("<select name='job'>");
		for(Job job : list) {
			out.print("<option value='"+job.getId()+"'>"+job.getName()+"</option>");
		}
		out.print("</select><br>");
		out.print("<input type='text' name='name' /><br>");
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
		String jobId = request.getParameter("job");
		String name = request.getParameter("name");
		Employee employee = new Employee();
		employee.setName(name);
		employee.setJobId(Integer.parseInt(jobId));
		boolean isSaved = new EmployeeServiceImpl().addEmployee(employee);
		if(isSaved) {
			
		}else {
			request.setAttribute("msg", "员工新增失败！");
			doGet(request, response);
		}
	}

}
