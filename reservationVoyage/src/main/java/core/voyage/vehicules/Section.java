package core.voyage.vehicules;

import core.voyage.ElementVoyage;
import core.reservations.unites.UniteReservable;
import core.voyage.visiteurs.Visiteur;

import java.util.*;

public class Section implements ElementVoyage {

	List<UniteReservable> unitesReservables;
	private String typeSection;
	// AJOUTER PRIX COMME ATTRIBUT ???

	public Section(String typeSection) {
		this.typeSection = typeSection;
		unitesReservables = new ArrayList<>();
	}

	public void addUnite(UniteReservable unite) {
		unitesReservables.add(unite);
	}

	public void removeUnite(UniteReservable unite) {
		unitesReservables.remove(unite);
	}

	public List<UniteReservable> getUnitesReservables() {
		return unitesReservables;
	}

	public int getNumberOfUnites() {
		return unitesReservables.size();
	}

	public int numberOfAvilableUnites() {
		int disp = 0;
		for (UniteReservable unite : unitesReservables) {
			if (unite.isAvailable()) {
				disp++;
			}
		}
		return disp;
	}

	public String getTypeSection() {
		return typeSection;
	}

	public void setTypeSection(String typeSection) {
		this.typeSection = typeSection;
	}

	public double getPrix() {
		return unitesReservables.getFirst().getPrixBase();
	}


	@Override
	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}