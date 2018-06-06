package fr.mastermind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.PropertiesFile;

public class MSMDuel {
	private PropertiesFile p;	
	   static final Logger logger = LogManager.getLogger(MSMDuel.class.getName());
	
	public MSMDuel() {
		super();
		p = PropertiesFile.getInstance();
	}


	public void init ()
	{
		UtileMSM utile = new UtileMSM();
    	boolean verificationDefenseur = false;
        boolean verificationNbChallenger = false;
    	boolean victoireHumain = false;
    	boolean victoireOrdi = false;
    	boolean etape1 = false;
    	boolean etape2 = false;
    	String solution = "";
    	String typeHumain = "HUMAIN";
    	String typeOrdi = "ORDI";
    	int nbTours = p.getNbTours();
    	int proposition [] = new int [p.getGrandeurDuNb()];
    	int chiffresTrouves[] = new int [p.getGrandeurDuNb()];
        int nbToursInitial = nbTours;
        int reponse [] = new int [2];
        int reponseInitiale[] = new int [2];
        int solutionAdapt [] ;
        int [] nbAleatoire = utile.genererNbAleatoireMSM();
		utile.modeDeveloppeur(nbAleatoire);
    	while (verificationDefenseur == false)				//dans ce mode, l'architecture est la même que dans le mode défenseur
    	{													//avec deux grosses boucles, auquel j'ai ajouté le mode challenger
    		solution = utile.phraseDeDebutDefenseur();		//à la fin de chacune d'entre elles
    		verificationDefenseur = utile.verificationNb(solution);
    		if(verificationDefenseur == false)
    		{
            	logger.error("Erreur de saisie");
    			utile.phraseErreurSaisie();
    		}
    	}
    	int i = 0;
    	int premierChiffreATester [] = {0, 0};
		solutionAdapt = utile.transformationStringEnArrayInt(solution);
    	while (etape1 == false && nbTours > 0 && victoireOrdi == false && victoireHumain == false) //première boucle
    	{
    		proposition = utile.combinaisonChoisieEtape1(nbTours, nbToursInitial);	//début mode def
    		String propositionAdapt = utile.transformationArrayIntEnString(proposition);
    		victoireOrdi = utile.comparaisonMastermind(solutionAdapt, propositionAdapt, victoireOrdi, nbTours, nbToursInitial, typeOrdi);
    		reponse = utile.comparaisonMastermindDefenseur(solution, proposition);
    		if (reponse[0] > premierChiffreATester[1])
    		{
    			premierChiffreATester[0] =  (p.getNbChiffres() - 1 - (nbToursInitial - nbTours));
    			premierChiffreATester[1] = reponse[0];
    		}
    		while (reponse[0] >= 1)
    		{
    			chiffresTrouves[i] = (p.getNbChiffres() - 1 - (nbToursInitial - nbTours));
    			i++;
    			reponse[0]--;
    		}
    		etape1 = utile.verificationEtape1(i);			//fin mode def
    		
    		
    	     String propositionChallenger = utile.phraseDeDebut(); // début mode challenger
             verificationNbChallenger = utile.verificationNb(propositionChallenger);
      		 if (verificationNbChallenger == true) {
             		victoireHumain = utile.comparaisonMastermind(nbAleatoire, propositionChallenger, victoireHumain, nbTours, nbToursInitial, typeHumain);
             }
             else 
             {
            	 while (verificationNbChallenger != true) 
            	 {
            		logger.error("Erreur de saisie");
                  	utile.phraseErreurSaisie();
                  	propositionChallenger = utile.phraseDeDebut();
                    verificationNbChallenger = utile.verificationNb(propositionChallenger);
            	 }
          		victoireHumain = utile.comparaisonMastermind(nbAleatoire, propositionChallenger, victoireHumain, nbTours, nbToursInitial, typeHumain);
             }    //fin mode challenger
    		nbTours--;	
    	}	//on change de boucle quand l'étape 1 du defenseur est passé, ou quand un des deux joueurs a gagné.
    	int combinaison[][] = new int [5][p.getGrandeurDuNb()];		//initialisation de combinaison, comme dans défenseur
    	combinaison[1] = utile.remplirCombinaison1(combinaison[1]);
    	int chiffreTeste = 99;
    	combinaison [3] = chiffresTrouves;
    	for (int o = 0; o < p.getGrandeurDuNb() ; o++)
    	{
    		if (combinaison[3][o] == premierChiffreATester[0])
    		{
    			combinaison[3][o] = 99;
    		}
    	}
    	for(int m = 0; m < p.getGrandeurDuNb() ; m++)
    	{
    		combinaison[0][m] = premierChiffreATester[0];
    	}
    	while (nbTours > 0 && victoireHumain == false && victoireOrdi == false)		//début deuxieme boucle
    	{
    		if (etape2 == false)		//début mode défenseur
    		{
    				combinaison[0] = utile.premiereCombinaisonEtape2(combinaison[0], premierChiffreATester[0]);
    				reponseInitiale = utile.comparaisonMastermindDefenseur(solution, combinaison[0]);
    				etape2 = true;
    		}
        	reponse = utile.comparaisonMastermindDefenseur(solution, combinaison[0]);
    		combinaison = utile.combinaisonChoisieEtape2(combinaison, reponse, reponseInitiale, chiffreTeste, premierChiffreATester);
    		String propositionAdapt = utile.transformationArrayIntEnString(combinaison[0]);
    		if (combinaison[2][0] == p.getGrandeurDuNb())
    		{
    			victoireOrdi = utile.victoireMastermindDefenseur(combinaison, victoireOrdi, nbTours, nbToursInitial, typeOrdi);
    		}
    		else
    		{
    			victoireOrdi = utile.comparaisonMastermind(solutionAdapt, propositionAdapt, victoireOrdi, nbTours, nbToursInitial, typeOrdi);
    		} //fin mode défenseur
    	
    		
    		String propositionChallenger = utile.phraseDeDebut(); //début mode challenger
            verificationNbChallenger = utile.verificationNb(propositionChallenger);
     		 if (verificationNbChallenger == true) {
            		victoireHumain = utile.comparaisonMastermind(nbAleatoire, propositionChallenger, victoireHumain, nbTours, nbToursInitial, typeHumain);
            }
            else 
            {
           	 while (verificationNbChallenger != true) 
           	 {
                 	utile.phraseErreurSaisie();
                 	propositionChallenger = utile.phraseDeDebut();
                   verificationNbChallenger = utile.verificationNb(propositionChallenger);
           	 }
         		victoireHumain = utile.comparaisonMastermind(nbAleatoire, propositionChallenger, victoireHumain, nbTours, nbToursInitial, typeHumain);
            }    //fin mode challenger
   		nbTours--;	
		
	}
    	utile.phraseDeFinMSMDuel(nbAleatoire, victoireHumain, victoireOrdi);
}
}
