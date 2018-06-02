package fr.plusoumoins;

public class PlusOuMoins {
    public void choixMode () {
        POMChallenger POMch = new POMChallenger();
        POMDefenseur POMde = new POMDefenseur();
        POMDuel POMdu = new POMDuel();
        switch (choixmode)
        {
        case 1:
                POMch.init();
        break;
        case 2:
                POMde.init();
        break;
        case 3:
                POMdu.init();
        break;
        }
}
}
