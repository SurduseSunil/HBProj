package com.nt.test;


import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.nt.domain.Employee;

public class EntityNativeSqlQuery {

	
	

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg = cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses = factory.openSession();
		
		SQLQuery q1 = ses.createSQLQuery("select * from employee where eid>=? and eid<=:p1 ");
		
		
		q1.setInteger(0,100);
		q1.setInteger("p1", 101);
		
		q1.addEntity(Employee.class);
		
		List l = q1.list();
		
		
		for(int i=0;i<l.size();i++)
		{
			
			Employee eb = (Employee)l.get(i);
			
			System.out.println(eb.getEid());
			System.out.println(eb.getFirstName());
			System.out.println(eb.getLastName());
			System.out.println(eb.getEmail());
		}
		
	}
}
