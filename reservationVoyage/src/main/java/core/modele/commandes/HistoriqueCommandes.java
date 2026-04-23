package core.modele.commandes;

import java.util.*;

public class HistoriqueCommandes {

	List<Commande> historique;
	private int indexCourant;

	public HistoriqueCommandes() {
		historique = new ArrayList<>();
		indexCourant = 0;
	}

	public void ajouterCommande(Commande cmd) {
		historique.add(cmd);
		indexCourant++;
	}

	public void annuler() {
		historique.get(indexCourant--).annuler();
	}

	public void retablir()  {
		if (indexCourant < historique.size()) {
			historique.get(++indexCourant).executer();
		}
	}

	public void vider() {
		historique.clear();
		indexCourant = 0;
	}

}