package fr.mastermind;

public class Mastermind {
	   public void choixMode (int choixMode, int nbTours, int grandeurDuNb) {
			   MSMChallenger MSMch = new MSMChallenger();
			   MSMDefenseur MSMde = new MSMDefenseur();
			   MSMDuel MSMdu = new MSMDuel();
			   switch (choixMode)
			   {
			   case 1:
				   MSMch.init(nbTours,grandeurDuNb);
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
