package core.reservations.unites.etats;

import core.reservations.unites.UniteReservable;

public class Occupe implements EtatUnite {

	private String libelle = "Occupé";

	public Occupe() {}

	public boolean reserver(UniteReservable unite) {
		return false;
	}

	public boolean liberer(UniteReservable unite) {
		unite.setEtatActuel(new Disponible());
		return true;
	}

	public boolean occuper(UniteReservable unite) {
		return false;
	}

	public String getLibelle() {
		return libelle;
	}

}