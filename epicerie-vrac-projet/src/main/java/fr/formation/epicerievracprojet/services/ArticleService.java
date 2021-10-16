package fr.formation.epicerievracprojet.services;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.epicerievracprojet.models.Article;
import fr.formation.epicerievracprojet.repositories.ArticleRepository;
import fr.formation.epicerievracprojet.repositories.CategorieRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository ar;
	
	@Autowired
	private CategorieRepository cr;
	
	@Autowired
	private FileService fs;
	
	public Collection<Article> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		if (sortOrder.equals("ascending"))
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		
		Page<Article> pagedResult = ar.findAll(paging);
		
		if(pagedResult.hasContent())
			return pagedResult.getContent();
		else
			return new ArrayList<Article>();
	}
	
	public Collection<Article> findAllByCategories(Integer pageNo, Integer pageSize, String sortBy, String sortOrder, Integer categorieId) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		if (sortOrder.equals("ascending"))
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		
		Page<Article> pagedResult = ar.findByCategories(cr.findById(categorieId).get(), paging);
		
		if(pagedResult.hasContent())
			return pagedResult.getContent();
		else
			return new ArrayList<Article>();
	}
	
	public Optional<Article> findById(int id) {
		return ar.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@Transactional
	public void save(Article a) throws IOException {
		ar.save(a);
		a.getCategories().forEach(c -> {
			c = cr.findById(c.getId()).get();
			c.getArticles().add(a);
			cr.save(c);
		});
		if (a.getImage() != null)
			Files.move(fs.getTmpPath(a.getImage()), fs.getPath(a.getImage()));
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
