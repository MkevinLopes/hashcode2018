package hashcode;

import java.io.IOException;

public class JasonAlgo {

	public static void main(String[] args) {
		try {
			Grille grille = Main.lireFichier("toto");
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier");
			System.err.print(e);
		}
	}
}
