package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Admin;
import com.resource.DbResource;

public class AdminDao {
	
	private Admin setAdmin() {
		Admin a = new Admin();
		a.setUser("admin");
		a.setPassword("admin");
		
		return a;
	}
	
	public Admin getAdmin(){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		
		
		Admin a = setAdmin();
		
		Query query = session.createQuery("from Admin"); 

		List<Admin> list = query.list(); 


		if(list.size() == 0) {
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(a);
			tran.commit();
			query = session.createQuery("from Admin"); 

			list = query.list(); 

			Admin ad = (Admin) list.get(0);
			
			return ad;
			
		}else {
			Admin ad = (Admin) list.get(0);
			return ad;
		}
	}

}
