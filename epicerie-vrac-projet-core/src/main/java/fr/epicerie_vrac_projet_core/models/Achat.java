package fr.epicerie_vrac_projet_core.models;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Achat {
	@EqualsAndHashCode.Include
	private int id;
	private Set<LigneAchat> articles = new LinkedHashSet<>();
	
}
