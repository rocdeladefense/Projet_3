package fr.plusoumoins;

public class POMDefenseur {
    public void init(int nbTours, int grandeurDuNb) {
    	Utile utile = new Utile();
    	boolean verification = false;
    	boolean victoire = false;
    	char reponse [] = new char [grandeurDuNb];
    	String solution = "";
    	String proposition = "";
        int nbToursInitial = nbTours;
        String type = "null";
    	while (verification == false)
    	{
    		solution = utile.phraseDeDebutDefenseur(grandeurDuNb);
    		verification = utile.verificationNb(solution, grandeurDuNb);
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
    			proposition = utile.genererPremiereProposition(grandeurDuNb);
    		}
    		else
    		{
    			reponse = utile.comparaisonPlusOuMoinsDefenseur(solutionInt, proposition, grandeurDuNb, victoire);
    			proposition = utile.combinaisonChoisie(reponse, grandeurDuNb, proposition);
    		}
    			victoire = utile.comparaisonPlusOuMoins(solutionInt, proposition, grandeurDuNb, victoire, nbToursInitial, nbTours, type);
    			nbTours--;
    		
    	}
    	}
    }

