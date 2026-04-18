package core.voyage.vehicules.unites;

public interface EtatUnite {


	boolean reserver(UniteReservable unite);

	boolean liberer(UniteReservable unite);

	boolean occuper(UniteReservable unite);

	String getLibelle();

}