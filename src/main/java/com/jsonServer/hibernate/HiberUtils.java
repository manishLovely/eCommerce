package com.jsonServer.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtils {
	
	public  static SessionFactory getSessionFactory() {
		
		SessionFactory factory = new Configuration().configure("hibercfg.xml").buildSessionFactory();
		
		return factory;
		
	}

}
