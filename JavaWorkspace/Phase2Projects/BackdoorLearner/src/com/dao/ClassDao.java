package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Class;
import com.resource.DbResource;

import javassist.NotFoundException;

public class ClassDao {

	
	public int saveClass(Class c) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.getTransaction();
		
		tran.begin();
		session.save(c);
		tran.commit();
		
		return 1;
	}
	
	
	public List<Class> findAllClasses(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		TypedQuery tq = session.createQuery("from Class");
		List<Class> listOfClasses = tq.getResultList();
		return listOfClasses;
	}
	
	
	public Class getClass(String name) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		TypedQuery tq =session.createQuery("FROM Class c WHERE  c.name = :name").setParameter("name", name);
		return (Class) tq.getSingleResult();

	}
}
