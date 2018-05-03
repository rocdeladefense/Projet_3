package fr.plusoumoins;

import java.util.Scanner;

public class POMChallenger {
	    public void init(int nbTours, int grandeurDuNb) {
	    	Utile utile = new Utile();
	    	int nbAleatoire = ((int)( Math.random()*( 10000)) + 1);
	        int nbAleatoireAdapt[] = utile.transformationIntEnArrayInt(nbAleatoire);
	        boolean victoire = false;
	        while (nbTours > 0 && victoire == false)
	        {
	                System.out.println("Quelle est votre proposition ? (Entrez un nombre à " + grandeurDuNb + " chiffres)");
	                Scanner scb = new Scanner(System.in);
	                int proposition = scb.nextInt();
	                int propositionAdapt[] = utile.transformationIntEnArrayInt(proposition);
	                if (grandeurDuNb == propositionAdapt.length)
	               	{
	                	if (proposition == nbAleatoire)
	                	{
	                		System.out.println("====");
	                		victoire = true;
	                	}
	                	else
	                	{
	                		utile.comparaisonPlusOuMoins(nbAleatoireAdapt, propositionAdapt, grandeurDuNb);
	                		nbTours--;	                
	                	}
	                }
	                else 
	                {
	                	System.out.println("Vous avez saisi le mauvais nombre de chiffre, veuillez recommencer svp");
	                }    
	        }
	        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
