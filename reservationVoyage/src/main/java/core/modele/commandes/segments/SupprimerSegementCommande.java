package core.modele.commandes.segments;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.voyage.SegmentVoyage;

public class SupprimerSegementCommande implements Commande {

	private ModeleVoyage modele;
	private SegmentVoyage segement;

	public SupprimerSegementCommande(ModeleVoyage modele, SegmentVoyage segement) {
		this.modele = modele;
		this.segement = segement;
	}

	public void executer() {
		modele.supprimerSegement(segement);
		modele.notifier();
	}

	public void annuler() {
		modele.ajouterSegment(segement);
		modele.notifier();
	}

	public String getDescription() {
		return "Supprimer un segement";
	}

}