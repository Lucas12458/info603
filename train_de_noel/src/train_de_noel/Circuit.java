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
	
	public void ajouterRail(TypeRail type) {
		Rails nouveauRail;
		if(type.equals(TypeRail.passageNiveau)) {
			nouveauRail = new PassageNiveau(type);
		}
		else if(type.equals(TypeRail.aiguillage)) {
			nouveauRail = new Aiguillage(type);
		}
		else {
			nouveauRail = new Rails(type);
		}
	    

	    if (this.premierRail == null) {
	        
	        this.premierRail = nouveauRail;
	        
	        nouveauRail.setSuivant(nouveauRail);
	        nouveauRail.setPrecedent(nouveauRail);
	    } else {
	       
	        Rails dernierRail = this.premierRail.getPrecedent();

	        
	        dernierRail.setSuivant(nouveauRail);
	        nouveauRail.setPrecedent(dernierRail);

	       
	        nouveauRail.setSuivant(this.premierRail);
	        this.premierRail.setPrecedent(nouveauRail);
	    }
	}

	@Override
	public String toString() {
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
                                                 