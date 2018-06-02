package fr.mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class UtileMSM {
		
	private Scanner scb;

	public void phraseErreurSaisie()
	{
		System.out.println("Vous avez saisi le mauvais nombre de chiffre, ou avez inclus d'autres caractères que des chiffres, veuillez recommencer svp");
	}
	
	public void phraseDeFinCas1(int [] reponse, String proposition, int nbToursAAfficher)
	{
		System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s) et " + reponse[1] + " présent(s)");

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
		int i = 0;
		for (i=0; i < proposition.length(); i++, j++){
		  montableau[j]=Integer.parseInt(""+proposition.charAt(i));
		}
		return montableau;
}
		
	public String transformationArrayIntEnString(int [] combinaisonArrayInt)
	{
		String combinaison = Arrays.toString(combinaisonArrayInt).replaceAll("\\[|\\]|,|\\s", "");
		return combinaison;
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
		
		public boolean comparaisonMastermind(int nbAleatoire[], String proposition, int grandeurDuNb, boolean victoire, int nbTours, int nbToursInitial) 
		{	
			int propositionAdapt[] = transformationStringEnArrayInt(proposition, grandeurDuNb);
			int reponse [] = new int[2]; 
			boolean present [] = new boolean [grandeurDuNb];
			boolean bienPlace [] = new boolean [grandeurDuNb];
			boolean presentDansNbAleatoire [] = new boolean[grandeurDuNb];
			int nbDeBienPlace = 0;
			for (int i = 0; i != grandeurDuNb; i++)
			{
				if (propositionAdapt[i] == nbAleatoire[i])
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
					if (propositionAdapt[i] == nbAleatoire[j] && bienPlace[i] == false && bienPlace[j] == false && present[i] == false && presentDansNbAleatoire[j] == false)
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
				phraseDeFinMSM(reponse, proposition, nbTours, nbToursInitial);
			}
			else {
				phraseDeFinMSM(reponse, proposition, nbTours, nbToursInitial);
			}
			return victoire;
		}
		
		public int [] comparaisonMastermindDefenseur(String solution, int propositionAdapt [], int grandeurDuNb)
		{
			int solutionAdapt[] = transformationStringEnArrayInt(solution, grandeurDuNb);
	    	//int propositionAdapt[] = transformationStringEnArrayInt(proposition, grandeurDuNb);
			int reponse [] = new int[2]; 
			boolean present [] = new boolean [grandeurDuNb];
			boolean bienPlace [] = new boolean [grandeurDuNb];
			boolean presentDansSolution [] = new boolean[grandeurDuNb];
			int nbDeBienPlace = 0;
			for (int i = 0; i != grandeurDuNb; i++)
			{
				if (solutionAdapt[i] == propositionAdapt[i])
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
					if (solutionAdapt[i] == propositionAdapt[j] && bienPlace[i] == false && bienPlace[j] == false && present[i] == false && presentDansSolution[j] == false)
					{
						present[i] = true;
						presentDansSolution[j] = true;
						reponse[1] = reponse[1] + 1;
					}
				}
			}
			return reponse;
		}
		

		public void phraseDeFinCas2(int [] reponse, String proposition, int nbToursAAfficher)
		{
			System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[1] + " présent(s)");
		}
		
		public void phraseDeFinCas3(int [] reponse, String proposition, int nbToursAAfficher)
		{
			System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s)");
		}
		
		public void phraseDeFinCas4(int [] reponse, String proposition, int nbToursAAfficher)
		{
			System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : Aucun présent ni bien placé");
		}
		
		public void phraseIssueDeLaPartieGagnant()
		{
			System.out.println("Félicitations, vous avez réussi");
		}
		
		public String phraseDeDebutDefenseur (int grandeurDuNb, int nbChiffres)
		{
			int intervalleNb = nbChiffres - 1;
			 System.out.println("Quelle est votre solution ? (Entrez un nombre à " + grandeurDuNb + " chiffres, chaque chiffre doit être compris entre 0 et " + intervalleNb + ")");
	         scb = new Scanner(System.in);
	         String reponse = scb.nextLine();
			 return reponse;
		}
		
		public void phraseIssueDeLaPartiePerdant(int nbAleatoire)
		{
			System.out.println("Vous avez échoué, la bonne réponse était " + nbAleatoire);
		}
		
		public void phraseDeFinMSM (int [] reponse, String proposition, int nbTours, int nbToursInitial) {
			int nbToursAAfficher = nbToursInitial - nbTours + 1;
			if (reponse[0] != 0 && reponse[1] != 0)
			{
				phraseDeFinCas1(reponse, proposition,nbToursAAfficher);
			}
			else if (reponse[0] == 0 && reponse[1] != 0)
			{
				phraseDeFinCas2(reponse, proposition,nbToursAAfficher);
			}
			else if(reponse[0] != 0 && reponse[1] == 0)
			{
				phraseDeFinCas3(reponse, proposition,nbToursAAfficher);
			}
			else
			{
				phraseDeFinCas4(reponse, proposition,nbToursAAfficher);
			}
		}
		
		public void issueDeLaPartie (boolean victoire, int [] nbAleatoire) {
			String transformation = transformationArrayIntEnString(nbAleatoire);
			int nbAleatoireInt = transformationStringEnInt(transformation);
			if (victoire == true) {
				phraseIssueDeLaPartieGagnant();
			}
			else {
				phraseIssueDeLaPartiePerdant(nbAleatoireInt);
			}
		}

		public boolean verificationNb(String proposition, int grandeurDuNb, int intervalleNb) {
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
	
		public int[] genererNbAleatoireMSM(int grandeurDuNb, int nbChiffres)
		{
			int [] nbAleatoire = new int [grandeurDuNb];
	    	int i = 0;
	    	while (i != grandeurDuNb)
	    	{
	    		nbAleatoire[i] = ((int)( Math.random()* 10));
	    		if (nbAleatoire[i] < nbChiffres)
	    		{
	    			i++;
	    		}
	    	}
	    	return nbAleatoire;
		}
	
		public boolean verificationEtape1(int i, int grandeurDuNb)
		{
			boolean verification = false;
			if (i == grandeurDuNb)
			{
				verification = true;
			}
			return verification;
		}
		
		public int [] combinaisonChoisieEtape1(int grandeurDuNb, int nbChiffres, int nbTours, int nbToursInitial)
		{
			int proposition [] = new int [grandeurDuNb];
			int j = (nbChiffres - 1 - (nbToursInitial - nbTours));
			for(int i = 0; i < grandeurDuNb && j > 0; i++)
			{
				proposition[i] = j;
			}
			nbChiffres--;
			return proposition;
		}
			
		public int [][] combinaisonChoisieEtape2(int grandeurDuNb, int [][] combinaison, int nbChiffres,int [] reponse, int [] reponseInitiale, int chiffreTeste, int [] premierChiffreATester)
		{
			if (combinaison[2][0] == grandeurDuNb)
			{
				combinaison[0] = finirDeRemplirCombinaison(combinaison, premierChiffreATester[0], grandeurDuNb);
				return combinaison;
			}
			int k = getArrayIndex(combinaison[0], premierChiffreATester[0]);
			int m = 0;
			int tmp;
			if (reponse[0] > reponseInitiale[0])
			{
				combinaison[1][k] = combinaison[0][k];
				while (combinaison[3][m] == 99)
				{
					m++;
				}
				combinaison[3][m] = 99;
				combinaison[2][0] = combinaison[2][0]+1;
				if (combinaison[2][0] == grandeurDuNb)
				{
					combinaison[0] = finirDeRemplirCombinaison(combinaison, premierChiffreATester[0], grandeurDuNb);
					return combinaison;
				}
				combinaison[0][k] = premierChiffreATester[0];
				k = 0;
				k = trouverEmplacementVide(combinaison[1], 0);
				int z = trouverProchainChiffreATester(combinaison[3], grandeurDuNb);
				if (k == grandeurDuNb || z == grandeurDuNb)
				{
				
					combinaison[0] = finirDeRemplirCombinaison(combinaison, premierChiffreATester[0], grandeurDuNb);
					combinaison[2][0] = grandeurDuNb;
					return combinaison;
				}
				combinaison[0][k] = combinaison[3][z];
			}
			else if (reponse[0] < reponseInitiale[0])
			{
				combinaison[1][k] = premierChiffreATester[0];
				combinaison[2][0] = combinaison[2][0]+1;
				m = trouverIndexChiffreDifferent(premierChiffreATester[0], grandeurDuNb, combinaison[0]);
				tmp = combinaison[0][m];
				combinaison[0][m] = premierChiffreATester[0];
				m++;
				m = trouverEmplacementVide(combinaison[1], m);
				combinaison[0][m] = tmp;
			}
			else
			{
				m = trouverIndexChiffreDifferent(premierChiffreATester[0], grandeurDuNb, combinaison[0]);
				if (m == grandeurDuNb)
				{
					k = 0;
					k = trouverEmplacementVide(combinaison[1], 0);
					int z =	trouverProchainChiffreATester(combinaison[3], grandeurDuNb);
					combinaison[0][k] = combinaison[3][z];
				}
				else 
				{
					tmp = combinaison[0][m];
					combinaison[0][m] = premierChiffreATester[0];
					m++;
					m = trouverEmplacementVide(combinaison[1], m);
					combinaison[0][m] = tmp;
				}
			}
			
		
			return combinaison;
		}

	
		public int [] premiereCombinaisonEtape2 (int combinaison[], int grandeurDuNb, int premierChiffreATester)
		{
			for(int i=0;i<grandeurDuNb;i++)
			{
				combinaison[i] = premierChiffreATester;
			}
			return combinaison;
		}
		
		public int getArrayIndex(int[] arr,int value) {

	        int k=0;
	        for(int i=0;i<arr.length;i++){

	            if(arr[i]!=value){
	                k=i;
	                break;
	            }
	        }
	    return k;
		}
	    
	    public int trouverProchainChiffreATester(int [] combinaison3, int grandeurDuNb)
	    {
	    	int i = 0;
	    	while (i < grandeurDuNb)
	    	{
	    		if (combinaison3[i] != 99) {
	    			return i;
	    		}
	    		i++;	
	    	}

	    	return i;
	    }
	    public int trouverIndexChiffreDifferent(int premierChiffreATester, int grandeurDuNb, int []combinaison)
	    {
	    	int i = 0;
	    	while (i < grandeurDuNb && (combinaison[i] == premierChiffreATester))
	    	{
	    			i++;
	    	}
	    	return i;
	    }
	    
	    public int trouverEmplacementVide(int [] combinaison1, int i)
	    {
	    	while (combinaison1[i] != 99)
	    	{
	    		i++;
	    	}
	    	return i;
	    }
	    public int [] remplirCombinaison1(int [] combinaison1, int grandeurDuNb)
	    {
	    	int i = 0;
	    	while (i < grandeurDuNb)
	    	{
	    		combinaison1[i] = 99;
	    		i++;
	    	}
	    	return combinaison1;
	    }
	    
	    public int [] finirDeRemplirCombinaison(int [][]combinaison, int premierChiffreATester, int grandeurDuNb)
	    {
	    	int i = 0;
	    	while (i < grandeurDuNb)
	    	{
	    		if (combinaison[1][i] == 99)
	    		{
	    			combinaison[1][i] = premierChiffreATester;
	    		}
	    		i++;
	    	}
	    	return combinaison[1];
	    }
	    public boolean victoireMastermindDefenseur(int [] []combinaison, boolean victoire, int grandeurDuNb, int nbTours, int nbTourInitial)
	    {
	    	int nbTourAAfficher = nbTourInitial - nbTours + 1;
	    	victoire = true;
	    	String proposition = transformationArrayIntEnString(combinaison[0]);
			System.out.println("Tour " + nbTourAAfficher + " : Proposition : " + proposition +" -> Réponse : " + grandeurDuNb + " bien placés");
	    	return victoire;
	    }
	}
