package servlets;

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
		String name = request.getParameter("username");
		Object objNames = this.getServletContext().getAttribute("names");
		if(objNames==null) {
			List<String> list = new ArrayList<String>();
			list.add(name);
			this.getServletContext().setAttribute("names", list);
			request.getSession().setAttribute("name", name);
			response.sendRedirect("main.html");
		}else {
			List<String> list = (List)objNames;
			if(list.contains(name)) {
				request.setAttribute("loginmsg", "您的昵称已被使用，请换一个<br>");
				request.getRequestDispatcher("index").forward(request, response);
			}else {
				list.add(name);
				this.getServletContext().setAttribute("names", list);
				request.getSession().setAttribute("name", name);
				response.sendRedirect("main.html");
			}
		}
		
	}

}
