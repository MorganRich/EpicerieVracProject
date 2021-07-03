package fr.epicerie_vrac_projet_core;

import org.hibernate.Session;

import fr.epicerie_vrac_projet_core.utils.HibernateUtil;

public class App {
	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

		}
	}
}
