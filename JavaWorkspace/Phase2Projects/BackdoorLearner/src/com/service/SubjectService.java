package com.service;

import java.util.List;

import com.dao.SubjectDao;
import com.entity.Class;
import com.entity.Subject;

public class SubjectService {
	
	SubjectDao pd = new SubjectDao();
	
	public String saveSubject(Subject s) {
		if(pd.saveSubject(s) > 0) {
			return "Subject saved";
		}else {
			return "Error saving subject";
		}
	}
	
	public List<Subject> findAllClasses(){
		return pd.findAllSubject();
	}
	
	public void setClass(String sname, String cname) {
		pd.setClass(sname, cname);
	}
	
	public Subject getSubject(String name) {
		return pd.getSubject(name);
	}


}
