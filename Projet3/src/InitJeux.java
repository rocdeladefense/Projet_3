import java.util.Scanner;
import fr.mastermind.Mastermind;
import fr.plusoumoins.PlusOuMoins;
import fr.plusoumoins.Utile;


public class InitJeux {

    private Scanner scb;
	private Scanner scb2;
	Utile utile = new Utile();
	public int questionChoixJeux () {
		scb2 = new Scanner(System.in);
    	System.out.println("Choisissez à quel jeu voulez vous jouez : \nTapez 1 pour le +/- \nTapez 2 pour le Mastermind");
    	String str =  scb2.nextLine();
    	while (str.length() != 1 && str != "1" && str != "2")
            {
            	scb2 = new Scanner(System.in);
            	System.out.println("Vous vous êtes trompé, hoisissez à quel jeu voulez vous jouez : \nTapez 1 pour le +/- \nTapez 2 pour le Mastermind");
            	str =  scb2.nextLine();
            }
           	
            int i = utile.transformationStringEnInt(str);
            return i;
    }
    
	public int questionChoixMode (int choixJeu) {
		scb = new Scanner(System.in);
		System.out.println("Choisissez maintenant votre mode de jeu : \nTapez 1 pour le mode challenger \nTapez 2 pour le mode defenseur \nTapez 3 pour le mode duel");
		String str = scb.nextLine();
			while (str.length() != 1 && str != "1" && str != "2" && str != "3")
            	{
					scb = new Scanner(System.in);
					System.out.println("Vous vous êtes trompé, choisissez maintenant votre mode de jeu : \nTapez 1 pour le mode challenger \nTapez 2 pour le mode defenseur \nTapez 3 pour le mode duel");
					str = scb.nextLine();
            	}
			int i = utile.transformationStringEnInt(str);
            return i;
    }

	public void lancementJeu(int nbTours, int grandeurDuNb)
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
	    		plusOuMoins.choixMode(choixMode, nbTours, grandeurDuNb);
	    	}
	    	else if (choixJeu == 2)
	    	{
	    		mastermind.choixMode(choixMode, nbTours, grandeurDuNb);
	    	}
	    	int i = 0;
	    	while (i != 1 && i!= 2 && i != 3)
	    	{
	    		System.out.println("Voulez vous rejouer ? Tapez 1 pour le même jeu, 2 pour un autre jeu ou 3 pour arrêter");
    			scb = new Scanner(System.in);
    			i = scb.nextInt();
	    	}   
	    	switch(i)
	    	{
	    	case 1 :
	    		rejouer = true;
	    		memeJeu = true;
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