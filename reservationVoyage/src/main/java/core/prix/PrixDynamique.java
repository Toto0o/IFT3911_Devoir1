package core.prix;

import java.util.HashMap;

public class PrixDynamique implements StrategiePrix {

	private double facteurDemande;
	private double facteurSaison;

	public PrixDynamique(double facteurDemande, double facteurSaison) {
		this.facteurDemande = facteurDemande;
		this.facteurSaison = facteurSaison;
	}

	public double calculerPrix(double prixBase) {
		// dummy function
		return ((facteurSaison +facteurDemande) / 2) * prixBase;
	}

}