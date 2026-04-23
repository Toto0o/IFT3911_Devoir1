package core.modele.commandes;

import core.reservations.unites.UniteReservable;

public class ModifierPrixCommande implements Commande {

	private UniteReservable unite;
	private double ancienPrix;
	private double nouveauPrix;

	public ModifierPrixCommande(UniteReservable unite, double nouveauPrix) {
		this.unite = unite;
		this.ancienPrix = unite.getPrixBase();
		this.nouveauPrix = nouveauPrix;
	}

	public void executer() {
		unite.setPrixBase(nouveauPrix);
	}

	public void annuler() {
		unite.setPrixBase(ancienPrix);
	}

	public String getDescription() {
		return "Modifier prix";
	}

}