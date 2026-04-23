package core.voyage.composantsVoyage;

import java.util.Collections;
import java.util.List;

public abstract class ComposantVoyage {

	protected String nom;
	protected String description;

	public ComposantVoyage(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public void ajouter(ComposantVoyage composant) {
		throw new UnsupportedOperationException("Ajout impossible sur une feuille de voyage");
	}

	public void supprimer(ComposantVoyage composant) {
		throw new UnsupportedOperationException("Supression impossible sur une feuille de voyage");
	}


	public List<ComposantVoyage> obtenirEnfant() {
		return Collections.emptyList();
	}

	public abstract String afficher();

	public abstract double calculerPrixTotal();

}