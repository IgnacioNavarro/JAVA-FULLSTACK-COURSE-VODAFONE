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

import com.service.ClassService;
import com.service.SubjectService;

/**
 * Servlet implementation class JoinSubject
 */
@WebServlet("/JoinSubject")
public class JoinSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinSubject() {
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
		String cname = request.getParameter("classname");
		String sname = (request.getParameter("subjectname"));
		
	

		SubjectService ss = new SubjectService();
		ClassService cs = new ClassService();
		if(cname.equals("") || sname.equals("")) {
			pw.print("class or subject name does not exist");
		}else if(ss.getSubject(sname).equals(null) || cs.getClass(cname).equals(null)) {
			pw.print("class or subject name does not exist");
		}else {
			
			ss.setClass(sname, cname);
			pw.println("Class and subject joined");
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("NewInfo.jsp");
		rd.include(request, response);
	}

}
