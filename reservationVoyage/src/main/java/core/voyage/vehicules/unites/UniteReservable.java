package core.voyage.vehicules.unites;

import core.voyage.ElementVoyage;
import core.voyage.visiteurs.Visiteur;

public class UniteReservable implements ElementVoyage {

	private String numero;
	private int position;
	private double prixBase;
	private EtatUnite etatActuel;

	public UniteReservable(String numero, int position, double prixBase) {
		etatActuel = new Disponible();
		this.numero = numero;
		this.position = position;
		this.prixBase = prixBase;
	}

	public void setEtatActuel(EtatUnite etatActuel) {
		this.etatActuel = etatActuel;
	}

	public EtatUnite getEtatActuel() {
		return etatActuel;
	}

	public boolean reserver() {
		return etatActuel.reserver(this);
	}

	public boolean liberer() {
		return etatActuel.liberer(this);
	}

	public boolean occuper() {
		return etatActuel.occuper(this);
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getPrixBase() {
		return prixBase;
	}

	public void setPrixBase(double prixBase) {
		this.prixBase = prixBase;
	}

	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}