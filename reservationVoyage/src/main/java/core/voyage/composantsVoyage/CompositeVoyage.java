package core.voyage.composantsVoyage;

import java.util.ArrayList;

public class CompositeVoyage extends ComposantVoyage {

	private final ArrayList<ComposantVoyage> enfant = new ArrayList<>();

	public CompositeVoyage(String nom, String description) {
		super(nom, description);
	}

	@Override
	public void ajouter(ComposantVoyage composant) {
		enfant.add(composant);
	}

	@Override
	public void supprimer(ComposantVoyage composant) {
		enfant.remove(composant);
	}

	@Override
	public String afficher() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom + "\n");
		for (ComposantVoyage composant : enfant) {
			sb.append(composant.afficher());
			sb.append("\n");
		}
		return sb.toString();
	}

	public double calculerPrixTotal() {
		double prix = 0;
		for (ComposantVoyage composant : enfant) {
			prix += composant.calculerPrixTotal();
		}
		return prix;
	}

}