package fr.formation.epicerievracprojet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.epicerievracprojet.models.Article;
import fr.formation.epicerievracprojet.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository ar;
	
	public Collection<Article> findAll() {
		return ar.findAll();
	}
	
	public Optional<Article> findById(int id) {
		return ar.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void save(Article a) {
		ar.save(a);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void update(Article a) {
		ar.save(a);
	}
	
	@Transactional
	public void upConsultation(int id) {
		Article a = findById(id).get();
		a.setNombreDeConsultation(a.getNombreDeConsultation() + 1);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(Article a) {
		ar.delete(a);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(int id) {
		ar.deleteById(id);
	}
	
}
