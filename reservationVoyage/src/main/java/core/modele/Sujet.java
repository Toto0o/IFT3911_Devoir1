package core.modele;

import core.vues.Observateur;

import java.util.*;

public abstract class Sujet {

	List<Observateur> observateurs;

	/**
	 * 
	 * @param observateur
	 */
	public void attacher(Obervateur observateur) {
		// TODO - implement core.modele.Sujet.attacher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param observateur
	 */
	public void detacher(Observateur observateur) {
		// TODO - implement core.modele.Sujet.detacher
		throw new UnsupportedOperationException();
	}

	public void notifier() {
		// TODO - implement core.modele.Sujet.notifier
		throw new UnsupportedOperationException();
	}

}