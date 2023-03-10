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

import com.entity.Teacher;
import com.service.TeacherService;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
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
		// TODO Auto-generated method stub
		
		HttpSession hs = request.getSession();
		if(hs.isNew()) {
			response.sendRedirect("login.jsp");
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("tname");

		

		Teacher t = new Teacher();
		
		t.setName(name);

		TeacherService ts = new TeacherService();
		

		String result = ts.saveTeacher(t);
		
		pw.println(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("NewInfo.jsp");
		rd.include(request, response);
	}

}
