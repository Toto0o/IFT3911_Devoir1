package core.voyage.vehicules;

import core.voyage.ElementVoyage;
import core.voyage.vehicules.unites.UniteReservable;
import core.voyage.visiteurs.Visiteur;

import java.util.*;

public class Section implements ElementVoyage {

	List<UniteReservable> unitesReservables;
	private String typeSection;

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

	public String getTypeSection() {
		return typeSection;
	}

	public void setTypeSection(String typeSection) {
		this.typeSection = typeSection;
	}


	@Override
	public void accepter(Visiteur visiteur) {
		visiteur.visiter(this);
	}

}