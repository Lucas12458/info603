package train_de_noel;


public class Voiture {
    private TypeVoiture type;

    private Voiture voitureSuivante;

    private Rails estSur;
    
    public Voiture(TypeVoiture type) {
    	this.type = type;
    	
    	
    
    }
    
    

    public void deplacer(final Voiture voiture) {
    }

    public void changeRail(final Rails railSuivant) {
    }

    public boolean estSur(final Rails rail) {
        // TODO Auto-generated return
        return false;
    }

    public boolean alerteTrain() {
        // TODO Auto-generated return
        return false;
    }

    public void finAlerte() {
    }
    
    
    public Voiture obtenirVoitureSuivante() {
    	return this.voitureSuivante;
    	
    }
    
    public void setVoitureSuivante(Voiture voiture) {
    	this.voitureSuivante = voiture;
    }

}
