package train_de_noel;


public class Logiciel {
    private Train dispose;
    
    private Circuit circuit;
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println("Test");
    	
    	
    	
    	TypeRail type = TypeRail.droit;
		String sens = "antihoraire";
		Circuit circuit = new Circuit(type,sens);
    	Train train = new Train(sens,TypeVoiture.Locomotive);
    	
    	
    	

	}
    
    

}
