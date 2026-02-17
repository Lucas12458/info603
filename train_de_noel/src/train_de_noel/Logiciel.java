package train_de_noel;


public class Logiciel {
    private Train train;
    
    private Circuit circuit;
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println("Test");
    	
    	
    	new Logiciel();
    }
    
    public Logiciel() {
    	String sens = "antihoraire";
		
    	this.train = new Train(sens,TypeVoiture.Locomotive);
    	
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
    	
    	//train.demarrer();
    	
    	
    }
    
    
    
    

}
