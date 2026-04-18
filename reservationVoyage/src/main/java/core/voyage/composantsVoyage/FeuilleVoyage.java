package core.voyage.composantsVoyage;

public class FeuilleVoyage extends ComposantVoyage {

	private final double prix;
	private final int nbUnitesDisponible;
	private final String affichage;

	public FeuilleVoyage(String non, String description, double prix, int nbUnitesDisponible, String affichage) {
		super(non, description);
		this.prix = prix;
		this.nbUnitesDisponible = nbUnitesDisponible;
		this.affichage = affichage;
	}

	@Override
	public String afficher() {
		return affichage;
	}

	@Override
	public double calculerPrixTotal() {
		return prix;
	}

	public int getNbUnitesDisponible() {
		return nbUnitesDisponible;
	}

}