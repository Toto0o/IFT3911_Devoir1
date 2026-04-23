package core.voyage.visiteurs;

import core.reservations.unites.UniteReservable;
import core.voyage.SegmentVoyage;
import core.voyage.terminaux.Terminal;
import core.voyage.vehicules.Section;
import core.voyage.vehicules.Vehicule;

public class VisiteurAdmin implements Visiteur {

    private StringBuilder builder;

    public VisiteurAdmin() {
        this.builder = new StringBuilder();
    }

    @Override
    public void visiter(SegmentVoyage voyage) {

        visiter(voyage.getOrigine());
        builder.append("-");
        visiter(voyage.getDestination());
        builder.append(":[");
        builder.append(voyage.getCompagnie());
        builder.append("]");
        builder.append(voyage.getNumero());
        builder.append("(");
        builder.append(voyage.getDateDepart());
        builder.append(":");
        builder.append(voyage.getHeureDepart());
        builder.append("-");
        builder.append(voyage.getDateArrivee());
        builder.append(":");
        builder.append(voyage.getHeureArrivee());
        builder.append(")");
        builder.append("|");
        for (Section section : voyage.getVehicule().getSections()) {
            visiter(section);
            builder.append("|");
        }
    }

    @Override
    public void visiter(Terminal terminal) {
        builder.append(terminal.getCode());
    }


    @Override
    public void visiter(Vehicule vehicule) {
        // nothing to do
    }

    @Override
    public void visiter(Section section) {
        builder.append(section.getTypeSection());
        builder.append("(");
        builder.append(section.numberOfAvilableUnites());
        builder.append("/");
        builder.append(section.getNumberOfUnites());
        builder.append(")");
        builder.append(section.getPrix());
    }

    @Override
    public void visiter(UniteReservable reservable) {
        // nothing to do
    }


    @Override
    public String obtenirAffichage() {
        return builder.toString();
    }
}