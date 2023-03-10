package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Teacher;
import com.resource.DbResource;

public class TeacherDao {
	
	
	public int saveTeacher(Teacher teacher) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.getTransaction();
		
		tran.begin();
		session.save(teacher);
		tran.commit();
		
		return 1;
	}
	
	
	public List<Teacher> findAllTeacher(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from Teacher");
		List<Teacher> listOfTeachers = tq.getResultList();
		return listOfTeachers;
	}
	
	
	
	public Teacher getTeacher(int id) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from Teacher where tid="+id);
		return (Teacher) tq.getSingleResult();
	}
	
	
	public int updateTeacher(Teacher teacher) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.getTransaction();
		
		tran.begin();
		session.update(teacher);
		tran.commit();
		
		return 1;
	}
	
	//assign teacher to class for a subject

}
