package core.modele.commandes.segments;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.voyage.SegmentVoyage;

public class AjouterSegementCommande implements Commande {

	private ModeleVoyage modele;
	private SegmentVoyage segement;

	public AjouterSegementCommande(ModeleVoyage modele, SegmentVoyage segement) {
		this.modele = modele;
		this.segement = segement;
	}

	public void executer() {
		modele.ajouterSegment(segement);
		modele.notifier();
	}

	public void annuler() {
		modele.supprimerSegement(segement);
		modele.notifier();
	}

	public String getDescription() {
		return "Ajoute un segement au modèle";
	}

}