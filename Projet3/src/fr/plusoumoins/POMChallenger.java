package fr.plusoumoins;



public class POMChallenger {
	    public void init) {
	    	Utile utile = new Utile();
	    	int nbAleatoire = utile.genererNbAleatoire();
	        boolean victoire = false;
	        boolean verificationNb = true;
	        int nbToursInitial = nbTours;
	        String type = "null";
	        while (nbTours > 0 && victoire == false)
	        {
	                String proposition = utile.phraseDeDebut();
	                verificationNb = utile.verificationNb(proposition);
	                if (verificationNb == true && victoire == false)
	               	{
	                		victoire = utile.comparaisonPlusOuMoins(nbAleatoire, proposition, victoire, nbToursInitial, type);
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
