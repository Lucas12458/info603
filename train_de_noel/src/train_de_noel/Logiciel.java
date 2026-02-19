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
    	
    	Thread threadTrain = new Thread(this.train);
    	
    	train.ajouterVoiture(TypeVoiture.Wagon);
    	train.ajouterVoiture(TypeVoiture.VoitureVoyageur);
    	
    	this.circuit = new Circuit(sens);
    	
    	Aiguillage aiguillage2 = (Aiguillage) circuit.ajouterRail(TypeRail.aiguillage);
    	
    	circuit.ajouterRail(TypeRail.virage_gauche);
    	circuit.ajouterRail(TypeRail.droit);
    	circuit.ajouterRail(TypeRail.virage_gauche);
    	circuit.ajouterRail(TypeRail.passageNiveau);
    	circuit.ajouterRail(TypeRail.droit);
    	
    	Aiguillage aiguillage1 = (Aiguillage) circuit.ajouterRail(TypeRail.aiguillage);
    	
    	circuit.ajouterRail(TypeRail.droit);
    	circuit.ajouterRail(TypeRail.virage_gauche);
    	
    	
    	
    	//
    	circuit.ajouterRailBranche(aiguillage1, aiguillage2, TypeRail.droit);
    	
    	
    	
    	System.out.println(this.train.toString());
    	aiguillage1.changerPosition();
    	
    	//train.choisirSens();
    	
    	//System.out.println(this.train.toString());
    	
    	
    	System.out.println(this.circuit.toString());
    	
    	
    	train.poserSurCircuit(circuit.getPremierRail());
    	
    	threadTrain.start();
    	
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	this.train.arreter();
    	
    	

    	
    	
    	
    	    	
    	
    }
    
    
    
    
    
    

}
