package hashcode;
import java.util.ArrayList;
import java.util.List;

public class Grille {
	private int tailleX;
	private int tailleY;
	private int nombreVoitures;
	private int nombreRides;
	private int nombreBonus;
	private int nombreSteps;
	private List<Trajet> listeRides;

	public int getTailleX() {
		return tailleX;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

	public int getNombreVoitures() {
		return nombreVoitures;
	}

	public void setNombreVoitures(int nombreVoitures) {
		this.nombreVoitures = nombreVoitures;
	}

	public int getNombreRides() {
		return nombreRides;
	}

	public void setNombreRides(int nombreRides) {
		this.nombreRides = nombreRides;
	}

	public int getNombreBonus() {
		return nombreBonus;
	}

	public void setNombreBonus(int nombreBonus) {
		this.nombreBonus = nombreBonus;
	}

	public int getNombreSteps() {
		return nombreSteps;
	}

	public void setNombreSteps(int nombreSteps) {
		this.nombreSteps = nombreSteps;
	}

	public List<Trajet> getListeRides() {
		if(listeRides == null)
		{
			listeRides = new ArrayList();
		}
		return listeRides;
	}

	public void setListeRides(List<Trajet> listeRides) {
		this.listeRides = listeRides;
	}
}
