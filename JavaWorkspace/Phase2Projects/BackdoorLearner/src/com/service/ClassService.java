package com.service;

import java.util.List;

import com.dao.ClassDao;
import com.entity.Class;
import com.entity.Teacher;

public class ClassService {
	
	ClassDao pd = new ClassDao();
	
	public String saveClass(Class c) {
		if(pd.saveClass(c) > 0) {
			return "Class saved with id " + c.getCid();
		}else {
			return "Error saving class";
		}
	}
	
	public List<Class> findAllClasses(){
		return pd.findAllClasses();
	}
	
	public Class getClass(String name) {
		return pd.getClass(name);
	}

}
