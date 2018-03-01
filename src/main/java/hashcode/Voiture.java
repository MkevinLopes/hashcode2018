package hashcode;

import java.util.List;

public class Voiture {
	private Coordonnees position;

	List<Trajet> trajets;	
	
	public Trajet ride;
	
	public boolean isRiding;
	public Coordonnees getPosition() {
		return position;
	}

	public void setPosition(Coordonnees position) {
		this.position = position;
	}
}
