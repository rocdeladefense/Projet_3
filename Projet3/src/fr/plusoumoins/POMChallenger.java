package fr.plusoumoins;

import java.util.Scanner;

public class POMChallenger {
	    public void init(int nbTours, int grandeurDuNb) {
	    	Utile utile = new Utile();
	    	int nbAleatoire = ((int)( Math.random()*( 10000)) + 1);
	        boolean victoire = false;
	        boolean verificationNb = true;
	        while (nbTours > 0 && victoire == false)
	        {
	                System.out.println("Quelle est votre proposition ? (Entrez un nombre à " + grandeurDuNb + " chiffres)");
	                Scanner scb = new Scanner(System.in);
	                String proposition = scb.nextLine();
	                verificationNb = utile.verificationNb(proposition, grandeurDuNb);
	                if (verificationNb == true)
	               	{
	                	int propositionInt = utile.transformationStringEnInt(proposition); 
	                	if (propositionInt == nbAleatoire)
	                	{
	                		System.out.println("====");
	                		victoire = true;
	                	}
	                	else
	                	{
	                		utile.comparaisonPlusOuMoins(nbAleatoire, propositionInt, grandeurDuNb);
	                		nbTours--;	                
	                	}
	                }
	                else 
	                {
	                	System.out.println("Vous avez saisi le mauvais nombre de chiffre, ou avez inclus d'autres caractères que des chiffres, veuillez recommencer svp");
	                }    
	        }
	        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
