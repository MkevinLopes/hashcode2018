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
	static final void write(Map<Integer, List<Integer>> voitures) {

    	try {
    	    BufferedWriter writer = new BufferedWriter(new FileWriter("resultat.txt"));
		    for(Map.Entry<Integer, List<Integer>> voiture: voitures.entrySet()) {
		        writer.write(voiture.getKey());
		        for(Integer ride: voiture.getValue()) {
						writer.write(' ' + ride);
		        }
		    }
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
