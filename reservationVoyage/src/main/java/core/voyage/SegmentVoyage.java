package core.voyage;

import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Vehicule;
import core.voyage.visiteurs.Visiteur;

public class SegmentVoyage implements ElementVoyage {

	private String numero;
	private Terminal origine;
	private Terminal destination;
	private Vehicule vehicule;

	public SegmentVoyage(String numero, Terminal origine, Terminal destination, Vehicule vehicule) {
		this.numero = numero;
		this.origine = origine;
		this.destination = destination;
		this.vehicule = vehicule;
	}

	public String getNumero() {
		return numero;
	}

	public Terminal getOrigine() {
		return origine;
	}

	public Terminal getDestination() {
		return destination;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setOrigine(Terminal origine) {
		this.origine = origine;
	}

	public void setDestination(Terminal destination) {
		this.destination = destination;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}