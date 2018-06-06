package fr.plusoumoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.PropertiesFile;

public class POMDuel {
	private PropertiesFile p;
	static final Logger logger = LogManager.getLogger(POMDuel.class.getName());

	public POMDuel() {
		super();
		p = PropertiesFile.getInstance();
	}

	public void init ()
     {
		 Utile utile = new Utile();
	    	int nbAleatoire = utile.genererNbAleatoire();
	    	utile.modeDeveloppeur(nbAleatoire);
	        boolean victoire = false;
	        boolean verificationNb = true;
	        int nbToursInitial = p.getNbTours();
	        int nbTours = p.getNbTours();
	        boolean victoireOrdi = false;
	    	char reponse [] = new char [p.getGrandeurDuNb()];
	    	String solution = "";
	    	String propositionOrdi = "";
	    	String typeHumain = "HUMAIN";			//ces 2 Strings sont là pour rendre plus clair le déroulement des tours.
	    	String typeOrdi = "ORDI";
	    	boolean verification = false;
	    	while (verification == false)
	    	{
	    		solution = utile.phraseDeDebutDefenseur();
	    		verification = utile.verificationNb(solution);
	    		if(verification == false)
	    		{
                	logger.error("Erreur de saisie");
	    			utile.phraseErreurSaisie();
	    		}
	    	}
	    		int solutionInt = utile.transformationStringEnInt(solution);
	    		
		 while (nbTours > 0 && victoire == false && victoireOrdi == false)
		 {
			if(nbToursInitial == nbTours)
	    	{
	    		propositionOrdi = utile.genererPremiereProposition();
	    	}
	    	else									//l'ordinateur joue en premier
	    	{
	    		reponse = utile.comparaisonPlusOuMoinsDefenseur(solutionInt, propositionOrdi, victoire);
	    		propositionOrdi = utile.combinaisonChoisie(reponse, propositionOrdi);
	    	}
	    	victoireOrdi = utile.comparaisonPlusOuMoins(solutionInt,nbTours, propositionOrdi, victoire, nbToursInitial, typeOrdi);			 
	    	
	    	String proposition = utile.phraseDeDebut();
	   	    verificationNb = utile.verificationNb(proposition);
			while (verificationNb == false)					
			 {												 
            	logger.error("Erreur de saisie");
				utile.phraseErreurSaisie();
				proposition = utile.phraseDeDebut();
				verificationNb = utile.verificationNb(proposition);
			 }
			 victoire = utile.comparaisonPlusOuMoins(nbAleatoire, nbTours, proposition, victoire, nbToursInitial, typeHumain);
        	 nbTours--;
     }
		 utile.phraseDeFinDuel( nbAleatoire, victoire, victoireOrdi);
     }
}
