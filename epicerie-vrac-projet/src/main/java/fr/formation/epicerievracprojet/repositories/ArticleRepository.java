package fr.formation.epicerievracprojet.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.epicerievracprojet.models.Article;
import fr.formation.epicerievracprojet.models.Categorie;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	List<Article> findAllByPrixUnitaire(double prixUnitaire, Pageable pageable);
	Page<Article> findByCategories(Categorie categorie, Pageable pageable);
}
