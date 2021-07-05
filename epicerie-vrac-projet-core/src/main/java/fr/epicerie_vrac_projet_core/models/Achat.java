package fr.epicerie_vrac_projet_core.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString()
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Achat {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private int id;
	
	private double prixTotal;
	
	@OneToMany(mappedBy = "id.achat")
	@ToString.Exclude
	private Set<LigneAchat> articles = new LinkedHashSet<>();
	
	public void calculerPrixTotalTTC() {
		
	}
}
