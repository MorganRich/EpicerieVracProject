package fr.formation.epicerievracprojet.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.epicerievracprojet.models.Article;
import fr.formation.epicerievracprojet.services.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService as;
	
	@GetMapping("")
	public Collection<Article> findAll() {
		System.out.println("controler");
		return as.findAll();
	}
	
	@GetMapping("/{id}")
	public Article findById(@PathVariable int id) {
		return as.findById(id).get();
	}
	
	@PostMapping("")
	public void save(@RequestBody Article a) {
		System.out.println("pass");
		as.save(a);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Article a) {
		as.update(a);
	}
	
	@PutMapping("/{id}/upConsultation")
	public void upConsultation(@PathVariable int id) {
		as.upConsultation(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		as.deleteById(id);
	}
	
}
