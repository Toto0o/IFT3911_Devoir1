package core.voyage.vehicules;

import core.voyage.visiteurs.Visiteur;

public class Paquebot extends Vehicule {

	private double tonnage;

	public Paquebot(String modele, int capaciteTotale, double tonnage) {
		super(modele, capaciteTotale);
		this.tonnage = tonnage;
	}

	public double getTonnage() {
		return tonnage;
	}

	public void setTonnage(double tonnage) {
		this.tonnage = tonnage;
	}

	@Override
	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}