package hashcode;

import java.util.LinkedList;
import java.util.List;

public class Voiture {
	private Coordonnees position;

	List<Trajet> trajets = new LinkedList<Trajet>();	
	
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
