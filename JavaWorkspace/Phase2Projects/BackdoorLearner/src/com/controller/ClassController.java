package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Class;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;
import com.service.ClassService;
import com.service.StudentService;
import com.service.TeacherService;

/**
 * Servlet implementation class ClassController
 */
@WebServlet("/ClassController")
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassController() {
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
		ClassService cs = new ClassService();
		TeacherService ts = new TeacherService();
		StudentService ss = new StudentService();
		String name = request.getParameter("name");
		try {
			Class c = cs.getClass(name);
			pw.println("<h2> "+ name + "</h2>");
			pw.println("Class id is " + c.getCid());
			pw.print("<br>");
			//pw.println("Teacher is: " + ts.getTeacher(c.getTcid()).getName());
			
			Set<Subject> subjects = c.getSubjects();
			pw.println("Subject and teacher: ");
			if(subjects.size()== 0) {
				pw.print("none");
			}else {
				Iterator<Subject> si = subjects.iterator();
				while(si.hasNext()) {
					Subject s = si.next();
					int tid = s.getTcid();
					Teacher t = ts.getTeacher(tid);
					pw.println("<div>");
					pw.println("subject name: "+ s.getName());
					pw.print("<br>");
					pw.println("Teacher for "+ s.getName()+": " + t.getName());
					pw.println("</div>");
				}
			}
			
			
			
			pw.print("<br>");
			List<Student> list = ss.findStudentFrom(cs.getClass(name).getCid());
			pw.println("Number of students are "+list.size());
			pw.print("<br>");
			pw.println(" Students:  ");
			if(list.size()== 0) {
				pw.print("none");
			}else {
				Iterator<Student> ii = list.iterator();
				while(ii.hasNext()) {
					Student p = ii.next();
					pw.println("<div>");
					pw.println("- "+ p.getName()+ " "+ p.getSurname());
					pw.println("</div>");
					pw.print("<br>");
				}
			}
			

				RequestDispatcher rd = request.getRequestDispatcher("classReport.jsp");
				rd.include(request, response);
			
		}catch(Exception e) {
			pw.print("No class found with name: " + name);
			RequestDispatcher rd = request.getRequestDispatcher("classReport.jsp");
			rd.include(request, response);
		}
		
		
		

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
		String name = request.getParameter("cname");

		

		Class c = new Class();
		ClassService cs = new ClassService();
		if(cs.getClass(name).equals(null)) {
			c.setName(name);
			String result = cs.saveClass(c);
			pw.println(result);
		}else {
			pw.print("Class name already exists");
		}

		//c.setTcid(tid);
		
	


		

		
		RequestDispatcher rd = request.getRequestDispatcher("NewInfo.jsp");
		rd.include(request, response);
	}

}
