package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.epicerievracprojet.models.Adresse;
import fr.formation.epicerievracprojet.repositories.AdresseRepository;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository ar;
	
	public Collection<Adresse> findAll() {
		return ar.findAll();
	}
	
	public Optional<Adresse> findById(int id) {
		return ar.findById(id);
	}
	
	public void save(Adresse a) {
		ar.save(a);
	}
	
	public void update(Adresse a) {
		ar.save(a);
	}
	
	public void delete(Adresse a) {
		ar.delete(a);
	}
	
	public void deleteById(int id) {
		ar.deleteById(id);
	}
	
}
