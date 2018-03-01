package hashcode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JasonAlgo {

	public static void main(String[] args) {
		try {
			Grille grille = Main.lireFichier("toto");
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier");
			System.err.print(e);
		}
	}
	
	public static void run(Grille grille) {
		List<Voiture> voitures = new LinkedList<Voiture>();
		
		for(int i = 0; i < grille.getNombreVoitures(); i++) {
			voitures.add(new Voiture(i));
		}
		
		for(Voiture voiture: voitures) {
			// Si la voiture est en course
			if(voiture.ride != null) {
				if(voiture.isRiding) {
					if (mustMove(voiture, voiture.ride.getCoordArrivee())) {
						runToCoordonnees(voiture, voiture.ride.getCoordArrivee());
					} else {
						voiture.isRiding = false;
						voiture.ride = null;
					}
				} else {
					if (mustMove(voiture, voiture.ride.getCoordDepart())) {
						runToCoordonnees(voiture, voiture.ride.getCoordDepart());
					} else {
						voiture.isRiding = true;
					}
				}
			} else {
				
			}
		}
	}
	
	private static boolean mustMove(Voiture voiture, Coordonnees arrivees) {
		return voiture.ride.getCoordArrivee().getX() != voiture.getPosition().getX() 
				|| voiture.ride.getCoordArrivee().getY() != voiture.getPosition().getY(); 
	}
	
	private static void runToCoordonnees(Voiture voiture, Coordonnees arrivees) {
		if(voiture.ride.getCoordArrivee().getX() != voiture.getPosition().getX()) {
			voiture.getPosition().setX(addOneStep(voiture.getPosition().getX(), voiture.ride.getCoordArrivee().getX()));
		} else if (voiture.ride.getCoordArrivee().getY() != voiture.getPosition().getY()) {
			voiture.getPosition().setY(addOneStep(voiture.getPosition().getY(), voiture.ride.getCoordArrivee().getY()));
		}
	}
	
	private static int addOneStep(int depart, int arrivee) {
		if(arrivee > depart) {
			depart++;
		} else {
			depart--;
		}
		return depart;
	}
}
