package fr.epicerie_vrac_projet_core.repositories;

import java.util.Collection;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.epicerie_vrac_projet_core.utils.HibernateUtil;

public class GenericRepository<T> {

	private Class<T> clazz;

	public GenericRepository(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public Collection<T> findAll(Session s) {
		return s.createQuery("from T", clazz).getResultList();
	}
	
	public Collection<T> findAll() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return findAll(s);
		}
	}
	
	public Optional<T> findById(int id, Session s) {
		return Optional.ofNullable(s.get(clazz, id));
	}
	
	public Optional<T> findById(int id) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return findById(id, s);
		}
	}
	
	public void save(T o, Session s, Transaction t) {
		s.save(o);
	}
	
	public void save(T o, Session s) {
		s.beginTransaction();
		save(o, s, s.getTransaction());
		s.getTransaction().commit();
	}
	
	public void save(T o) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			save(o, s);
		}
	}
	
	public void update(T o, Session s, Transaction t) {
		s.update(o);
	}
	
	public void update(T o, Session s) {
		s.beginTransaction();
		update(o, s, s.getTransaction());
		s.getTransaction().commit();
	}
	
	public void update(T o) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			update(o, s);
		}
	}
	
	public void delete(T o, Session s, Transaction t) {
		s.delete(o);
	} 
	
	public void delete(T o, Session s) {
		s.beginTransaction();
		delete(o, s, s.getTransaction());
		s.getTransaction().commit();
	}
	
	public void delete(T o) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			delete(o, s);
		}
	}
	
	public void deleteById(int id, Session s, Transaction t) {
		s.delete(findById(id, s).get());
	}
	
	public void deleteById(int id, Session s) {
		s.beginTransaction();
		deleteById(id, s, s.getTransaction());
		s.getTransaction().commit();
	}
	
	public void delete(int id) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			deleteById(id, s);
		}
	}
}
