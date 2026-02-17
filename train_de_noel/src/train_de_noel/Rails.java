package train_de_noel;


public class Rails {
    private TypeRail type;

    private Rails suivant;
    private Rails precedent;
    
    public Rails(TypeRail type) {
    	this.type = type;
    	this.suivant = null;
    	this.precedent = null;
    	
    	
    }
    
    

    public Rails getSuivant() {
		return suivant;
	}



	public void setSuivant(Rails suivant) {
		this.suivant = suivant;
	}



	public Rails getPrecedent() {
		return precedent;
	}



	public void setPrecedent(Rails precedent) {
		this.precedent = precedent;
	}



	public Rails obtenirRailSuivant(final String sens) {
    	Rails res;
        if("horaire".equals(sens)) {
        	res = this.suivant;
        	
        }
        else {
        	res = this.precedent;
        }
        return res;
    }
    
    

    public void alerteTrain(final int compteur,String sens) {
    	if(compteur != 0) {
    		obtenirRailSuivant(sens).alerteTrain(compteur-1, sens);
    	}
    	
    	
    	
    }

    public int finAlerte(final int compteur) {
        // TODO Auto-generated return
        return 0;
    }

    public TypeRail getType() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.type;
    }

}
