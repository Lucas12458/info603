package train_de_noel;


public class PassageNiveau extends Rails {
    public PassageNiveau(TypeRail type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public void alerteTrain(final int compteur,String sens) {
    	fermerPAN();
    }

	private void fermerPAN() {
    	
    }

    private void ouvrirPAN() {
    }

}
