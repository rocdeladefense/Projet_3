package fr.mastermind;

public class MSMChallenger {

	public void init(int nbTours,int grandeurDuNb, int nbChiffres)
	{
		UtileMSM utile = new UtileMSM();
		int nbToursInitial = nbTours;
		int [] nbAleatoire = utile.genererNbAleatoireMSM(grandeurDuNb, nbChiffres);
        boolean victoire = false;
        boolean verificationNb = true;
        while (nbTours > 0 && victoire == false)
        { 
                String proposition = utile.phraseDeDebut(grandeurDuNb);
                verificationNb = utile.verificationNb(proposition, grandeurDuNb, nbChiffres);
                if (verificationNb == true) {
                		victoire = utile.comparaisonMastermind(nbAleatoire, proposition, grandeurDuNb, victoire, nbTours, nbToursInitial);
                		nbTours--;	                
                }
                else 
                {
                	utile.phraseErreurSaisie();
                }    
        }
        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
