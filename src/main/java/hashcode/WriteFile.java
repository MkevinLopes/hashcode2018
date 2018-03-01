package hashcode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteFile {
	
	/**
	 * 
	 * @param voitures Liste des voitures avec leurs trajets
	 */
	static final void write(List<Voiture> voitures) {

    	try {
    	    BufferedWriter writer = new BufferedWriter(new FileWriter("resultat.txt"));
    	    for (Voiture voiture : voitures) {
    	    	writer.write(voiture.trajets.size());
    	    	for (Trajet trajet : voiture.trajets) {
    	    		writer.write(' ' + trajet.numero);
				}
			}
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
