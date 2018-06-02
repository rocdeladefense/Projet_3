package fr.mastermind;

import fr.plusoumoins.Utile;

public class MSMDefenseur {
	private int grandeurDuNb;
	public void init (int nbTours, int grandeurDuNb, int nbChiffres)
	{
		this.grandeurDuNb = grandeurDuNb;
		UtileMSM utile = new UtileMSM();
    	boolean verification = false;
    	boolean victoire = false;
    	boolean etape1 = false;
    	boolean etape2 = false;
    	String solution = "";
    	int proposition [] = new int [grandeurDuNb];
    	int chiffresTrouves[] = new int [grandeurDuNb];
        int nbToursInitial = nbTours;
        int reponse [] = new int [2];
        int reponseInitiale[] = new int [2];
        int solutionAdapt [] ;
    	while (verification == false)
    	{
    		solution = utile.phraseDeDebutDefenseur(grandeurDuNb, nbChiffres);
    		verification = utile.verificationNb(solution, grandeurDuNb, nbChiffres);
    		if(verification == false)
    		{
    			utile.phraseErreurSaisie();
    		}
    	}
    	int i = 0;
    	int premierChiffreATester [] = {0, 0};
		solutionAdapt = utile.transformationStringEnArrayInt(solution, grandeurDuNb);
    	while (etape1 == false && nbTours > 0 && victoire == false)
    	{
    		proposition = utile.combinaisonChoisieEtape1(grandeurDuNb, nbChiffres, nbTours, nbToursInitial);
    		String propositionAdapt = utile.transformationArrayIntEnString(proposition);
    		victoire = utile.comparaisonMastermind(solutionAdapt, propositionAdapt, grandeurDuNb, victoire, nbTours, nbToursInitial);
    		reponse = utile.comparaisonMastermindDefenseur(solution, proposition, grandeurDuNb);
    		if (reponse[0] > premierChiffreATester[1])
    		{
    			premierChiffreATester[0] =  (nbChiffres - 1 - (nbToursInitial - nbTours));
    			premierChiffreATester[1] = reponse[0];
    		}
    		while (reponse[0] >= 1)
    		{
    			chiffresTrouves[i] = (nbChiffres - 1 - (nbToursInitial - nbTours));
    			i++;
    			reponse[0]--;
    		}
    		etape1 = utile.verificationEtape1(i, grandeurDuNb);
    		nbTours--;	
    	}
    	int combinaison[][] = new int [5][grandeurDuNb];
    	combinaison[1] = utile.remplirCombinaison1(combinaison[1], grandeurDuNb);
    	int chiffreTeste = 99;
    	combinaison [3] = chiffresTrouves;
    	for (int o = 0; o < grandeurDuNb ; o++)
    	{
    		if (combinaison[3][o] == premierChiffreATester[0])
    		{
    			combinaison[3][o] = 99;
    		}
    	}
    	for(int m = 0; m < grandeurDuNb ; m++)
    	{
    		combinaison[0][m] = premierChiffreATester[0];
    	}
    	while (nbTours > 0 && victoire == false)
    	{
    		if (etape2 == false)
    		{
    				combinaison[0] = utile.premiereCombinaisonEtape2(combinaison[0], grandeurDuNb, premierChiffreATester[0]);
    				reponseInitiale = utile.comparaisonMastermindDefenseur(solution, combinaison[0], grandeurDuNb);
    				etape2 = true;
    		}
        	reponse = utile.comparaisonMastermindDefenseur(solution, combinaison[0], grandeurDuNb);
    		combinaison = utile.combinaisonChoisieEtape2(grandeurDuNb, combinaison, nbChiffres, reponse, reponseInitiale, chiffreTeste, premierChiffreATester);
    		String propositionAdapt = utile.transformationArrayIntEnString(combinaison[0]);
    		if (combinaison[2][0] == grandeurDuNb)
    		{
    			victoire = utile.victoireMastermindDefenseur(combinaison, victoire, grandeurDuNb, nbTours, nbToursInitial);
    		}
    		else
    		{
    			victoire = utile.comparaisonMastermind(solutionAdapt, propositionAdapt, grandeurDuNb, victoire, nbTours, nbToursInitial);
    		}
    		nbTours--;
    	}
    	if (victoire)
    	{
    		utile.phraseIssueDeLaPartieGagnant();
    	}
    	
}
}