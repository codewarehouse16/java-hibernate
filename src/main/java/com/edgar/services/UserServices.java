package com.edgar.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.edgar.model.ProfileVO;
import com.edgar.model.UserVO;

public class UserServices {

	private static SessionFactory factory;
	
	public UserServices() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}		
	}
	
	public List<UserVO> getAllUsers() {
		List<UserVO> list = null;
		
		Session session = factory.openSession();
		Transaction tx = null;
	    
		try{
			tx = session.beginTransaction();
			list = session.createQuery("FROM UserVO").list(); 
			tx.commit();
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		
		return list;
	}
	
	public UserVO saveUser(UserVO user) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("Class UserServices - Method saveUser - " + user.getIdUser() + " - " + user.getNombres());
			session.save(user); 
			System.out.println("Class UserServices - Method saveUser - " + user.getIdUser() + " - " + user.getNombres());
			/*if (system.getDoors() != null && system.getDoors().size() > 0) {
				for (int i=0;i<system.getDoors().size();i++) {
					system.getDoors().get(i).setSystem(system);
					if (system.getDoors().get(i) != null) {
						session.save(system.getDoors().get(i));
					}
				}
			}*/
			tx.commit();
		
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		
		return user;
	}
	
	public ProfileVO saveProfile(ProfileVO profile) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("Class UserServices - Method saveProfile - " + profile.getIdProfile() + " - " + profile.getName());
			session.save(profile); 
			System.out.println("Class UserServices - Method saveProfile - " + profile.getIdProfile() + " - " + profile.getName());
			/*if (system.getDoors() != null && system.getDoors().size() > 0) {
				for (int i=0;i<system.getDoors().size();i++) {
					system.getDoors().get(i).setSystem(system);
					if (system.getDoors().get(i) != null) {
						session.save(system.getDoors().get(i));
					}
				}
			}*/
			tx.commit();
		
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		
		return profile;
	}	
	
	
	
}
