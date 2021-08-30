package fr.epicerie_vrac_projet_core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epicerie_vrac_projet_core.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	public Optional<Client> findByEmailAndPassword(String email, String password);
//		return Optional.ofNullable(s.createQuery("from Client c where c.email = :email and c.motDePasse = :password", Client.class)
//				.setParameter("email", email)
//				.setParameter("password", password)
//				.getSingleResult());

}
