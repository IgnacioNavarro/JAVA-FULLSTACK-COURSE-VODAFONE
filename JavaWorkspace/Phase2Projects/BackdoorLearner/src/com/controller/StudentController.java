package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Student;
import com.service.ClassService;
import com.service.StudentService;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession hs = request.getSession();
		if(hs.isNew()) {
			response.sendRedirect("login.jsp");
		}
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		StudentService ps = new StudentService();
		
		List<Student> list = ps.findAllStudent();
		pw.println("Number of students are "+list.size());
		pw.print("<br>");
		pw.println(" Students:  ");
		
		Iterator<Student> ii = list.iterator();
		while(ii.hasNext()) {
			Student p = ii.next();
			pw.println("<div>");
			pw.println("PID is " + p.getSid() + " name is " + p.getName());
			pw.println("</div>");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Student.jsp");
		rd.include(request, response);
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
		String name = request.getParameter("sname");
		String surname = request.getParameter("surname");
		String id = request.getParameter("cid");
		ClassService cs = new ClassService();
		
		
		if(name == "" || surname == "" || id == "") {
			pw.println("please fill all the values");
		}else {
			int cid = Integer.parseInt(id);
			
			Student s = new Student();
			s.setName(name);
			s.setSurname(surname);
			s.setScid(cid);

			
			StudentService ss = new StudentService();

			String result = ss.saveStudent(s);
			
			pw.println(result);
		}


		
		RequestDispatcher rd = request.getRequestDispatcher("NewInfo.jsp");
		rd.include(request, response);
	}

}
