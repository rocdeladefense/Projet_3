package fr.plusoumoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.PropertiesFile;

public class POMChallenger {	    
	private PropertiesFile p;
	   static final Logger logger = LogManager.getLogger(POMChallenger.class.getName());

	public POMChallenger() {
		super();
		p = PropertiesFile.getInstance();
	}
	    
	public void init() {

	    	Utile utile = new Utile();
	    	int nbAleatoire = utile.genererNbAleatoire();		//l'ordinateur choisit ce qui sera la solution
	    	utile.modeDeveloppeur(nbAleatoire);					//le mode développeur, si activé, affiche la réponse avant le début
	        boolean victoire = false;
	        boolean verificationNb = true;
	        int nbToursInitial = p.getNbTours();
	        String type = "null";								//type sert pour les modes duel, pour différencier humain et ordi 
	        int nbTours = p.getNbTours();						//comme j'utilise les même méthodes entre les différents mode
	        while (nbTours > 0 && victoire == false)
	        {
	                String proposition = utile.phraseDeDebut();
	                verificationNb = utile.verificationNb(proposition);
	                if (verificationNb == true && victoire == false)
	               	{
	                		victoire = utile.comparaisonPlusOuMoins(nbAleatoire, nbTours, proposition, victoire, nbToursInitial, type);
	                		nbTours--;	                
	                }				//la boucle agit tant que la bonne réponse n'est pas trouvé, tout en décrémentant le nbTours
	                else 
	                {
	                	logger.error("Erreur de saisie");
	                	utile.phraseErreurSaisie();
	                }    

	        }
	        utile.issueDeLaPartie(victoire, nbAleatoire);
	}


}
