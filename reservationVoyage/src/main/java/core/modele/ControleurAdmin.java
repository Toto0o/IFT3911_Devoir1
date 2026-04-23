package core.modele;

import core.modele.commandes.Commande;
import core.modele.commandes.HistoriqueCommandes;

public class ControleurAdmin {

	private HistoriqueCommandes historique;
	private ModeleVoyage modele;

	public ControleurAdmin(ModeleVoyage modele) {
		this.modele = modele;
		historique = new HistoriqueCommandes();
	}

	public HistoriqueCommandes getHistorique() {
		return this.historique;
	}

	public void executerCommande(Commande cmd) {
		cmd.executer();
		historique.ajouterCommande(cmd);
	}

	public void annulerDerniere() {
		historique.annuler();
	}

	public void retablirDerniere() {
		historique.retablir();
	}

}