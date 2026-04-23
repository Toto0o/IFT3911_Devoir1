package core.prix;

public class PrixPromotion implements StrategiePrix {

	private double pourcentageReduction;

	public PrixPromotion(double pourcentageReduction) {
		this.pourcentageReduction = pourcentageReduction;
	}

	public double calculerPrix(double prixBase) {
		return prixBase * pourcentageReduction;
	}

}