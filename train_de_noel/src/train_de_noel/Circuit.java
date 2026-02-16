package train_de_noel;


public class Circuit {
	private Rails premierRail;
	private String sens;
	
	
	public Circuit(TypeRail type,String sens) {
		this.premierRail = new Rails(type);
		this.sens = sens;
		
	}
	
	public Rails getPremierRail() {
		return this.premierRail;
	}
	
	public void ajouterRail() {
		
	}
	
	

}
                                                 