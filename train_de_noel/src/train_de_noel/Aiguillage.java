package train_de_noel;


public class Aiguillage extends Rails {
	private Rails brancheA;
    private Rails brancheB;
    
	private String position;

   
    
    public Aiguillage(TypeRail type,String position) {
		super(type);
		
		this.position = position;
		
	}
    
    public void setBrancheA(Rails r) { 
    	this.brancheA = r; 
    
    }
    
    public void setBrancheB(Rails r) { 
    	this.brancheB = r; 
    }

	

    public void changerPosition() {
    	if(this.position.equals("2")) {
    		this.position = "1";
    		System.out.println("Aiguillage basculé sur position : " + this.position);
    	}
    	else {
    		this.position = "2";
    		System.out.println("Aiguillage basculé sur position : " + this.position);
    	}
    }

    @Override
    public Rails obtenirRailSuivant(String sens) {
        if ("horaire".equals(sens)) {
            
            return this.position.equals("1") ? brancheA : brancheB;
        } else {
            
            return this.getPrecedent();
        }
    }

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Rails getBrancheA() {
		return brancheA;
	}

	public Rails getBrancheB() {
		return brancheB;
	}

}
