package fr;

	import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mastermind.Mastermind;
	import fr.plusoumoins.PlusOuMoins;
	import fr.plusoumoins.Utile;

public class InitJeux {

	   static final Logger logger = LogManager.getLogger(InitJeux.class.getName());

	    private Scanner scb;
		private Scanner scb2;
		Utile utile = new Utile();
		String str1 = "1";
		String str2 = "2";
		String str3 = "3";
		
		public void phraseChoixJeu()
		{
			System.out.println("Choisissez à quel jeu voulez vous jouez : \nTapez 1 pour le +/- \nTapez 2 pour le Mastermind");
		}
		
		public void phraseChoixJeuErreur()
		{
			System.out.println("Vous vous êtes trompé, choisissez à quel jeu voulez vous jouez : \nTapez 1 pour le +/- \nTapez 2 pour le Mastermind");
		}
		
		public void phraseChoixMode()
		{
			System.out.println("Choisissez maintenant votre mode de jeu : \nTapez 1 pour le mode challenger \nTapez 2 pour le mode defenseur \nTapez 3 pour le mode duel");
		}
		
		public void phraseChoixModeErreur()
		{
			System.out.println("Vous vous êtes trompé, choisissez maintenant votre mode de jeu : \nTapez 1 pour le mode challenger \nTapez 2 pour le mode defenseur \nTapez 3 pour le mode duel");
		}
		
		public void phraseChoixRejouer()
		{
			System.out.println("Voulez vous rejouer ? Tapez 1 pour le même jeu, 2 pour un autre jeu ou 3 pour arrêter");
		}

		public int questionChoixJeux () {
			boolean jeu = false;
			scb2 = new Scanner(System.in);
			phraseChoixJeu();
	    	String str =  scb2.nextLine();
	    	while (jeu == false)
	            {
	    		switch (str) {
	    		case "1" : 
	            	jeu = true;
	            	break;
	    		case "2" : 
	    			jeu = true;
	    			break;
	    		default : 
	    			scb = new Scanner(System.in);
	    			logger.error("ERREUR Choix Jeu");
	    			phraseChoixJeuErreur();
	            	str =  scb.nextLine();
	            	break;
	    			 }				//choix du jeu de l'utilisateur, en faisant attention à éviter les erreurs
	            }
	            int i = utile.transformationStringEnInt(str);
	            return i;
	    }
	    
		public int questionChoixMode (int choixJeu) {
			scb = new Scanner(System.in);
			phraseChoixMode();
			String str = scb.nextLine();
				while (!str.equals(str1) && !str.equals(str2) && !str.equals(str3))
	            	{
						scb = new Scanner(System.in);
						logger.error("Erreur Choix Mode");
						phraseChoixModeErreur();
						str = scb.nextLine();
	            	}		//choix du mode de l'utilisateur, en faisant attention à éviter les erreurs
				int i = utile.transformationStringEnInt(str);
	            return i;
	    }

		public void lancementJeu()
		{
			PlusOuMoins plusOuMoins = new PlusOuMoins();
		    Mastermind mastermind = new Mastermind();
		    boolean rejouer = true;
		    boolean memeJeu = false;
		    int memeChoixJeu = 0;
		    int memeChoixMode = 0;
		    while (rejouer == true)
		    {
		    	int choixJeu; 
		    	int choixMode;
		    	if (memeJeu == false)
		    	{
		    		choixJeu = questionChoixJeux();
		    		choixMode = questionChoixMode(choixJeu);
		    	}
		    	else 
		    	{
		    		choixJeu = memeChoixJeu;
		    		choixMode = memeChoixMode;
		    	}
		    	if (choixJeu == 1)
		    	{
		    		plusOuMoins.choixMode(choixMode);
		    	}
		    	else if (choixJeu == 2)
		    	{
		    		mastermind.choixMode(choixMode);
		    	}
		    	String i = "";
		    	while (!i.equals(str1) && !i.equals(str2) && !i.equals(str3))
		    	{
		    		phraseChoixRejouer();
	    			scb = new Scanner(System.in);
	    			i = scb.nextLine();
		    	}   
		    	int j = utile.transformationStringEnInt(i);
		    	switch(j)
		    	{
		    	case 1 :
		    		rejouer = true;							// dans ces lignes, je m'occupe de la fin du jeu, pour que
		    		memeJeu = true;							// l'utilisateur ait le choix de rejouer, changer de jeu ou arrêter
		    		memeChoixJeu = choixJeu;
		    		memeChoixMode = choixMode;
		    		break;
		    	case 2 :
		    		rejouer = true;
		    		memeJeu = false;
		    		break;
		    	case 3 :
		    		rejouer = false;
		    		break;
		    		
		    }

		    }
	}
	}

