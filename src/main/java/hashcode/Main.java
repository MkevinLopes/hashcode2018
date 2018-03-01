package hashcode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException
	{
		Grille grille = lireFichier("‪toto");
		
		System.out.println("coucou");
	}

	public static Grille lireFichier(String filePath) throws IOException
	{
		Grille grille = new Grille();
		
		//Lecture du fichier
		File file = new File(filePath);
//		file.createNewFile();
		System.out.println(file.getAbsolutePath());
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		//Configuration de la grille (ligne 1)
		String line = br.readLine();
		String[] ligne1 = line.split(" ");
		grille.setTailleX(Integer.parseInt(ligne1[0]));
		grille.setTailleY(Integer.parseInt(ligne1[1]));
		grille.setNombreVoitures(Integer.parseInt(ligne1[2]));
		grille.setNombreRides(Integer.parseInt(ligne1[3]));
		grille.setNombreBonus(Integer.parseInt(ligne1[4]));
		grille.setNombreSteps(Integer.parseInt(ligne1[5]));
		
		//Trajets
		while ((line = br.readLine()) != null) {
			//Ajout des trajets
			Trajet trajet = new Trajet();
			
			String[] ligne = line.split(" ");
			trajet.setCoordDepart(new Coordonnees(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			trajet.setCoordArrivee(new Coordonnees(Integer.parseInt(ligne[2]), Integer.parseInt(ligne[3])));
			trajet.setHeureDepart(Integer.parseInt(ligne[4]));
			trajet.setHeureArrivee(Integer.parseInt(ligne[5]));
			
			grille.getListeRides().add(trajet);
		}
		br.close();
		return grille;
	}
}
