public class main {

	public static void main(String[] args) {

        InitJeux initJeux = new InitJeux();
        properties prop = properties.getInstance();
        
        prop.init();
        int nbTours = prop.initNbTours();
        int nbChiffres = prop.initNbChiffres();
        initJeux.lancementJeu(nbTours, nbChiffres);
	}
}