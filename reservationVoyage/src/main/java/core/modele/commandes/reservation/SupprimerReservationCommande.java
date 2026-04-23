package core.modele.commandes.reservation;

import core.modele.ModeleVoyage;
import core.modele.commandes.Commande;
import core.reservations.Reservation;


public class SupprimerReservationCommande implements Commande {


    private ModeleVoyage modele;
    private Reservation reservation;

    public SupprimerReservationCommande(ModeleVoyage modele, Reservation reservation) {
        this.modele = modele;
        this.reservation = reservation;
    }

    @Override
    public void executer() {
        this.modele.supprimerReservation(this.reservation);
        modele.notifier();
    }

    @Override
    public void annuler() {
        this.modele.ajouterReservation(reservation);
        modele.notifier();
    }

    public String getDescription() {
        return "Supprimer une reservation";
    }
}
