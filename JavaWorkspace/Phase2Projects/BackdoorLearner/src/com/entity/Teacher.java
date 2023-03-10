package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String name;
	@OneToMany
	@JoinColumn(name = "tcid")		// this annotation is use to link fk in student table 
	private List<Class> subjectInClass;
	//quiza es un mapa?
	
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public List<Class> getSubjectInClass() {
		return subjectInClass;
	}
	public void setSubjectInClass(List<Class> subjectInClass) {
		this.subjectInClass = subjectInClass;
	}
	public void addClass(Class c) {
		this.subjectInClass.add(c);
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", subjectInClass=" + subjectInClass + "]";
	}

	
	
	

}
