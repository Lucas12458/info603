package train_de_noel;


public class Voiture {
    private TypeVoiture type;

    private Voiture voitureSuivante;

    private Rails rail;
    
    public Voiture(TypeVoiture type) {
    	this.type = type;
    	
    	
    
    }
    
    public Rails getRail() {
		return rail;
	}

    public void setRail(Rails rail) {
		this.rail = rail;
	}


    public void deplacer(String sens) {
    	
    	changeRail(this.rail.obtenirRailSuivant(sens));
    	
    	if(this.voitureSuivante != null) {
    		this.voitureSuivante.deplacer(sens);
    	}
    	
    }

    public void changeRail(final Rails railSuivant) {
    	this.rail = railSuivant;
    }

    public boolean estSur(final Rails rail) {
        return this.rail.equals(rail);
        
    }

    public boolean alerteTrain(String sens) {
        this.rail.alerteTrain(2, sens);
        
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
