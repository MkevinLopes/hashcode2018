package hashcode;

public class Trajet {
	private Coordonnees coordDepart;
	private Coordonnees coordArrivee;
	private int heureDepart;
	private int heureArrivee;

	public Coordonnees getCoordDepart() {
		return coordDepart;
	}

	public void setCoordDepart(Coordonnees coordDepart) {
		this.coordDepart = coordDepart;
	}

	public Coordonnees getCoordArrivee() {
		return coordArrivee;
	}

	public void setCoordArrivee(Coordonnees coordArrivee) {
		this.coordArrivee = coordArrivee;
	}

	public int getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}

	public int getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(int heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
}
