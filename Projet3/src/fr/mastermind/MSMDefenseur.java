package fr.mastermind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.PropertiesFile;

public class MSMDefenseur {
	private PropertiesFile p;
	static final Logger logger = LogManager.getLogger(MSMDefenseur.class.getName());

	public MSMDefenseur() {
		super();
		p = PropertiesFile.getInstance();
	}

	public void init ()
	{
		UtileMSM utile = new UtileMSM();
    	boolean verification = false;
    	boolean victoire = false;
    	boolean etape1 = false;
    	boolean etape2 = false;
    	String type = "null";
    	String solution = "";
    	int nbTours = p.getNbTours();
    	int proposition [] = new int [p.getGrandeurDuNb()];
    	int chiffresTrouves[] = new int [p.getGrandeurDuNb()];
        int nbToursInitial = nbTours;
        int reponse [] = new int [2];
        int reponseInitiale[] = new int [2];
        int solutionAdapt [] ;
    	while (verification == false)
    	{
    		solution = utile.phraseDeDebutDefenseur();		//ici l'utilisateur choisit la solution
    		verification = utile.verificationNb(solution);
    		if(verification == false)
    		{
            	logger.error("Erreur de saisie");
    			utile.phraseErreurSaisie();
    		}
    	}
    	int i = 0;
    	int premierChiffreATester [] = {0, 0};
		solutionAdapt = utile.transformationStringEnArrayInt(solution);
    	while (etape1 == false && nbTours > 0 && victoire == false)
    	{
    		proposition = utile.combinaisonChoisieEtape1(nbTours, nbToursInitial);
    		String propositionAdapt = utile.transformationArrayIntEnString(proposition);
    		victoire = utile.comparaisonMastermind(solutionAdapt, propositionAdapt, victoire, nbTours, nbToursInitial, type);
    		reponse = utile.comparaisonMastermindDefenseur(solution, proposition);
    		if (reponse[0] > premierChiffreATester[1])
    		{
    			premierChiffreATester[0] =  (p.getNbChiffres() - 1 - (nbToursInitial - nbTours));
    			premierChiffreATester[1] = reponse[0];
    		}						//dans cette grosse boucle, l'ordi teste chaque chiffre indépendament jusqu'à trouver tous les chiffres (pas placés) qui se trouvent dans la solution
    		while (reponse[0] >= 1)
    		{
    			chiffresTrouves[i] = (p.getNbChiffres() - 1 - (nbToursInitial - nbTours));
    			i++;
    			reponse[0]--;
    		}
    		etape1 = utile.verificationEtape1(i);
    		nbTours--;	
    	}
    	int combinaison[][] = new int [5][p.getGrandeurDuNb()];			//combinaison est le tableau multi-dimensionnel qui va 
    	combinaison[1] = utile.remplirCombinaison1(combinaison[1]);		//permettre de ne renvoyer qu'une seule variable dans la
    	int chiffreTeste = 99;					//deuxième grande boucle. combinaison[0] est la combinaison testé à chaque tour, et change 
    	combinaison [3] = chiffresTrouves;		//donc à chaque tour, tout en gardant comme base le chiffre qui revient le plus dans 
    	for (int o = 0; o < p.getGrandeurDuNb() ; o++)	//la solution. combinaison[1] est l'array qui stocke à leur bonne place tous les chiffres bien placés
    	{		//combinaison[2][0] est le int qui compte le nb de chiffres bien placés trouvés
    		if (combinaison[3][o] == premierChiffreATester[0])	//combinaison[3] stocke les chiffres trouvés, par ordre décroissant
    		{
    			combinaison[3][o] = 99;
    		}
    	}
    	for(int m = 0; m < p.getGrandeurDuNb() ; m++)
    	{
    		combinaison[0][m] = premierChiffreATester[0];
    	}
    	while (nbTours > 0 && victoire == false)
    	{
    		if (etape2 == false)
    		{
    				combinaison[0] = utile.premiereCombinaisonEtape2(combinaison[0], premierChiffreATester[0]);
    				reponseInitiale = utile.comparaisonMastermindDefenseur(solution, combinaison[0]);
    				etape2 = true;
    		}	//dans cette seconde grosse boucle, l'ordi teste, un par un les chiffres présents pour savoir à quelle place ils sont
        	reponse = utile.comparaisonMastermindDefenseur(solution, combinaison[0]);
    		combinaison = utile.combinaisonChoisieEtape2(combinaison, reponse, reponseInitiale, chiffreTeste, premierChiffreATester);
    		String propositionAdapt = utile.transformationArrayIntEnString(combinaison[0]);
    		if (combinaison[2][0] == p.getGrandeurDuNb())
    		{
    			victoire = utile.victoireMastermindDefenseur(combinaison, victoire, nbTours, nbToursInitial, type);
    		}
    		else
    		{
    			victoire = utile.comparaisonMastermind(solutionAdapt, propositionAdapt, victoire, nbTours, nbToursInitial, type);
    		}
    		nbTours--;
    	}
    	if (victoire)
    	{
    		utile.phraseIssueDeLaPartieGagnant();
    	}
    	
}
}