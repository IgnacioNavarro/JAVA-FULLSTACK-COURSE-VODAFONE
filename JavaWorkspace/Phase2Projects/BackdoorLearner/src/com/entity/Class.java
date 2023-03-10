package com.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;

	@OneToMany
	@JoinColumn(name = "scid") // this annotation is use to link fk in student table
	private List<Student> listOfStd;

	@ManyToMany(mappedBy = "classes", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Subject> subjects;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getListOfStd() {
		return listOfStd;
	}

	public void setListOfStd(List<Student> listOfStd) {
		this.listOfStd = listOfStd;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject e) {
		subjects.add(e);
		e.getClasses().add(this);
		
	}
	@Override
	public String toString() {
		return "Class [cid=" + cid + ", name=" + name + ", listOfStd=" + listOfStd + ", subjects=" + subjects + "]";
	}

}
