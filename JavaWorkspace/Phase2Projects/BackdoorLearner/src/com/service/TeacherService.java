package com.service;

import java.util.List;

import com.dao.TeacherDao;
import com.entity.Teacher;


public class TeacherService {
	
	TeacherDao pd = new TeacherDao();
	
	
	public String saveTeacher(Teacher t) {
		
		if(pd.saveTeacher(t) > 0) {
			return "Teacher stored with id " +t.getTid();
			
		}else {
			return "Error storing the teacher";
		}
		
	}
	
	
	public List<Teacher> findAllTeacher(){
		return pd.findAllTeacher();
	}
	
	public Teacher getTeacher(int id) {
		return pd.getTeacher(id);
	}
	
	public String updateTeacher(Teacher t) {
		
		if(pd.updateTeacher(t) > 0) {
			return "Teacher updated";
			
		}else {
			return "Error storing the teacher";
		}
		
	}

}
