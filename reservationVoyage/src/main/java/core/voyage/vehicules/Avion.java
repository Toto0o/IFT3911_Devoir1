package core.voyage.vehicules;

import core.voyage.visiteurs.Visiteur;

public class Avion extends Vehicule {

	private double emvergure;

	public Avion(String model, int capaciteTotale, double emvergure) {
		super(model, capaciteTotale);
		this.emvergure = emvergure;
	}

	public double getEmvergure() {
		return emvergure;
	}

	public void setEmvergure(double emvergure) {
		this.emvergure = emvergure;
	}

	@Override
	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}