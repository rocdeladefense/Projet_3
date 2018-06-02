package fr.plusoumoins;


public class POMDuel {
	 public void init (int nbTours, int grandeurDuNb)
     {
		 Utile utile = new Utile();
	    	int nbAleatoire = utile.genererNbAleatoire(grandeurDuNb);
	        boolean victoire = false;
	        boolean verificationNb = true;
	        int nbToursInitial = nbTours;
	        boolean victoireOrdi = false;
	    	char reponse [] = new char [grandeurDuNb];
	    	String solution = "";
	    	String propositionOrdi = "";
	    	String typeHumain = "HUMAIN";
	    	String typeOrdi = "ORDI";
	    	boolean verification = false;
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
	    		
		 while (nbTours > 0 && victoire == false && victoireOrdi == false)
		 {
			if(nbToursInitial == nbTours)
	    	{
	    		propositionOrdi = utile.genererPremiereProposition(grandeurDuNb);
	    	}
	    	else
	    	{
	    		reponse = utile.comparaisonPlusOuMoinsDefenseur(solutionInt, propositionOrdi, grandeurDuNb, victoire);
	    		propositionOrdi = utile.combinaisonChoisie(reponse, grandeurDuNb, propositionOrdi);
	    	}
	    	victoireOrdi = utile.comparaisonPlusOuMoins(solutionInt, propositionOrdi, grandeurDuNb, victoire, nbToursInitial, nbTours, typeOrdi);			 
	    	
	    	String proposition = utile.phraseDeDebut(grandeurDuNb);
	   	    verificationNb = utile.verificationNb(proposition, grandeurDuNb);
			while (verificationNb == false)
			 {
			 proposition = utile.phraseDeDebut(grandeurDuNb);
	         verificationNb = utile.verificationNb(proposition, grandeurDuNb);
	         utile.phraseErreurSaisie();
			 }
			 victoire = utile.comparaisonPlusOuMoins(nbAleatoire, proposition, grandeurDuNb, victoire, nbToursInitial, nbTours, typeHumain);
        	 nbTours--;
     }
		 utile.phraseDeFinDuel(grandeurDuNb, nbAleatoire, victoire, victoireOrdi);
     }
}
