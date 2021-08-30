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

import fr.formation.epicerievracprojet.models.Fournisseur;
import fr.formation.epicerievracprojet.services.FournisseurService;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

	@Autowired
	private FournisseurService fs;
	
	@GetMapping("")
	public Collection<Fournisseur> findAll() {
		return fs.findAll();
	}
	
	@GetMapping("/{id}")
	public Fournisseur findById(@PathVariable int id) {
		return fs.findById(id).get();
	}
	
	@PostMapping("")
	public void save(@RequestBody Fournisseur f) {
		fs.save(f);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Fournisseur f) {
		fs.update(f);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		fs.deleteById(id);
	}
	
}
