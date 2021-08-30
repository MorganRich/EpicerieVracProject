package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.formation.epicerievracprojet.models.Client;
import fr.formation.epicerievracprojet.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cr;
	
	@PreAuthorize("hasRole('ADMIN')")
	public Collection<Client> findAll() {
		return cr.findAll();
	}
	
	public Optional<Client> findById(int id) {
		return cr.findById(id);
	}
	
	public Optional<Client> findByEmail(String email) {
		return cr.findByEmail(email);
	}
	
	public void save(Client c) {
		cr.save(c);
	}
	
	public void update(Client c) {
		cr.save(c);
	}
	
	public void delete(Client c) {
		cr.delete(c);
	}
	
	public void deleteById(int id) {
		cr.deleteById(id);
	}
	
}
