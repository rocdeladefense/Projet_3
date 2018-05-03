import fr.mastermind.Mastermind;
import fr.plusoumoins.PlusOuMoins;

public class main {

	public static void main(String[] args) {

        InitJeux initJeux = new InitJeux();
        PlusOuMoins plusOuMoins = new PlusOuMoins();
        Mastermind mastermind = new Mastermind();
        int choixJeu = initJeux.questionChoixJeux();
        int choixMode = initJeux.questionChoixMode(choixJeu);
        if (choixJeu == 1)
              plusOuMoins.choixMode(choixMode);
       else
            mastermind.choixMode(choixMode);
	}

}
