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
	    Rails nouveauRail = new Rails(type);

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
	

}
                                                 