package hashcode;

import java.io.IOException;

public class JasonAlgo {

	public static void main(String[] args) {
		try {
			Grille grille = Main.lireFichier("toto");
			
			for(Voiture voiture: grille.getNombreVoitures()) {
				// Si la voiture est en course
				if(voiture.ride != null) {
					if(voiture.isRiding) {
						//if(voiture.)
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier");
			System.err.print(e);
		}
	}
}
