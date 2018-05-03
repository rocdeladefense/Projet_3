package fr.plusoumoins;

import java.util.Scanner;

public class POMChallenger {
	    public void init(int nbTours, int grandeurDuNb) {
	    	Utile utile = new Utile();
	    	int nbAleatoire = ((int)( Math.random()*( 10000)) + 1);
	        int nbAleatoireAdapt[] = utile.transformation(nbAleatoire);
	        while (nbTours > 0) 
	        {
	                System.out.println("Quelle est votre proposition ? (Entrez un nombre à 4 chiffres)");
	                Scanner scb = new Scanner(System.in);
	                int proposition = scb.nextInt();
	                int propositionAdapt[] = utile.transformation(proposition);
	                if (proposition == nbAleatoire)
	                {
	                	System.out.println("==== vous avez réussi !!!");
	                }
	                else
	                {
	                	utile.comparaison(nbAleatoireAdapt, propositionAdapt, grandeurDuNb);
	                }
	                nbTours--;
	        }
	}
}
