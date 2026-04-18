package core.voyage.vehicules;

import core.voyage.visiteurs.Visiteur;

public class Train extends Vehicule {

	private int vitesseMax;

	public Train(String modele, int capaciteTotale, int vitesseMax) {
		super(modele, capaciteTotale);
		this.vitesseMax = vitesseMax;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}


	@Override
	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}