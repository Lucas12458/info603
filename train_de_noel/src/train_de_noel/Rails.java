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
    
    

    public Rails obtenirRailSuivant(final String sens) {
    	Rails res;
        if(sens.equals("horaire")) {
        	res = this.suivant;
        	
        }
        else {
        	res = this.precedent;
        }
        return res;
    }
    
    

    public void alerteTrain(final int compteur) {
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
