package fr.mastermind;

import java.util.Scanner;

public class UtileMSM {
		
	private Scanner scb;

	public int[] transformationStringEnArrayInt (String proposition, int grandeurDuNb){
		
		int[] montableau = new int[grandeurDuNb];
		int i = 0;
		for (i=0; i < proposition.length(); i++){
		  montableau[i]=Integer.parseInt(""+proposition.charAt(i));
		}
		return montableau;
}
		
		public int transformationStringEnInt (String str)
		{
			int i = Integer.parseInt(str);
			return i;
		}
		
		public int [] tranformationIntEnArrayIntPropre(int nbAleatoire, int grandeurDuNb) {
			String essai = String.valueOf(nbAleatoire);
			int montableau[] = transformationStringEnArrayInt(essai, grandeurDuNb);
			int monTableauFinal [] = new int [grandeurDuNb];
			int i = montableau.length - grandeurDuNb;
			int a = 0;
			int length = montableau.length;
			if (i != 0) 
			{
				while (i != 0)
				{
					monTableauFinal[a] = 0;
					i--;
					a++;
				}
			}
			while (length != 0)
			{
				monTableauFinal[a] = montableau[i];
				a++;
				i++;
				length--;
			}
			return monTableauFinal;
		}
		
		public boolean comparaisonMastermind(int nbAleatoire, String proposition, int grandeurDuNb, boolean victoire ) 
		{	
			int propositionAdapt[] = transformationStringEnArrayInt(proposition, grandeurDuNb);
	    	int nbAleatoireAdapt[] = tranformationIntEnArrayIntPropre(nbAleatoire, grandeurDuNb);
	    	int propositionInt = transformationStringEnInt(proposition);
	    	System.out.println(nbAleatoire);
			int reponse [] = new int[2]; 
			boolean present [] = new boolean [grandeurDuNb];
			boolean bienPlace [] = new boolean [grandeurDuNb];
			boolean presentDansNbAleatoire [] = new boolean[grandeurDuNb];
			int nbDeBienPlace = 0;
			for (int i = 0; i != grandeurDuNb; i++)
			{
				if (propositionAdapt[i] == nbAleatoireAdapt[i])
				{
					bienPlace[i] = true;
					reponse[0] = reponse[0] + 1;
					nbDeBienPlace++;
				}
			}
			for (int i = 0; i != grandeurDuNb; i++)
			{
				for(int j = 0; j != grandeurDuNb; j++)
				{
					if (propositionAdapt[i] == nbAleatoireAdapt[j] && bienPlace[i] == false && bienPlace[j] == false && present[i] == false && presentDansNbAleatoire[j] == false)
					{
						present[i] = true;
						presentDansNbAleatoire[j] = true;
						reponse[1] = reponse[1] + 1;
					}
				}
			}
			if (nbDeBienPlace == grandeurDuNb)
			{
				victoire = true;
			}
			else {
				phraseDeFinMSM(reponse, propositionInt);
			}
			return victoire;
		}
		
		public void phraseDeFinMSM (int [] reponse, int proposition) {
			if (reponse[0] != 0 && reponse[1] != 0)
			{
				System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s) et " + reponse[1] + " présent(s)");
			}
			else if (reponse[0] == 0 && reponse[1] != 0)
			{
				System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse[1] + " présent(s)");
			}
			else if(reponse[0] != 0 && reponse[1] == 0)
			{
				System.out.println("Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s)");
			}
			else
			{
				System.out.println("Proposition : " + proposition + " -> Réponse : Aucun présent ni bien placé");
			}
		}
		
		public void issueDeLaPartie (boolean victoire, int nbAleatoire) {
			if (victoire == true) {
				System.out.println("Félicitations, vous avez réussi");
			}
			else {
				System.out.println("Vous avez échoué, la bonne réponse était" + nbAleatoire);
			}
		}

		public boolean verificationNb(String proposition, int grandeurDuNb) {
			boolean nombre = true;
			int i = 0;
			char[] propositionArray = proposition.toCharArray();
			if (grandeurDuNb != proposition.length())
			{
				nombre = false;
			}
			else
			{
				while (i != grandeurDuNb && nombre == true)
				{
					int tmp = (int) propositionArray[i];
					if (tmp < 48 || tmp > 57) 
					{
						nombre = false;
					}
					else
					{
						i++;
					}
				}
			}
					
			return nombre;
		}

		public String phraseDeDebut(int grandeurDuNb)
		 {
			   System.out.println("Quelle est votre proposition ? (Entrez un nombre à " + grandeurDuNb + " chiffres)");
               scb = new Scanner(System.in);
               String proposition = scb.nextLine();
			 return proposition;
		 }
	}