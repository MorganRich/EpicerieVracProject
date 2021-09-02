package fr.formation.epicerievracprojet.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
public class LigneAchat {
	
	@NoArgsConstructor
	@Getter
	@Setter
	@ToString()
	@Embeddable
	public static class LigneAchatId implements Serializable {

		@ManyToOne
		private Article article;

		@ManyToOne
		private Achat achat;
	}
	
	@ToString.Exclude
	@EmbeddedId
	private LigneAchatId id;
	
	private int quantite;
	
}