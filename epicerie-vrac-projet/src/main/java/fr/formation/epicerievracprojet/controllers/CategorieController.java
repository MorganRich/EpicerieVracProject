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

import fr.formation.epicerievracprojet.models.Categorie;
import fr.formation.epicerievracprojet.services.CategorieService;

@RestController
@RequestMapping("/categories")
public class CategorieController {
	
	@Autowired
	private CategorieService cs;
	
	@GetMapping("")
	public Collection<Categorie> findAll() {
		return cs.findAll();
	}
	
	@GetMapping("/{id}")
	public Categorie findById(@PathVariable int id) {
		return cs.findById(id).get();
	}
	
	@PostMapping("")
	public void save(@RequestBody Categorie c) {
		cs.save(c);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Categorie c) {
		cs.update(c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		cs.deleteById(id);
	}
	
}
