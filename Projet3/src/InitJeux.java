import java.util.Scanner;

public class InitJeux {

    private Scanner scb;
	private Scanner scb2;
	public int questionChoixJeux () {
            scb2 = new Scanner(System.in);
            System.out.println("Choisissez à quel jeu voulez vous jouez : \nTapez 1 pour le +/- \nTapez 2 pour le Mastermind");
            return scb2.nextInt();
    }
     public int questionChoixMode (int choixJeu) {
            scb = new Scanner(System.in);
            System.out.println("Choisissez maintenant votre mode de jeu : \nTapez 1 pour le mode challenger \nTapez 2 pour le mode defenseur \nTapez 3 pour le mode duel");
            return scb.nextInt();
    }
}