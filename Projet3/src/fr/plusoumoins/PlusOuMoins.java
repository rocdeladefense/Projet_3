package fr.plusoumoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlusOuMoins {
	
	   static final Logger logger = LogManager.getLogger(PlusOuMoins.class.getName());
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
