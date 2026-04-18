package core.modele;

import core.commandes.HistoriqueCommandes;

public class ControleurAdmin {

	private HistoriqueCommandes historique;
	private ModeleVoyage modele;

	public HistoriqueCommandes getHistorique() {
		return this.historique;
	}

	public void setHistorique(HistoriqueCommandes historique) {
		this.historique = historique;
	}

	/**
	 * 
	 * @param cmd
	 */
	public void executerCommande(Commande cmd) {
		// TODO - implement core.modele.ControleurAdmin.executerCommande
		throw new UnsupportedOperationException();
	}

	public void annulerDerniere() {
		// TODO - implement core.modele.ControleurAdmin.annulerDerniere
		throw new UnsupportedOperationException();
	}

	public void retablirDerniere() {
		// TODO - implement core.modele.ControleurAdmin.retablirDerniere
		throw new UnsupportedOperationException();
	}

}