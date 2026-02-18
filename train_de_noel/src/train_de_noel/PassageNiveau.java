package train_de_noel;


public class PassageNiveau extends Rails {
	private boolean estFerme;
	
    public PassageNiveau(TypeRail type) {
		super(type);
		
	}
    
    @Override
    public boolean alerteTrain(final int compteur, String sens) {
        this.fermerPAN();
        return true; 
    }

    
    public void fermerPAN() {
        if (!this.estFerme) { 
            this.estFerme = true;
            System.out.println("Fermeture du passage à niveau");
        }
    }

    
    public void ouvrirPAN() {
        if (this.estFerme) {
            this.estFerme = false;
            System.out.println("Ouverture du passage à niveau");
        }
    }
    
    
    
    
    @Override
    public boolean finAlerte(final int compteur, String sens) {
       
        this.ouvrirPAN();
        return true; 
    }

}
