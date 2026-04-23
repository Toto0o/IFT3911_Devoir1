package core.reservations;

import core.prix.Paiement;
import core.reservations.unites.UniteReservable;

import java.util.*;

public class Reservation {

	List<UniteReservable> unitesReservables;
	private UUID numero;
	private String dateCreation;
	private StatutReservation status;
	private Paiement paiement;

	public Reservation(UUID numero, String dateCreation, StatutReservation status) {
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.status = status;
	}

	public void ajouterUnite(UniteReservable unite) {
		unitesReservables.add(unite);
	}

	public double calculerTotal() {
		double total = 0;
		for (UniteReservable unite : unitesReservables) {
			double prixBase = unite.getPrixBase();

		}
		return total;
	}

	public void addPaiement(Paiement paiement) {
		this.paiement = paiement;
		status = StatutReservation.CONFIRMEE;
		for (UniteReservable unite : unitesReservables) {
			unite.occuper();
		}
	}

}