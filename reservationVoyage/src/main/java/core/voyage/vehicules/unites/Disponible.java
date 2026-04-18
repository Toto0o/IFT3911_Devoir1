package core.voyage.vehicules.unites;

public class Disponible implements EtatUnite {

	private String libelle = "Disponible";

	public Disponible() {}

	@Override
	public boolean reserver(UniteReservable unite) {
		unite.setEtatActuel(new Reserve());
		return true;
	}

	@Override
	public boolean liberer(UniteReservable unite) {
		return false;
	}

	@Override
	public boolean occuper(UniteReservable unite) {
		return false;
	}

	public String getLibelle() {
		return libelle;
	}

}