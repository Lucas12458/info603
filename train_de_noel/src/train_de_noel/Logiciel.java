package train_de_noel;

import in.keyboard.Keyboard;

public class Logiciel {
    private static Train train;
    
    private static Circuit circuit;
    
    public static void main(String[] args) {
		new Logiciel();
		Menus menu = new Menus();
		String sens = "antihoraire";
		boolean quitter = false;
		while(!quitter) {
			System.out.print(menu.afficheMenu());
			
			int choix = choix();
			
			switch (choix) {
			case 1:
				
				setCircuit(new Circuit(sens));
				
				
				
				while(!menu.quitter(choix, 3)) {
					System.out.println(menu.afficheMenuCircuit());
					
					choix = choix();
					switch(choix) {
					case 1:
						getCircuit().ajouterRail(ajouterRailsCircuit(menu));
						break;
					case 2:
						System.out.println(getCircuit().toString());
						break;
						
					}
					
				}
				break;
				
			case 2:
				setTrain(new Train(sens));
				while(!menu.quitter(choix, 3)) {
					System.out.println(menu.afficheMenuTrain());
					
					choix = choix();
					switch(choix) {
					case 1:
						getTrain().ajouterVoiture(ajouterVoitureTrain(menu));
						break;
					case 2:
						System.out.println(getTrain().toString());
						break;
					}
					
						
					
				}
			break;
			
			case 3:
				if(getCircuit() != null) {
					System.out.println(getCircuit().toString()); 
				}
				else {
					System.err.println("Veuillez créer un circuit");
					
				}
			break;
			
			case 4:
				if(getTrain() != null) {
					System.out.println(getTrain().toString());
				}
				else {
					System.err.println("Veuillez créer un train");
				}
			break;
			
			case 5:
				if(getTrain() != null && getCircuit() != null) {
					do {
						System.out.println(menu.afficheMenuLancementTrain());
						
						choix = choix();
						switch(choix) {
						
						case 1:
							System.out.println("Le train avancera dans le sens "+getTrain().obtenirSensCirculation()+"\n");
							System.out.println("Voulez vous le faire changer de sens ?");
							
							System.out.println("1 - Changer le sens de circulation"+"\n");
							System.out.println("2 - Ne pas changer le sens de circulation"+"\n");
							
							choix = choix();
							switch(choix) {
							case 1:
								getTrain().choisirSens();
								System.out.println("Le train avancera dans le sens "+getTrain().obtenirSensCirculation()+"\n");
								break;
							case 2:
								System.out.println("Le train avancera dans le sens "+getTrain().obtenirSensCirculation()+"\n");
								break;
							
							}
						break;
						
						case 2:
							System.out.println(getTrain().toString());
							break;
						
						case 3:
							break;
						
						case 4:
							Thread threadTrain = new Thread(getTrain());
							threadTrain.start();
							break;
							
						default:
							break;
							
						}
						
					}
					while(!menu.quitter(choix, 5));
				
					
					
					
					
					
					
			}
			else if(getTrain() != null) {
				System.err.println("Veuillez créer un train");
				
			}
			else if(getCircuit() != null) {
				System.err.println("Veuillez créer un circuit");
				
			}
			
			else {
				System.err.println("Veuillez créer un train et un circuit");
			}
			
			break;
			
				
				
			default :
				quitter = true;
				break;
			
			}
			
			
			
		}
    }
    
    public static Circuit getCircuit() {
		return circuit;
	}

    public static Train getTrain() {
		return train;
	}

	public static void setTrain(Train train) {
		Logiciel.train = train;
	}

	public static void setCircuit(Circuit circuit) {
        Logiciel.circuit = circuit;
    }

	public Logiciel() {
    	/*String sens = "antihoraire";
		
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
    	*/
    	

    	
    	
    	
    	    	
    	
    }
    
    public static int choix() {
		int choix = Keyboard.getInt();
		return choix;
	}
    
    
    public static TypeRail ajouterRailsCircuit(Menus menu) {
    	System.out.println(menu.afficheMenuRail());
    	int choix = choix();
    	TypeRail rail = null;
    	
    	switch(choix) {
    	case 1:
    		rail = TypeRail.droit;
    		break;
    	case 2:
    		rail = TypeRail.virage_gauche;
    		break;
    	case 3:
    		rail = TypeRail.virage_droit;
    		break;
    	case 4:
    		rail = TypeRail.pont;
    		break;
    	case 5:
    		rail = TypeRail.aiguillage;
    		break;
    	case 6:
    		rail = TypeRail.passageNiveau;
    		break;
    	default:
    		
    		break;
    	
    	
    	}
    	
    	return rail;
    	
    	
    	
    }
    
    public static TypeVoiture ajouterVoitureTrain(Menus menu) {
    	System.out.println(menu.afficheMenuVoiture());
    	int choix = choix();
    	TypeVoiture voiture = null;
    	
    	switch(choix) {
    	case 1:
    		voiture = TypeVoiture.Locomotive;
    		break;
    	case 2:
    		voiture = TypeVoiture.Wagon;
    		break;
    	case 3:
    		voiture = TypeVoiture.VoitureVoyageur;
    		break;
    	default:
    		break;
    		
    	}
    	
    	return voiture;
    }
    
    
    
    
    

}
