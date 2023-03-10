package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentService {
	
	StudentDao pd = new StudentDao();
	
	public String saveStudent(Student s) {
		if(pd.saveStudent(s) > 0) {
			return "Student saved with id" + s.getSid();
		}else {
			return "Error saving student";
		}
	}
	
	public List<Student> findAllStudent(){
		return pd.findAllStudent();
	}
	
	public List<Student> findStudentFrom(int scid){
		return pd.findStudentFrom(scid);
	}

}
