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
    
    

	public boolean alerteTrain(final int compteur, String sens) {
		if(this.obtenirRailSuivant(sens) != null) {
			if (compteur > 0) {
				return this.obtenirRailSuivant(sens).alerteTrain(compteur - 1, sens);
			}
		}
		return false;
	}
    	
    	
    	
    

	public boolean finAlerte(final int compteur, String sens) {
	    if (compteur >= 0) {
	        
	        return this.obtenirRailSuivant(sens).finAlerte(compteur - 1, sens);
	    }
	    return false; 
	}

    public TypeRail getType() {
       
        return this.type;
    }

}
