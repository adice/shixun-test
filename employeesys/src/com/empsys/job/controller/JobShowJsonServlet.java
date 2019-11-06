package com.empsys.job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empsys.entity.Job;
import com.google.gson.Gson;

@WebServlet("/showJson")
public class JobShowJsonServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Job job = new Job();
		job.setId(39);
		job.setName("cto");
		
		Gson gson=new Gson();
		String tem = gson.toJson(job);
		
		PrintWriter out = resp.getWriter();
		out.print(tem);
		out.flush();
		out.close();
		
	}

}
