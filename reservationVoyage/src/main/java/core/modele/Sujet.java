package core.modele;

import core.vues.Observateur;

import java.util.*;

public abstract class Sujet {

	List<Observateur> observateurs;

	public Sujet() {
		observateurs = new ArrayList<>();
	}

	public void attacher(Observateur observateur) {
		observateurs.add(observateur);
	}

	public void detacher(Observateur observateur) {
		observateurs.remove(observateur);
	}

	public void notifier() {
		for (Observateur observateur : observateurs) {
			observateur.mettreAJour();
		}
	}

}