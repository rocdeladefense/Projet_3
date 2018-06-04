package fr.plusoumoins;

public class PlusOuMoins {
    public void choixMode (int choixMode) {
        POMChallenger POMch = new POMChallenger();
        POMDefenseur POMde = new POMDefenseur();
        POMDuel POMdu = new POMDuel();
        switch (choixMode)
        {							// cette classe sert à orienter vers le mode choisie par l'utilisateur
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
