package train_de_noel;

import java.util.List;

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
    	sb.append("5 - Arrêter le train"+"\n");
    	sb.append("6 - Quitter"+"\n");
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
    
    public String afficheMenuSelectionRail(List<Rails> rails) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Choix du rail de départ ===\n");
        
        for (int i = 0; i < rails.size(); i++) {
            sb.append(String.format("%2d - %s\n", (i + 1), rails.get(i).getType()));
        }
        
        sb.append("\nEntrez le numéro du rail choisi : ");
        return sb.toString();
    }
    
    public String afficheMenuSelectionAiguillage(List<Aiguillage> liste, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- ").append(message).append(" ---\n");
        for (int i = 0; i < liste.size(); i++) {
            sb.append(String.format("%2d - Aiguillage (ID: %h)\n", (i + 1), liste.get(i)));
        }
        sb.append("\nVotre choix : ");
        return sb.toString();
    }
    
    
    
    
    
    public boolean quitter(int choix,int nb_quitter) {
		return choix == nb_quitter;
		
			
		
	}

}
