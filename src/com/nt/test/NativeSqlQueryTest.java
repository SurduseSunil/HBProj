package com.nt.test;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.nt.domain.Employee;

import java.util.*;

public class NativeSqlQueryTest {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg = cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses = factory.openSession();
		
		Query q1 = ses.createQuery("select eb from Employee as eb where eb.eid>101 and (eb.email like '%gmail.com')");
		
		List l1 =q1.list();
		
		for(int i=0;i<l1.size();i++)
		{
			
		Employee eb = (Employee) l1.get(i);
		
		System.out.println(eb.getEid());
		System.out.println(eb.getFirstName());
		System.out.println(eb.getLastName());
		System.out.println(eb.getEmail());
		
		
		
		
		
			
		}
		

	}

}
