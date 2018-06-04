package fr.mastermind;

public class Mastermind {
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
