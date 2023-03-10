package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectid;
	private String name;
	
	//union con teacher
	private int tcid;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
	  name = "subject_class", 
	  joinColumns = @JoinColumn(name = "subjectid"), 
	  inverseJoinColumns = @JoinColumn(name = "cid"))
	private Set<Class> classes;
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public Set<Class> getClasses() {
		return classes;
	}
	
	public void addClass(Class c) {
		this.classes.add(c);
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", name=" + name + ", tcid=" + tcid + ", classes=" + classes + "]";
	}
	
	


	
}
