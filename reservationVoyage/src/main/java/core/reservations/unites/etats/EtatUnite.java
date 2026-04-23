package core.reservations.unites.etats;

import core.reservations.unites.UniteReservable;

public interface EtatUnite {


	boolean reserver(UniteReservable unite);

	boolean liberer(UniteReservable unite);

	boolean occuper(UniteReservable unite);

	String getLibelle();

}