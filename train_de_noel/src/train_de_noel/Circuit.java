package train_de_noel;


public class Circuit {
	private Rails premierRail;
	private String sens;
	
	
	public Circuit(String sens) {
		this.sens = sens;
		
	}
	
	public Rails getPremierRail() {
		return this.premierRail;
	}
	
	public Rails ajouterRail(TypeRail type) {
	    Rails nouveauRail;
	    
	    
	    if (type.equals(TypeRail.passageNiveau)) {
	        nouveauRail = new PassageNiveau(type);
	    } 
	    
	    else if (type.equals(TypeRail.aiguillage)) {
	        nouveauRail = new Aiguillage(type, "1");
	    } 
	    
	    else {
	        nouveauRail = new Rails(type);
	    }

	    if (this.premierRail == null) {
	        
	    	this.premierRail = nouveauRail;
	        
	    	nouveauRail.setSuivant(nouveauRail);
	        nouveauRail.setPrecedent(nouveauRail);
	        
	       
	        if (nouveauRail instanceof Aiguillage) {
	            ((Aiguillage) nouveauRail).setBrancheA(nouveauRail);
	        }
	    } 
	    else {
	        Rails dernierRail = this.premierRail.getPrecedent();

	       
	        dernierRail.setSuivant(nouveauRail);
	        nouveauRail.setPrecedent(dernierRail);
	        
	        
	        if (dernierRail instanceof Aiguillage) {
	        	
	            ((Aiguillage) dernierRail).setBrancheA(nouveauRail);
	        }

	        
	        nouveauRail.setSuivant(this.premierRail);
	        this.premierRail.setPrecedent(nouveauRail);

	        
	        if (nouveauRail instanceof Aiguillage) {
	            ((Aiguillage) nouveauRail).setBrancheA(this.premierRail);
	        }
	    }
	    return nouveauRail;
	}
	
	public Rails ajouterRailBranche(Aiguillage source, Aiguillage dest, TypeRail type) {
	    Rails nouveauRail;

	    
	    if (type.equals(TypeRail.passageNiveau)) {
	        nouveauRail = new PassageNiveau(type);
	    } else if (type.equals(TypeRail.aiguillage)) {
	        nouveauRail = new Aiguillage(type, "1");
	    } else {
	        nouveauRail = new Rails(type);
	    }

	    
	    if (source.getBrancheB() == null) {
	        source.setBrancheB(nouveauRail);
	        nouveauRail.setPrecedent(source);
	        
	       
	        nouveauRail.setSuivant(dest);
	    } 
	    else {
	       
	        Rails courant = source.getBrancheB();
	        while (courant.getSuivant() != dest) {
	            courant = courant.getSuivant();
	        }

	       
	        courant.setSuivant(nouveauRail);
	        nouveauRail.setPrecedent(courant);
	        
	      
	        nouveauRail.setSuivant(dest);
	    }

	    return nouveauRail;
	}
	
	
	
	@Override
	public String toString() {
		if (this.premierRail == null) return "Circuit vide";
	    StringBuilder sb = new StringBuilder();
	    sb.append("Circuit [sens=").append(sens).append(", rails=[");

	    if (this.premierRail != null) {
	        Rails courant = this.premierRail;
	        
	      
	        do {
	            sb.append(courant.getType());
	            courant = courant.getSuivant(); 
	            
	            if (courant != this.premierRail) {
	                sb.append(" <-> ");
	            }
	        } while (courant != this.premierRail);
	    } else {
	        sb.append("aucun rail");
	    }

	    sb.append("]]");
	    return sb.toString();
	}
	

}
                                                 