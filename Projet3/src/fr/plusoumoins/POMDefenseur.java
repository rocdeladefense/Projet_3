package fr.plusoumoins;

public class POMDefenseur {
    public void init(int nbTours, int grandeurDuNb) {
    	Utile utile = new Utile();
    	boolean verification = false;
    	boolean victoire = false;
    	char reponse [] = new char [grandeurDuNb];
    	String solution = "";
    	String proposition = "";
    	while (verification == false)
    	{
    		solution = utile.phraseDeDebutDefenseur(grandeurDuNb);
    		verification = utile.verificationNb(solution, grandeurDuNb);
    		if(verification == false)
    		{
    			System.out.println(utile.phraseErreurSaisie());
    		}
    	}
    	int solutionInt = utile.transformationStringEnInt(solution);
    	while (victoire == false && nbTours > 0)
    	{
    			reponse = utile.comparaisonPlusOuMoinsDefenseur(solutionInt, proposition, grandeurDuNb, victoire);
    			proposition = utile.combinaisonChoisie(reponse, grandeurDuNb, proposition);
    			victoire = utile.comparaisonPlusOuMoins(solutionInt, proposition, grandeurDuNb, victoire);
    			nbTours--;
    		
    	}
    	}
    }

