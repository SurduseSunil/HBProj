package com.nt.test;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.nt.domain.Employee;

public class ScalarNativeQuery {

	public static void main(String[] args) {
		
		
		
		
		Configuration cfg = new Configuration();
		cfg = cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses = factory.openSession();
		
		String sql = "select max(eid) as mval from employee ";
		
		SQLQuery q1 = ses.createSQLQuery(sql);
		
		
		
		//q1.addScalar("mval", );
		
		List l = q1.list();
		
		
		System.out.println("Max eid is "+l.toString());
		
	
		
	}

}
