package core.modele.commandes.segments;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.voyage.SegmentVoyage;

public class ModifierSegementCommande implements Commande {

    private SegmentVoyage ancienSegment;
    private SegmentVoyage nouveauSegment;
    private ModeleVoyage modele;

    public ModifierSegementCommande(ModeleVoyage modele, SegmentVoyage ancienSegment, SegmentVoyage nouveauSegment) {
        this.modele = modele;
        this.ancienSegment = ancienSegment;
        this.nouveauSegment = nouveauSegment;
    }

    public void executer() {
        modele.supprimerSegement(ancienSegment);
        modele.ajouterSegment(nouveauSegment);
        modele.notifier();
    }

    public void annuler() {
        modele.supprimerSegement(nouveauSegment);
        modele.ajouterSegment(ancienSegment);
        modele.notifier();
    }

    public String getDescription() {
        return "Modifier segement";
    }
}
