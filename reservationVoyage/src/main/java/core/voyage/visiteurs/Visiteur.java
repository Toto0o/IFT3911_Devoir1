package core.voyage.visiteurs;
import core.voyage.terminaux.Terminal;
import core.reservations.unites.UniteReservable;
import core.voyage.SegmentVoyage;
import core.voyage.vehicules.*;


public interface Visiteur {


	public void visiter(SegmentVoyage voyage);

	public void visiter(Vehicule vehicule);

	public void visiter(UniteReservable unite);

	public void visiter(Section section);

	public void visiter(Terminal terminal);

	public String obtenirAffichage();
}