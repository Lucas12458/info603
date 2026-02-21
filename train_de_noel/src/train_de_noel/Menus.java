package train_de_noel;

public class Menus {
	
	public Menus() {
		
	}

    public String afficheMenu() {
    	StringBuilder sb = new StringBuilder("============ Menu ============");
    	sb.append("\n");
    	sb.append("1 - Créer un circuit"+"\n");
    	sb.append("2 - Créer un train"+"\n");
    	sb.append("3 - Afficher le circuit"+"\n");
    	sb.append("4 - Afficher le train"+"\n");
    	sb.append("5 - Démarrer le train"+"\n");
    	sb.append("6 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
		return sb.toString();
    	
    }
    
    public String afficheMenuCircuit() {
    	StringBuilder sb = new StringBuilder("============ Menu ============"+"\n");
    	sb.append("1 - Ajouter un rail"+"\n");
    	sb.append("2 - Afficher le circuit"+"\n");
    	sb.append("3 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
    	return sb.toString();
    }
    
    public String afficheMenuAiguillage() {
    	StringBuilder sb = new StringBuilder("============ Menu ============"+"\n");
    	sb.append("1 - Ajouter un rail"+"\n");
    	sb.append("2 - Afficher la voie secondaire"+"\n");
    	sb.append("3 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
    	return sb.toString();
    }
    
    
    public String afficheMenuRail() {
    	StringBuilder sb = new StringBuilder("============ Menu ============"+"\n");
    	sb.append("1 - Rail droit"+"\n");
    	sb.append("2 - Virage gauche"+"\n");
    	sb.append("3 - Virage droit"+"\n");
    	sb.append("4 - Pont"+"\n");
    	sb.append("5 - Aiguillage"+"\n");
    	sb.append("6 - Passage à niveau"+"\n");
    	sb.append("7 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
    	return sb.toString();
    	
    }
    
    public String afficheMenuTrain() {
    	StringBuilder sb = new StringBuilder("============ Menu ============"+"\n");
    	sb.append("1 - Ajouter une voiture"+"\n");
    	sb.append("2 - Afficher le train"+"\n");
    	sb.append("3 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
    	return sb.toString();
    }
    
    public String afficheMenuLancementTrain() {
    	StringBuilder sb = new StringBuilder("============ Menu ============"+"\n");
    	sb.append("1 - Changer le sens de circulation"+"\n");
    	sb.append("2 - Afficher le train"+"\n");
    	sb.append("3 - Poser le train sur les rails"+"\n");
    	sb.append("4 - Démarrer le train"+"\n");
    	sb.append("5 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
    	return sb.toString();
    }
    
    public String afficheMenuVoiture() {
    	StringBuilder sb = new StringBuilder("============ Menu ============"+"\n");
    	sb.append("1 - Locomotive"+"\n");
    	sb.append("2 - Wagon"+"\n");
    	sb.append("3 - Voiture voyageur"+"\n");
    	sb.append("4 - Quitter"+"\n");
    	sb.append("============================="+"\n");
    	sb.append("Votre choix : ");
    	
    	
    	return sb.toString();
    	
    }
    
    
    
    
    
    public boolean quitter(int choix,int nb_quitter) {
		return choix == nb_quitter;
		
			
		
	}

}
