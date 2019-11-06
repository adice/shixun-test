package com.empsys.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empsys.entity.Employee;
import com.google.gson.Gson;

@WebServlet("/employee/show")
public class ShowEmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee e = new Employee();
		e.setId(1);
		e.setName("zhangsan");
		e.setJobId(3);
		e.setPayLevelId(4);
		
		Gson gson = new Gson();
		String cache = gson.toJson(e);
		
		PrintWriter out = resp.getWriter();
		out.print(cache);
		out.flush();
		out.close();
	}

}
