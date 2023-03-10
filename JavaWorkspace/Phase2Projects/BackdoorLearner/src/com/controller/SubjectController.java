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

import com.entity.Class;
import com.entity.Subject;
import com.service.ClassService;
import com.service.SubjectService;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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
		
		HttpSession hs = request.getSession();
		if(hs.isNew()) {
			response.sendRedirect("login.jsp");
		}
		
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("subname");
		String id = request.getParameter("ssid");

		

		Subject s = new Subject();
		if(name == "" || id == "") {
			pw.print("please enter all the vallues");
			
		}else {
			int tid = Integer.parseInt(id);
			s.setName(name);
			s.setTcid(tid);
			
		

			SubjectService ss = new SubjectService();
			String result = ss.saveSubject(s);
			
			pw.println(result);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("NewInfo.jsp");
		rd.include(request, response);
	}

}
