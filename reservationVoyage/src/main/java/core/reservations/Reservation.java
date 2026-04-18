package core.reservations;

import core.voyage.vehicules.unites.UniteReservable;

import java.util.*;

public class Reservation {

	List<UniteReservable> unitesReservables;
	private UUID numero;
	private String dateCreation;
	private StatutReservation status;
	private double paiement;

	public void ajouterUnite(UniteReservable unite) {
		unitesReservables.add(unite);
	}

	public double calculerTotal() {
		double total = 0;
		for (UniteReservable unite : unitesReservables) {
			double prixBase = unite.getPrixBase();

		}
	}

}