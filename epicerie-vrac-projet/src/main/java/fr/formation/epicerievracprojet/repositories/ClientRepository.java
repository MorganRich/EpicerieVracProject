package fr.formation.epicerievracprojet.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	public Optional<Client> findByEmail(String email);

}
