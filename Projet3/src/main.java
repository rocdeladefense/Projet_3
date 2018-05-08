public class main {

	public static void main(String[] args) {

        InitJeux initJeux = new InitJeux();
        int grandeurDuNb = 4;
        int nbTours = 10;
        boolean rejouer = true;
        initJeux.lancementJeu(nbTours, grandeurDuNb);
	}
}