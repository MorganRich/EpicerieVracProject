package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import fr.formation.epicerievracprojet.models.Fournisseur;
import fr.formation.epicerievracprojet.repositories.FournisseurRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fr;
	
	public Collection<Fournisseur> findAll() {
		return fr.findAll();
	}
	
	public Optional<Fournisseur> findById(int id) {
		return fr.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void save(Fournisseur f) {
		fr.save(f);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void update(Fournisseur f) {
		fr.save(f);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(Fournisseur f) {
		fr.delete(f);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(int id) {
		fr.deleteById(id);
	}
	
}
