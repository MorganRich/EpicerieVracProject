package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.epicerievracprojet.models.Commande;
import fr.formation.epicerievracprojet.repositories.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository cr;
	
	public Collection<Commande> findAll() {
		return cr.findAll();
	}
	
	public Optional<Commande> findById(int id) {
		return cr.findById(id);
	}
	
	public void save(Commande c) {
		cr.save(c);
	}
	
	public void update(Commande c) {
		cr.save(c);
	}
	
	public void delete(Commande c) {
		cr.delete(c);
	}
	
	public void deleteById(int id) {
		cr.deleteById(id);
	}
	
}
