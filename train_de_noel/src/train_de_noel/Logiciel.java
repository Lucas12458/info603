package train_de_noel;


public class Logiciel {
    private Train train;
    
    private Circuit circuit;
    
    public static void main(String[] args) {
		new Logiciel();
    }
    
    public Logiciel() {
    	String sens = "antihoraire";
		
    	this.train = new Train(sens,TypeVoiture.Locomotive);
    	
    	train.ajouterVoiture(TypeVoiture.Wagon);
    	train.ajouterVoiture(TypeVoiture.VoitureVoyageur);
    	
    	this.circuit = new Circuit(sens);
    	
    	circuit.ajouterRail(TypeRail.virage_gauche);
    	circuit.ajouterRail(TypeRail.droit);
    	circuit.ajouterRail(TypeRail.virage_gauche);
    	circuit.ajouterRail(TypeRail.passageNiveau);
    	circuit.ajouterRail(TypeRail.droit);
    	circuit.ajouterRail(TypeRail.aiguillage);
    	circuit.ajouterRail(TypeRail.droit);
    	circuit.ajouterRail(TypeRail.virage_gauche);
    	circuit.ajouterRail(TypeRail.aiguillage);
    	
    	System.out.println(this.train.toString());
    	
    	//train.choisirSens();
    	
    	//System.out.println(this.train.toString());
    	
    	
    	System.out.println(this.circuit.toString());
    	
    	
    	train.poserSurCircuit(circuit.getPremierRail());
    	
    	train.demarrer();
    	
    	
    }
    
    
    
    

}
