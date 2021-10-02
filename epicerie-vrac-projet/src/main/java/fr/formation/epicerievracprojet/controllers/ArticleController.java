package fr.formation.epicerievracprojet.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.formation.epicerievracprojet.models.Article;
import fr.formation.epicerievracprojet.models.Categorie;
import fr.formation.epicerievracprojet.repositories.CategorieRepository;
import fr.formation.epicerievracprojet.services.ArticleService;
import fr.formation.epicerievracprojet.services.FileService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService as;
	
	@Autowired
	private CategorieRepository cr;
	
	@Autowired
	private FileService fs;
	
	@GetMapping("")
	public Collection<Article> findAllArticle(@RequestParam(defaultValue = "0") Integer pageNo,
											  @RequestParam(defaultValue = "10") Integer pageSize,
											  @RequestParam(defaultValue = "id") String sortBy,
											  @RequestParam(defaultValue = "descending") String sortOrder) {
		return as.findAll(pageNo, pageSize, sortBy, sortOrder);
	}
	
	@GetMapping("/categories")
	public Collection<Categorie> findAllCategorie() {
		return cr.findAll();
	}
	
	@GetMapping("/{id}")
	public Article findById(@PathVariable int id) {
		return as.findById(id).get();
	}
	
	@PostMapping("")
	public void save(@RequestPart("article") Article a, @RequestPart("file") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			try (InputStream is = file.getInputStream()) {
				String fileExtension = file.getOriginalFilename()
										   .substring(file.getOriginalFilename().lastIndexOf("."));
				Path fileName = fs.generateUniqueFileName("image-produit", fileExtension);
				Files.copy(is, fs.getTmpPath(fileName));
				a.setImage(fileName.toString());
			}
		}
		as.save(a);
	}
	
	@PostMapping("/categories")
	public void save(@RequestBody Categorie c) {
		cr.save(c);
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
