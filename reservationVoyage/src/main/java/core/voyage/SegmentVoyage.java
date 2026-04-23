package core.voyage;

import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Vehicule;
import core.voyage.visiteurs.Visiteur;

public class SegmentVoyage implements ElementVoyage {

	private String numero;
	private Terminal origine;
	private Terminal destination;
	private Vehicule vehicule;
	private String Compagnie;
	private String heureDepart; // HH:mm
	private String heureArrivee;
	private String dateDepart;
	private String dateArrivee;

	public SegmentVoyage(String numero, String compagnie, Terminal origine, Terminal destination, Vehicule vehicule,
						 String heureDepart, String heureArrivee, String dateDepart, String dateArrivee) {
		this.numero = numero;
		this.origine = origine;
		this.destination = destination;
		this.vehicule = vehicule;
		this.Compagnie = compagnie;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
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

	public String getCompagnie() {
		return Compagnie;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public String getHeureArrivee() {
		return heureArrivee;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public String getDateArrivee() {
		return dateArrivee;
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

	public void setCompagnie(String compagnie) {
		Compagnie = compagnie;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}