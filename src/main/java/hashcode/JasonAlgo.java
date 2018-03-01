package hashcode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JasonAlgo {

	public static void main(String[] args) {
		try {
			Grille grille = Main.lireFichier("e_high_bonus.in");
			run(grille);
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier");
			System.err.print(e);
		}
	}
	
	public static void run(Grille grille) {
		List<Voiture> voitures = new LinkedList<Voiture>();
		int riding = 0;
		int step = 0;
		
		for(int i = 0; i < grille.getNombreVoitures(); i++) {
			Voiture voiture = new Voiture(i);
			voiture.setPosition(new Coordonnees(0, 0));
			voitures.add(voiture);
		}
		
		while(!grille.getListeRides().isEmpty() || riding > 0) {
			for(Voiture voiture: voitures) {
				// Si la voiture est en course
				if(voiture.ride != null) {
					// Si la voiture est dans une course
					if(voiture.isRiding) {
						// La voiture doit avancer
						if (mustMove(voiture, voiture.ride.getCoordArrivee())) {
							runToCoordonnees(voiture, voiture.ride.getCoordArrivee());
						} else {
							System.out.println("La voiture " + voiture.id + " a déposé " + voiture.ride.id);
							voiture.isRiding = false;
							voiture.ride = null;
							if(!nextRide(step, voiture, grille)) {
								riding--;
							}
						}
					} else {
						if (mustWait(step, voiture.ride)) {
							// rien
						} else if (mustMove(voiture, voiture.ride.getCoordDepart())) {
							runToCoordonnees(voiture, voiture.ride.getCoordDepart());
						} else {
							voiture.isRiding = true;
						}
					}
				} else {
					if(nextRide(step, voiture, grille)) {
						riding++;
					}
				}
			}
			step++;
		}
		
		WriteFile.write(voitures);
	}
	
	private static boolean nextRide(int step, Voiture voiture, Grille grille) {
		if(!grille.getListeRides().isEmpty()) {
			Trajet nextRide = getMostRide(step, voiture.getPosition(), grille.getListeRides());
			voiture.ride = nextRide;
			voiture.trajets.add(nextRide);
			grille.getListeRides().remove(nextRide);
			System.out.println("La voiture " + voiture.id + " a pris " + nextRide.id);
			return true;
		} // else
		return false;
	}
	
	private static Trajet getMostRide(int step, Coordonnees coo, List<Trajet> trajets) {
		Trajet aRetourner = null;
		int i = 0;
		while(aRetourner == null && i < trajets.size()) {
			Trajet current = trajets.get(i);
			i++;
			
			int distance = Math.abs(coo.getX() - current.getCoordDepart().getY()) 
					+ Math.abs(coo.getY() - current.getCoordDepart().getY());
			
			if(distance <= current.getHeureDepart() - step) {
				aRetourner = current;
			}
		}
		
		if(aRetourner == null) {
			aRetourner = trajets.get(0);
		}
		//System.out.println(aRetourner + " " + trajets.size());
		
		return aRetourner;
	}
	
	private static boolean mustWait(int step, Trajet ride) {
		return step < ride.getHeureDepart(); 
	}
	
	private static boolean mustMove(Voiture voiture, Coordonnees arrivees) {
		return arrivees.getX() != voiture.getPosition().getX() 
				|| arrivees.getY() != voiture.getPosition().getY(); 
	}
	
	private static void runToCoordonnees(Voiture voiture, Coordonnees arrivees) {
		if(arrivees.getX() != voiture.getPosition().getX()) {
			voiture.getPosition().setX(addOneStep(voiture.getPosition().getX(), arrivees.getX()));
		} else if (arrivees.getY() != voiture.getPosition().getY()) {
			voiture.getPosition().setY(addOneStep(voiture.getPosition().getY(), arrivees.getY()));
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
