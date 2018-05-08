package fr.plusoumoins;

import java.util.Arrays;
import java.util.Scanner;

public class Utile {

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

	public boolean comparaisonPlusOuMoins(int nbAleatoire, String proposition, int grandeurDuNb, boolean victoire ) 
	{	
    	int propositionAdapt[] = transformationStringEnArrayInt(proposition, grandeurDuNb);
    	int nbAleatoireAdapt[] = tranformationIntEnArrayIntPropre(nbAleatoire, grandeurDuNb);
    	
		char reponse [] = new char[grandeurDuNb]; 
		int nbDeEgal = 0;
		victoire = false;

		for(int i = 0; i < grandeurDuNb; i++)
		{
			if(nbAleatoireAdapt[i] > propositionAdapt[i])
			{
				reponse[i] = '+';
			}
			else if(nbAleatoireAdapt[i] < propositionAdapt[i]) {
				reponse[i] = '-';
			}
			else
			{
				reponse[i] = '=';
				nbDeEgal++;
			}
		}
		if (nbDeEgal == grandeurDuNb)
		{
			victoire = true;
		}
		String str = Arrays.toString(reponse);
		System.out.println(str);
		return victoire;
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

