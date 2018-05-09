package fr.plusoumoins;

public class PlusOuMoins {
    public void choixMode (int choixmode, int nbTours, int grandeurDuNb) {
        POMChallenger POMch = new POMChallenger();
        POMDefenseur POMde = new POMDefenseur();
        POMDuel POMdu = new POMDuel();
        switch (choixmode)
        {
        case 1:
                POMch.init(nbTours,grandeurDuNb);
        break;
        case 2:
                POMde.init(nbTours, grandeurDuNb);
        break;
        case 3:
                POMdu.init();
        break;
        }
}
}
