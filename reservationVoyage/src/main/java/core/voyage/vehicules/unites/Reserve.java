package core.voyage.vehicules.unites;

public class Reserve implements EtatUnite {

	private String libelle = "Réservé";

	public Reserve() {}

	public boolean reserver(UniteReservable unite) {
		return false;
	}

	public boolean liberer(UniteReservable unite) {
		unite.setEtatActuel(new Disponible());
		return true;
	}

	public boolean occuper(UniteReservable unite) {
		unite.setEtatActuel(new Occupe());
		return true;
	}

	public String getLibelle() {
		return libelle;
	}

}