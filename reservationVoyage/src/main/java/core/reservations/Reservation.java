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
		unitesReservables = new ArrayList<>();
	}

	public UUID getNumero() {
		return numero;
	}

	public void setNumero(UUID numero) {
		this.numero = numero;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public StatutReservation getStatus() {
		return status;
	}

	public void setStatus(StatutReservation status) {
		this.status = status;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
	this.paiement = paiement;
	}

	public void ajouterUnite(UniteReservable unite) {
		unitesReservables.add(unite);
	}

	public List<UniteReservable> getUnitesReservables() {
		return unitesReservables;
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