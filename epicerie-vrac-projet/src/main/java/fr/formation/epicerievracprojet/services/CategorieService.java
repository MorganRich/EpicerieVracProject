package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.formation.epicerievracprojet.models.Categorie;
import fr.formation.epicerievracprojet.repositories.CategorieRepository;

@Service
public class CategorieService {

	@Autowired
	private CategorieRepository cr;
	
	public Collection<Categorie> findAll() {
		return cr.findAll();
	}
	
	public Optional<Categorie> findById(int id) {
		return cr.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void save(Categorie c) {
		cr.save(c);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void update(Categorie c) {
		cr.save(c);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(Categorie c) {
		cr.delete(c);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(int id) {
		cr.deleteById(id);
	}
	
}
