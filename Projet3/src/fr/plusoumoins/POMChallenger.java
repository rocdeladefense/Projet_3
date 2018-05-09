package fr.plusoumoins;

public class POMChallenger {
	    public void init(int nbTours, int grandeurDuNb) {
	    	Utile utile = new Utile();
	    	int nbAleatoire = utile.genererNbAleatoire(grandeurDuNb);
	    	System.out.println(nbAleatoire);
	        boolean victoire = false;
	        boolean verificationNb = true;
	        while (nbTours > 0 && victoire == false)
	        {
	                String proposition = utile.phraseDeDebut(grandeurDuNb);
	                verificationNb = utile.verificationNb(proposition, grandeurDuNb);
	                if (verificationNb == true && victoire == false)
	               	{
	                		victoire = utile.comparaisonPlusOuMoins(nbAleatoire, proposition, grandeurDuNb, victoire);
	                		nbTours--;	                
	                }
	                else 
	                {
	                	System.out.println(utile.phraseErreurSaisie());
	                }    
	        }
	        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
