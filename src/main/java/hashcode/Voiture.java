package hashcode;

public class Voiture {
	private Coordonnees position;
	
	public Trajet ride;
	
	public boolean isRiding;
	
	public int id;

	public Voiture(int id) {
		this.id = id;
	}
	
	public Coordonnees getPosition() {
		return position;
	}

	public void setPosition(Coordonnees position) {
		this.position = position;
	}
}
