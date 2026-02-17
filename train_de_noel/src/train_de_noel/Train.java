package train_de_noel;


public class Train {
    private String sensCirculation;
    private int taille;
    private Voiture voitureTete;
   
    private boolean etat = false;
    
    public Train(String sens,TypeVoiture type){
    	this.sensCirculation = sens;
    	this.voitureTete = new Voiture(type);
    	this.taille = 1;


    }
    

    public void choisirSens() {
    	if(this.sensCirculation.equals("horaire")) {
    		this.sensCirculation = "antihoraire";
    	}
    	else {
    		this.sensCirculation = "horaire";
    	}
    	
    	Voiture precedent = null;
        Voiture courant = this.voitureTete;
        Voiture suivant = null;
        
        while (courant != null) {
            suivant = courant.obtenirVoitureSuivante(); 
            courant.setVoitureSuivante(precedent); 
            
            precedent = courant;
            courant = suivant;
        }

       
        this.voitureTete = precedent;
    }
    	
    	
    public void ajouterVoiture(TypeVoiture type) {
    	
    	Voiture voiture = new Voiture(type);
    	this.obtenirVoitureQueue().setVoitureSuivante(voiture);
    	this.taille++;
    	
    	
    }
    
    public String obtenirSensCirculation() {
    	return this.sensCirculation;
    }
    	
    
    
    

    public boolean demarrer() {
    	this.etat = true;
    	
    	while(this.etat) {
    		this.voitureTete.deplacer(this.sensCirculation);
    		this.voitureTete.alerteTrain(this.sensCirculation);
    	}
        return true;
    }

    public Voiture obtenirVoitureTete() {
        return this.voitureTete;
    }

    public Voiture obtenirVoitureQueue() {
    	Voiture voitureCourante = this.voitureTete;
    	for(int i = 1; i < this.taille;i++) {
    		voitureCourante = voitureCourante.obtenirVoitureSuivante();
    		
    	}
        return voitureCourante;
    }

}
