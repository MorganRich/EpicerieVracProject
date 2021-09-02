package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.epicerievracprojet.models.Client;
import fr.formation.epicerievracprojet.repositories.AdresseRepository;
import fr.formation.epicerievracprojet.repositories.ClientRepository;
import fr.formation.epicerievracprojet.repositories.PersonneRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private AdresseRepository ar;
	
	@Autowired
	private PersonneRepository pr;
	
	@Autowired
	private PasswordEncoder pe;
	
	@PreAuthorize("hasRole('ADMIN')")
	public Collection<Client> findAll() {
		return cr.findAll();
	}
	
	public Optional<Client> findById(int id) {
		System.out.println("service");
		return cr.findById(id);
	}
	
	@Transactional
	public void save(Client c) {
		c.setPassword(pe.encode(c.getPassword()));
		pr.save(c.getPersonne());
		cr.save(c);
		c.getPersonne().getAdresses().forEach(a -> {
			a.setPersonne(c.getPersonne());
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
