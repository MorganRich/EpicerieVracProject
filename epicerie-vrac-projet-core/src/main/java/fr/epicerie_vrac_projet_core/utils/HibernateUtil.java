package fr.epicerie_vrac_projet_core.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

private static SessionFactory sf;
	
	static {
		sf = new Configuration().configure()
								.addProperties(PropertiesUtil.getProperties())
								.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
}
