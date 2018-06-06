package fr.mastermind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.PropertiesFile;

public class MSMChallenger {
	private PropertiesFile p;
	static final Logger logger = LogManager.getLogger(MSMChallenger.class.getName());
	
	public MSMChallenger() {
		super();
		p = PropertiesFile.getInstance();
	}

	public void init()
	{
		UtileMSM utile = new UtileMSM();
		int nbToursInitial = p.getNbTours();
		int nbTours = p.getNbTours();
		int [] nbAleatoire = utile.genererNbAleatoireMSM();
		utile.modeDeveloppeur(nbAleatoire);
		String type = "null";
        boolean victoire = false;
        boolean verificationNb = true;
        while (nbTours > 0 && victoire == false)
        { 
                String proposition = utile.phraseDeDebut();		
                verificationNb = utile.verificationNb(proposition); 
                if (verificationNb == true) {		
                		victoire = utile.comparaisonMastermind(nbAleatoire, proposition, victoire, nbTours, nbToursInitial, type);
                		nbTours--;	                
                }
                else 
                {
                	logger.error("Erreur de saisie");
                	utile.phraseErreurSaisie();
                }    
        }
        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
