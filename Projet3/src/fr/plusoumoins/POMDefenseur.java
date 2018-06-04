package fr.plusoumoins;

import fr.PropertiesFile;

public class POMDefenseur {
	private PropertiesFile p;

	
    public POMDefenseur() {
		super();
		p = PropertiesFile.getInstance();
	}


	public void init() {

    	Utile utile = new Utile();
    	boolean verification = false;
    	boolean victoire = false;
    	char reponse [] = new char [p.getGrandeurDuNb()];
    	String solution = "";
    	String proposition = "";
        int nbToursInitial = p.getNbTours();
        int nbTours = p.getNbTours();	//je suis obligé de créer cette variable car je ne peux pas décrémenter mon p.nbTours
        String type = "null";			//type sert pour les modes duel, pour différencier humain et ordi
    	while (verification == false)
    	{
    		solution = utile.phraseDeDebutDefenseur();
    		verification = utile.verificationNb(solution);		//demande une solution pour le jeu à l'utilisateur
    		if(verification == false)
    		{
    			utile.phraseErreurSaisie();
    		}
    	}
    	int solutionInt = utile.transformationStringEnInt(solution);
    	while (victoire == false && nbTours > 0)
    	{
    		if(nbToursInitial == nbTours)
    		{
    			proposition = utile.genererPremiereProposition();
    		}
    		else
    		{
    			reponse = utile.comparaisonPlusOuMoinsDefenseur(solutionInt, proposition, victoire);
    			proposition = utile.combinaisonChoisie(reponse, proposition);		//c'est dans cette méthode que l'ordinateur cherche la bonne combinaison tenant compte du dernier tour
    		}
    			victoire = utile.comparaisonPlusOuMoins(solutionInt, nbTours, proposition, victoire, nbToursInitial, type);
    			nbTours--;
    		
    	}
    	}
    }

