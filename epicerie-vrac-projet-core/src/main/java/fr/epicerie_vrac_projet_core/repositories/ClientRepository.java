package fr.epicerie_vrac_projet_core.repositories;

import java.util.Optional;

import org.hibernate.Session;

import fr.epicerie_vrac_projet_core.models.Client;
import fr.epicerie_vrac_projet_core.utils.HibernateUtil;

public class ClientRepository extends GenericRepository<Client> {

	public ClientRepository() {
		super(Client.class);
	}
	
	public Optional<Client> findByEmailAndPassword(String email, String password) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			return findByEmailAndPassword(email, password, s);
		}
	}
	
	public Optional<Client> findByEmailAndPassword(String email, String password, Session s) {
		return Optional.ofNullable(s.createQuery("from Client c where c.email = :email and c.motDePasse = :password", Client.class)
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult());
	}

}
