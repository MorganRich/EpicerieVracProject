package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.epicerievracprojet.models.Client;
import fr.formation.epicerievracprojet.repositories.AdresseRepository;
import fr.formation.epicerievracprojet.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private AdresseRepository ar;
	
	@PreAuthorize("hasRole('ADMIN')")
	public Collection<Client> findAll() {
		return cr.findAll();
	}
	
	public Optional<Client> findById(int id) {
		System.out.println("service");
		return cr.findById(id);
	}
	
	public Optional<Client> findByEmail(String email) {
		return cr.findByEmail(email);
	}
	
	@Transactional
	public void save(Client c) {
		cr.save(c);
		c.getAdresses().forEach(a -> {
			a.setPersonne(c);
			ar.save(a);
		});
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
