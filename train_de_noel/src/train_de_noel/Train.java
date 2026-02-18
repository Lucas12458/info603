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
    
    private boolean estSurUnPAN() {
        Voiture courante = this.voitureTete;
        while (courante != null) {
            
            if (courante.getRail() instanceof PassageNiveau) {
                return true; 
            }
            courante = courante.obtenirVoitureSuivante();
        }
        return false; 
    }
    	
    
    private boolean attenteLiberation = false;

    public boolean demarrer() {
        this.etat = true;
        
        while(this.etat) {
           
            this.voitureTete.deplacer(this.sensCirculation);
            
           
            boolean panDetecte = this.voitureTete.alerteTrain(this.sensCirculation);
            
            if (panDetecte) {
                this.attenteLiberation = true;
            }

           
            if (this.attenteLiberation && !this.estSurUnPAN()) {
                String sensInverse = this.sensCirculation.equals("horaire") ? "antihoraire" : "horaire";
                
               
                if (obtenirVoitureQueue().finAlerte(sensInverse)) {
                    
                    this.attenteLiberation = false;
                }
            }
            System.out.println("La voiture de tête est sur " + this.voitureTete.getRail().getType());

            try { Thread.sleep(800); } catch (InterruptedException e) { this.etat = false; }
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
    
    
    public void poserSurCircuit(Rails railDepart) {
        if (railDepart == null || this.voitureTete == null) {
            return;
        }

        
        String sensArriere = this.sensCirculation.equals("horaire") ? "antihoraire" : "horaire";

        Voiture voitureCourante = this.voitureTete;
        Rails railCourant = railDepart;

        while (voitureCourante != null) {
           
            voitureCourante.changeRail(railCourant);
            
           
            voitureCourante = voitureCourante.obtenirVoitureSuivante();
            
            
            if (voitureCourante != null) {
                railCourant = railCourant.obtenirRailSuivant(sensArriere);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train [sensCirculation=").append(sensCirculation)
          .append(", taille=").append(taille)
          .append(", etat=").append(etat)
          .append(", composition=");

        
        sb.append("[");
        Voiture courant = this.voitureTete;
        while (courant != null) {
            sb.append(courant.getType()); 
            
            courant = courant.obtenirVoitureSuivante();
            
           
            if (courant != null) {
                sb.append(" -> ");
            }
        }
        sb.append("]]");

        return sb.toString();
    }
}
