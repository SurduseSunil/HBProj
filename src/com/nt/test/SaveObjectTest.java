package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		Configuration  cfg =null;
		SessionFactory factory = null;
		Session ses =null;
		Employee emp =null;
		Transaction tx =null;
		//Activate HB frame work //bootstrap 
		cfg = new Configuration();
		
		//read both mapping,cfg files
		cfg= cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		
		//build session factory object 
		factory = cfg.buildSessionFactory();
		
		//open session with DB s/w
		ses = factory.openSession();
		
		//create doamin object 
		
		emp =new Employee();
		
		emp.setEid(101);
		emp.setFirstName("raja");
		emp.setLastName("rani");
		emp.setEmail("raja@gmail.com");
		
		
		try {
			tx = ses.beginTransaction();
			ses.save(emp);
			tx.commit();
			
			System.out.println("Inserted");
			
			
			
		}catch(Exception e) {
			
			tx.rollback();
			
		}
		
		finally {
			
			//close the object
			
			ses.close();
			factory.close();
			
			
		}
		
		
		
		
		
		

	}

}
