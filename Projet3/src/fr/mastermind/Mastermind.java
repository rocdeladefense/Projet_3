package fr.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mastermind {
	   static final Logger logger = LogManager.getLogger(Mastermind.class.getName());

	   public void choixMode (int choixMode) {
			   MSMChallenger MSMch = new MSMChallenger();
			   MSMDefenseur MSMde = new MSMDefenseur();
			   MSMDuel MSMdu = new MSMDuel();
			   switch (choixMode)
			   {					// cette classe sert à orienter vers le mode choisie par l'utilisateur
			   case 1:
				   MSMch.init();
			   break;
			   case 2:
				   MSMde.init();
			   break;
			   case 3:
				   MSMdu.init();
			   break;
			        }
			}
			}
