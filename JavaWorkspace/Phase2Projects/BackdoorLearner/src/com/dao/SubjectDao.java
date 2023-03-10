package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.resource.DbResource;
import com.service.ClassService;
import com.entity.Class;
public class SubjectDao {
	
	public int saveSubject(Subject subject) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.getTransaction();
		
		tran.begin();
		session.save(subject);
		tran.commit();
		
		return 1;
	}
	
	
	public List<Subject> findAllSubject(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from subject");
		List<Subject> listOfStudent = tq.getResultList();
		return listOfStudent;
	}
	
	public int setClass(String sname, String cname ) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		ClassService cs = new ClassService();
		Subject s = getSubject(sname);
		Class c = cs.getClass(cname);
		//s.addClass(c);
		c.addSubject(s);
		Transaction tran = session.getTransaction();
		
		tran.begin();
		session.merge(s);
		session.merge(c);

		tran.commit();
		
		return 1;
		
	}
	
	public Subject getSubject(String name) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		try {
			TypedQuery tq =session.createQuery("FROM Subject c WHERE  c.name = :name").setParameter("name", name);

			return (Subject) tq.getSingleResult();
		}catch(Exception e) {
			return null;
		}

	}

}
