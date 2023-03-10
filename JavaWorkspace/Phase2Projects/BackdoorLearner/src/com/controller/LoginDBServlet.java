package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;
import com.service.AdminService;

/**
 * Servlet implementation class LoginDBServlet
 */
@WebServlet("/LoginDBServlet")
public class LoginDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user= request.getParameter("user");
		String password= request.getParameter("pass");
		AdminService ps = new AdminService();
		RequestDispatcher rd1 = request.getRequestDispatcher("login.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		
		Admin a = ps.getAdmin();
		System.out.println(a.getUser());
		System.out.println(a.getPassword());
		if(a.getUser().equals(user) && a.getPassword().equals(password)) {

			HttpSession hs = request.getSession();
			System.out.println(hs.isNew());
			hs.setMaxInactiveInterval(600);
			rd2.forward(request, response);
			
		}else {
			pw.println("Credentials error");
			rd1.include(request, response);
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
