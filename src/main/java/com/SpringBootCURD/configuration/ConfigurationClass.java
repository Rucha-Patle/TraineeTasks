package com.SpringBootCURD.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.SpringBootCURD.entity.Bus;

public class ConfigurationClass {

	public static SessionFactory createConfiguration() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Bus.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}
}
