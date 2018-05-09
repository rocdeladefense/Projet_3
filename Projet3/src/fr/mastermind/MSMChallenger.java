package fr.mastermind;

public class MSMChallenger {

	public void init(int nbTours,int grandeurDuNb)
	{
		UtileMSM utile = new UtileMSM();
		int nbAleatoire = utile.genererNbAleatoire(grandeurDuNb);
        boolean victoire = false;
        boolean verificationNb = true;
        while (nbTours > 0 && victoire == false)
        { 
                String proposition = utile.phraseDeDebut(grandeurDuNb);
                verificationNb = utile.verificationNb(proposition, grandeurDuNb);
                if (verificationNb == true) {
                		victoire = utile.comparaisonMastermind(nbAleatoire, proposition, grandeurDuNb, victoire);
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
