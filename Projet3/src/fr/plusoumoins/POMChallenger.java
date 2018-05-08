package fr.plusoumoins;

public class POMChallenger {
	    public void init(int nbTours, int grandeurDuNb) {
	    	Utile utile = new Utile();
	    	int nbAleatoire = ((int)( Math.random()*( 10000)) + 1);
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
	                	System.out.println("Vous avez saisi le mauvais nombre de chiffre, ou avez inclus d'autres caractères que des chiffres, veuillez recommencer svp");
	                }    
	        }
	        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
