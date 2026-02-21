package train_de_noel;

import java.util.List;

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
				
				
				
				while(!menu.quitter(choix, 4)) {
					System.out.println(menu.afficheMenuCircuit());
					
					choix = choix();
					switch(choix) {
					case 1:
						getCircuit().ajouterRail(ajouterRailsCircuit(menu));
						break;
					case 2:
						System.out.println(getCircuit().toString());
						break;
						
					case 3:
					    List<Aiguillage> aiguillages = getCircuit().obtenirAiguillages();
					    
					    if (aiguillages.isEmpty()) {
					        System.err.println("Aucun aiguillage trouvé dans le circuit principal.");
					    } else {
					       
					        System.out.print(menu.afficheMenuSelectionAiguillage(aiguillages, "Choisir l'aiguillage de départ"));
					        int idxSource = choix() - 1;

					       
					        System.out.print(menu.afficheMenuSelectionAiguillage(aiguillages, "Choisir l'aiguillage de destination"));
					        int idxDest = choix() - 1;

					        if (idxSource >= 0 && idxSource < aiguillages.size() && idxDest >= 0 && idxDest < aiguillages.size()) {
					            Aiguillage source = aiguillages.get(idxSource);
					            Aiguillage dest = aiguillages.get(idxDest);

					            
					            TypeRail type = ajouterRailsCircuit(menu);
					            
					            if (type != null) {
					                getCircuit().ajouterRailBranche(source, dest, type);
					                System.out.println("Rail ajouté sur la branche B de l'aiguillage.");
					            }
					        } else {
					            System.err.println("Selection invalide.");
					        }
					    }
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
							if (getTrain() != null && getCircuit() != null) {
						        
						        List<Rails> railsDisponibles = getCircuit().obtenirListeRails();

						        System.out.print(menu.afficheMenuSelectionRail(railsDisponibles));

						        int indexChoisi = choix() - 1;

						        if (indexChoisi >= 0 && indexChoisi < railsDisponibles.size()) {
						            getTrain().poserSurCircuit(railsDisponibles.get(indexChoisi));
						            System.out.println("Train installé.");
						        } else {
						            System.err.println("Choix invalide.");
						        }
						    }
							
							break;
						
						case 4:
						   
						    if(getTrain().obtenirVoitureTete().getRail() != null) {
						        if (!getTrain().isEtat()) { 
						            Thread threadTrain = new Thread(getTrain());
						            threadTrain.start();
						            System.out.println(Couleurs.VERT + "Le train s'élance !" + Couleurs.RESET);
						            System.out.println(Couleurs.JAUNE + "Appuyez sur 5 pour l'arrêter" + Couleurs.RESET);
						        } else {
						            System.out.println(Couleurs.JAUNE + "Le train roule déjà !" + Couleurs.RESET);
						        }
						    } else {
						        System.err.println("Veuillez poser le train sur les rails");
						    }
						    break;
							
						case 5:
							if (getTrain().isEtat()) { 
								getTrain().arreter();
							}
						
							else {
								System.out.println(Couleurs.JAUNE + "Le train est déjà à l'arrêt !" + Couleurs.RESET);
							}
							break;
							
						case 6:
							break;
							
						default:
							break;
							
						}
						
					}
					while(!menu.quitter(choix, 6));
				
					
					
					
					
					
					
				} 
				else {
				    
					String messageErreur = "";
			        
			        if (getTrain() == null && getCircuit() == null) {
			            messageErreur = "Veuillez créer un train ET un circuit.";
			        } 
			        else if (getTrain() == null) {
			            messageErreur = "Veuillez créer un train.";
			        } 
			        else {
			            messageErreur = "Veuillez créer un circuit.";
			        }
			        
			        System.out.println(Couleurs.ROUGE +"Erreur : "+messageErreur+ Couleurs.RESET);
			        System.out.println("Appuyez sur Entrée pour continuer...");
			        Keyboard.getString();
				}
			
			break;
			
				
				
			default :
				quitter = true;
				break;
			
			}
			
			
			
		}
		System.out.println("================================="+"\n");
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
