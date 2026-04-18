package core.voyage.vehicules;

import core.voyage.ElementVoyage;

import java.util.*;

public abstract class Vehicule implements ElementVoyage {

	List<Section> sections;
	private String modele;
	private int capaciteTotale;

	public Vehicule(String modele, int capaciteTotale) {
		this.modele = modele;
		this.capaciteTotale = capaciteTotale;
		sections = new ArrayList<>();
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getCapaciteTotale() {
		return capaciteTotale;
	}

	public void setCapaciteTotale(int capaciteTotale) {
		this.capaciteTotale = capaciteTotale;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

}