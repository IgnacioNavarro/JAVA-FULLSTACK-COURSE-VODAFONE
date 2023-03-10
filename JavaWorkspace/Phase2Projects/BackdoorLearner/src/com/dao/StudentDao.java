package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;
import com.entity.Teacher;
import com.resource.DbResource;

public class StudentDao {
	
	public int saveStudent(Student s) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.getTransaction();
		
		tran.begin();
		session.save(s);
		tran.commit();
		
		return 1;
	}
	
	
	public List<Student> findAllStudent(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from Student");
		List<Student> listOfStudent = tq.getResultList();
		return listOfStudent;
	}
	
	public List<Student> findStudentFrom(int scid){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from Student where scid= :scid").setParameter("scid", scid);
		List<Student> listOfStudent = tq.getResultList();
		return listOfStudent;
	}
	


}
