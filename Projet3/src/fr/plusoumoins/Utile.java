package fr.plusoumoins;

import java.util.Arrays;
import java.util.Scanner;

public class Utile {

	private Scanner scb;
	

	public Utile() {
		super();
		p = Properties.getInstance();
	}

	public int[] transformationStringEnArrayInt (String proposition, int grandeurDuNb){
		int[] montableau = new int[grandeurDuNb];
		int difference = 0;
		int j = 0;
		if (proposition.length() < grandeurDuNb)
		{
			difference = grandeurDuNb - proposition.length();
		}
		while (difference > 0)
		{
			montableau[j] = 0;
			j++;
			difference--;
		}
		
		//String chaine = ("00000000000000000000000".concat(proposition));
		//chaine = chaine.substring(chaine.length() - grandeurDuNb);
		//System.out
		int i = 0;
		for (i=0; i < proposition.length(); i++, j++){
		  montableau[j]=Integer.parseInt(""+proposition.charAt(i));
		}
		return montableau;
}
	
	public int transformationStringEnInt (String str)
	{
		int i = Integer.parseInt(str);
		return i;
	}
	
	public String transformationIntEnString (int i)
	{
		String proposition = String.valueOf( i );
		return proposition;
	}
	
	public String transformationArrayIntEnString(int [] combinaisonArrayInt)
	{
		String combinaison = Arrays.toString(combinaisonArrayInt).replaceAll("\\[|\\]|,|\\s", "");
		return combinaison;
	}

	public String transformationArrayCharEnString(char[] tableauChar)
	{
		String combinaison = Arrays.toString(tableauChar).replaceAll("\\[|\\]|,|\\s", "");
		return combinaison;
	}
	
	public String phraseDeDebut(int grandeurDuNb)
	 {
		   System.out.println("Quelle est votre proposition ? (Entrez un nombre à " + grandeurDuNb + " chiffres)");
         scb = new Scanner(System.in);
         String proposition = scb.nextLine();
		 return proposition;
	 }
	
	public String phraseDeDebutDefenseur (int grandeurDuNb)
	{
		 System.out.println("Quelle est votre solution ? (Entrez un nombre à " + grandeurDuNb + " chiffres)");
         scb = new Scanner(System.in);
         String reponse = scb.nextLine();
		 return reponse;
	}
	
	public void phraseErreurSaisie ()

	{
		String str = "Vous avez saisi le mauvais nombre de chiffre, ou avez inclus d'autres caractères que des chiffres, veuillez recommencer svp";
		System.out.println(str);
	}

	public void phraseIssueDeLaPartieGagnant()
	{
		System.out.println("Félicitations, vous avez réussi");
	}
	
	public void phraseIssueDeLaPartiePerdant(int nbAleatoire)
	{
		System.out.println("Vous avez échoué, la bonne réponse était " + nbAleatoire);
	}
	
	public void phraseFinComparaison(int nbToursInitial, int nbTours, String proposition, String str, String type)
	{
		if (type == "HUMAIN")
		{
			System.out.println("Tour Humain " + (nbToursInitial - nbTours + 1) + " : Proposition : " + proposition + " -> Réponse " + str);
		}
		else if (type == "ORDI")
		{
			System.out.println("Tour Ordi " + (nbToursInitial - nbTours + 1) + " : Proposition : " + proposition + " -> Réponse " + str);
		}
		else
		{
			System.out.println("Tour " + (nbToursInitial - nbTours + 1) + " : Proposition : " + proposition + " -> Réponse " + str);
		}
	}
	
	public int [] tranformationIntEnArrayIntPropre(int nbAleatoire, int grandeurDuNb) {
		String essai = String.valueOf(nbAleatoire);
		int montableau[] = transformationStringEnArrayInt(essai, grandeurDuNb);
	/*	int monTableauFinal [] = new int [grandeurDuNb];
		int i = grandeurDuNb - montableau.length;
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
		}*/
		return montableau;
	}

	public boolean comparaisonPlusOuMoins(int nbAleatoire, String proposition, int grandeurDuNb, boolean victoire, int nbToursInitial, int nbTours, String type) 
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
		String str = transformationArrayCharEnString(reponse);
		phraseFinComparaison(nbToursInitial, nbTours, proposition, str, type);
		return victoire;
	}

	public char[] comparaisonPlusOuMoinsDefenseur(int nbAleatoire, String proposition, int grandeurDuNb, boolean victoire ) 
		{	
	    	int propositionAdapt[] = transformationStringEnArrayInt(proposition, grandeurDuNb);
	    	int nbAleatoireAdapt[] = tranformationIntEnArrayIntPropre(nbAleatoire, grandeurDuNb);
			char reponse [] = new char[grandeurDuNb]; 
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
				}
			}
			return reponse;
		}
	
	public void issueDeLaPartie (boolean victoire, int nbAleatoire) {
		if (victoire == true) {
			phraseIssueDeLaPartieGagnant();
		}
		else {
			phraseIssueDeLaPartiePerdant(nbAleatoire);
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

	public String combinaisonChoisie(char [] reponse, int grandeurDuNb, String proposition)
	{
		String combinaison = "";
		int [] propositionArrayInt = transformationStringEnArrayInt(proposition, grandeurDuNb);
		if (reponse[0] != '=' && reponse[0] != '+' && reponse[0] != '-')
		{
			int combinaisonInt = genererNbAleatoire(grandeurDuNb);
			combinaison = transformationIntEnString(combinaisonInt);
		}
		else 
		{
			//int tmp = 0;
			int combinaisonArrayInt [] = new int [grandeurDuNb];
			for (int i = 0; i < grandeurDuNb; i++)
				{
					switch (reponse[i])
					{
					case '=' :
					combinaisonArrayInt[i] = propositionArrayInt[i];
					break;
					case '+' :
				//	tmp = 9 - propositionArrayInt[i] + 3;
				//	tmp = tmp / 2 + 1;
					combinaisonArrayInt[i] = propositionArrayInt[i] + 1;
					break;	
					case '-' :
					//tmp = (propositionArrayInt[i]) - 2;
					combinaisonArrayInt[i] = propositionArrayInt[i] - 1;
					break;	
					}
					}
			combinaison = transformationArrayIntEnString(combinaisonArrayInt);
		}
		
		return combinaison;
	}
	
	public int genererNbAleatoire()
	{
		double a = 10;
    	int nbAleatoire = ((int)( Math.random()*( (Math.pow(a, ((double)grandeurDuNb))))) + 1);
    	return nbAleatoire;
	}

	public String genererPremiereProposition (int grandeurDuNb)
	{
		int [] propositionArrayInt = new int[grandeurDuNb];
		int i = 0;
		while (grandeurDuNb > 0)
		{
			propositionArrayInt[i] = 5;
			i++;
			grandeurDuNb--;
		}
		String propositionString = transformationArrayIntEnString(propositionArrayInt);
		return propositionString;
	}
	
	public void phraseDeFinDuel(int grandeurDuNb, int nbAleatoire, boolean victoire, boolean victoireOrdi)
	{
		if (victoire && victoireOrdi)
		{
			System.out.println("Match nul entre l'ordinateur et vous, vous avez trouvés la solution au même tour.");
		}
		else if (victoire)
		{
			System.out.println("Félicitation, vous avez remporté le duel.");
		}
		else if (victoireOrdi)
		{
			System.out.println("Vous avez perdu contre l'ordinateur. La solution était " + nbAleatoire);
		}
		else
		{
			System.out.println("Ni vous, ni l'ordinateur n'avez trouvé la réponse adverse.");
		}
	}
}

