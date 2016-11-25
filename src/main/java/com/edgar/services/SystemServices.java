package com.edgar.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.edgar.model.SystemVO;
import com.edgar.model.DoorVO;

public class SystemServices {

	private static SessionFactory factory;
	
	public SystemServices() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}		
	}
	
	public List<SystemVO> getAllSystems() {
		List<SystemVO> list = null;
		
		Session session = factory.openSession();
		Transaction tx = null;
	    
		try{
			tx = session.beginTransaction();
			list = session.createQuery("FROM SystemVO").list(); 
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
	
	public SystemVO saveSystem(SystemVO system) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("Class SystemServices - Method saveSystem - " + system.getIdSystem() + " - " + system.getName());
			session.save(system); 
			System.out.println("Class SystemServices - Method saveSystem - " + system.getIdSystem() + " - " + system.getName());
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
		
		return system;
	}	
	
	public boolean updateSystem(SystemVO system) {
		boolean flag = false;
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.update(system); 
			tx.commit();
			
			flag = true;
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		return flag;
	}	
	
	public SystemVO getSystem(int idUser) {
		SystemVO system = null;
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			system = (SystemVO) session.get(SystemVO.class, idUser);
			tx.commit();
			
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		return system;
	}	
	
	public boolean deleteSystem(int idUser) {
		boolean flag = false;
		SystemVO system = null;
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			system = (SystemVO) session.get(SystemVO.class, idUser);
			if (system != null) {
				session.delete(system);
				flag = true;
			}
			tx.commit();
			
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		return flag;
	}	

	
	public List<DoorVO> getDoorsBySystem(int idSystem) {
		List<DoorVO> list = null;
		
		Session session = factory.openSession();
		Transaction tx = null;
	    
		try{
			tx = session.beginTransaction();
			//session.save(u1);
			//session.save(u2);
			SystemVO system = (SystemVO) session.get(SystemVO.class, idSystem);
			if (system != null) {
				List<DoorVO> listDoors = session.createQuery("FROM DoorVO").list();
				if (listDoors != null) {
					list = new ArrayList<DoorVO>();
					for (int i=0;i<listDoors.size();i++) {
						DoorVO door = listDoors.get(i);
						if (door.getSystem().getIdSystem() == idSystem) {
							list.add(door);
						}
					}
				}
			}
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
	

	public boolean addDoor(int idSystem, DoorVO door) {
		boolean flag = false;
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			SystemVO system = (SystemVO) session.get(SystemVO.class, idSystem);
			if (system != null) {
				door.setSystem(system); 
				session.save(door);				
			}

			tx.commit();
			
			flag = true;
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		}
		finally {
	         session.close(); 
		}		
		
		return flag;
	}
			
	public DoorVO saveDoor(DoorVO door) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			System.out.println("Class SystemServices - Method saveDoor - " + door.getIdDoor() + " - " + door.getDescription());
			session.save(door); 
			System.out.println("Class SystemServices - Method saveDoor - " + door.getIdDoor() + " - " + door.getDescription());
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
		
		return door;
	}	
			
			
	
}
