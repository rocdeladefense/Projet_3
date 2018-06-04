package fr.mastermind;
import fr.PropertiesFile;

import java.util.Arrays;
import java.util.Scanner;


public class UtileMSM {
	private PropertiesFile p;
	public UtileMSM() {
		super();
		p = PropertiesFile.getInstance();
	}
	private Scanner scb;

	public void phraseErreurSaisie()
	{
		System.out.println("Vous avez saisi le mauvais nombre de chiffre, ou avez inclus d'autres caractères que des chiffres, veuillez recommencer svp");
	}
	
	public void phraseDeFinCas1(int [] reponse, String proposition, int nbToursAAfficher, String type)
	{
		if (type == "HUMAIN")
		{
			System.out.println("Tour Humain " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s) et " + reponse[1] + " présent(s)");
		}
		else if (type == "ORDI") {
			System.out.println("Tour Ordinateur " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s) et " + reponse[1] + " présent(s)");
		}
		else
		{
			System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s) et " + reponse[1] + " présent(s)");
		}
	}
		
	public int[] transformationStringEnArrayInt (String proposition){
		int[] montableau = new int[p.getGrandeurDuNb()];
		int difference = 0;
		int j = 0;
		if (proposition.length() < p.getGrandeurDuNb())
		{
			difference = p.getGrandeurDuNb() - proposition.length();
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
		
		public int [] tranformationIntEnArrayIntPropre(int nbAleatoire) {
			String essai = String.valueOf(nbAleatoire);
			int montableau[] = transformationStringEnArrayInt(essai);
			int monTableauFinal [] = new int [p.getGrandeurDuNb()];
			int i = montableau.length - p.getGrandeurDuNb();
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
		
		public boolean comparaisonMastermind(int nbAleatoire[], String proposition, boolean victoire, int nbTours, int nbToursInitial, String type) 
		{	
			int propositionAdapt[] = transformationStringEnArrayInt(proposition);
			int reponse [] = new int[2]; 
			boolean present [] = new boolean [p.getGrandeurDuNb()];
			boolean bienPlace [] = new boolean [p.getGrandeurDuNb()];
			boolean presentDansNbAleatoire [] = new boolean[p.getGrandeurDuNb()];
			int nbDeBienPlace = 0;
			for (int i = 0; i != p.getGrandeurDuNb(); i++)
			{
				if (propositionAdapt[i] == nbAleatoire[i])
				{
					bienPlace[i] = true;
					reponse[0] = reponse[0] + 1;
					nbDeBienPlace++;
				}
			}
			for (int i = 0; i != p.getGrandeurDuNb(); i++)
			{
				for(int j = 0; j != p.getGrandeurDuNb(); j++)
				{
					if (propositionAdapt[i] == nbAleatoire[j] && bienPlace[i] == false && bienPlace[j] == false && present[i] == false && presentDansNbAleatoire[j] == false)
					{
						present[i] = true;
						presentDansNbAleatoire[j] = true;
						reponse[1] = reponse[1] + 1;
					}
				}
			}
			if (nbDeBienPlace == p.getGrandeurDuNb())
			{
				victoire = true;
				phraseDeFinMSM(reponse, proposition, nbTours, nbToursInitial, type);
			}
			else {
				phraseDeFinMSM(reponse, proposition, nbTours, nbToursInitial, type);
			}
			return victoire;
		}
		
		public int [] comparaisonMastermindDefenseur(String solution, int propositionAdapt [])
		{
			int solutionAdapt[] = transformationStringEnArrayInt(solution);
	    	//int propositionAdapt[] = transformationStringEnArrayInt(proposition, grandeurDuNb);
			int reponse [] = new int[2]; 
			boolean present [] = new boolean [p.getGrandeurDuNb()];
			boolean bienPlace [] = new boolean [p.getGrandeurDuNb()];
			boolean presentDansSolution [] = new boolean[p.getGrandeurDuNb()];
			for (int i = 0; i != p.getGrandeurDuNb(); i++)
			{
				if (solutionAdapt[i] == propositionAdapt[i])
				{
					bienPlace[i] = true;
					reponse[0] = reponse[0] + 1;
				}
			}
			for (int i = 0; i != p.getGrandeurDuNb(); i++)
			{
				for(int j = 0; j != p.getGrandeurDuNb(); j++)
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
		
		public void phraseDeFinCas2(int [] reponse, String proposition, int nbToursAAfficher, String type)
		{
			if (type == "HUMAIN")
			{
				System.out.println("Tour Humain " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[1] + " présent(s)");
			}
			else if (type == "ORDI") {
				System.out.println("Tour Ordinateur " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[1] + " présent(s)");
			}
			else
			{
				System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[1] + " présent(s)");
			}
			}
		
		public void phraseDeFinCas3(int [] reponse, String proposition, int nbToursAAfficher, String type)
		{
			if (type == "HUMAIN")
		{
				System.out.println("Tour Humain " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s)");
		}
		else if (type == "ORDI") {
			System.out.println("Tour Ordinateur " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s)");
		}
		else
		{
			System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + reponse[0] + " bien placé(s)");
		}
		}
		
		public void phraseDeFinCas4(int [] reponse, String proposition, int nbToursAAfficher, String type)
		{
			if (type == "HUMAIN")
			{
				System.out.println("Tour Humain " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : Aucun présent ni bien placé");
			}
			else if (type == "ORDI") {
				System.out.println("Tour Ordinateur " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : Aucun présent ni bien placé");
			}
			else
			{
				System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : Aucun présent ni bien placé");
			}
		}
		
		public void phraseIssueDeLaPartieGagnant()
		{
			System.out.println("Félicitations, vous avez réussi");
		}
		
		public String phraseDeDebutDefenseur ()
		{
			int intervalleNb = p.getNbChiffres() - 1;
			 System.out.println("Quelle est votre solution ? (Entrez un nombre à " + p.getGrandeurDuNb() + " chiffres, chaque chiffre doit être compris entre 0 et " + intervalleNb + ")");
	         scb = new Scanner(System.in);
	         String reponse = scb.nextLine();
			 return reponse;
		}
		
		public void phraseIssueDeLaPartiePerdant(int nbAleatoire)
		{
			System.out.println("Vous avez échoué, la bonne réponse était " + nbAleatoire);
		}
		
		public void phraseDeFinMSM (int [] reponse, String proposition, int nbTours, int nbToursInitial, String type) {
			int nbToursAAfficher = nbToursInitial - nbTours + 1;
			if (reponse[0] != 0 && reponse[1] != 0)
			{
				phraseDeFinCas1(reponse, proposition,nbToursAAfficher, type);
			}
			else if (reponse[0] == 0 && reponse[1] != 0)
			{
				phraseDeFinCas2(reponse, proposition,nbToursAAfficher, type);
			}
			else if(reponse[0] != 0 && reponse[1] == 0)
			{
				phraseDeFinCas3(reponse, proposition,nbToursAAfficher, type);
			}
			else
			{
				phraseDeFinCas4(reponse, proposition,nbToursAAfficher, type);
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

		public boolean verificationNb(String proposition) {
			boolean nombre = true;
			int i = 0;
			char[] propositionArray = proposition.toCharArray();
			if (p.getGrandeurDuNb() != proposition.length())
			{
				nombre = false;
			}
			else
			{
				while (i != p.getGrandeurDuNb() && nombre == true)
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

		public String phraseDeDebut()
		 {
			   System.out.println("Quelle est votre proposition ? (Entrez un nombre à " + p.getGrandeurDuNb() + " chiffres)");
               scb = new Scanner(System.in);
               String proposition = scb.nextLine();
			 return proposition;
		 }
	
		public int[] genererNbAleatoireMSM()
		{
			int [] nbAleatoire = new int [p.getGrandeurDuNb()];
	    	int i = 0;
	    	while (i != p.getGrandeurDuNb())
	    	{
	    		nbAleatoire[i] = ((int)( Math.random()* 10));
	    		if (nbAleatoire[i] < p.getNbChiffres())
	    		{
	    			i++;
	    		}
	    	}
	    	return nbAleatoire;
		}
	
		public boolean verificationEtape1(int i)
		{
			boolean verification = false;
			if (i == p.getGrandeurDuNb())
			{
				verification = true;
			}
			return verification;
		}
		
		public int [] combinaisonChoisieEtape1(int nbTours, int nbToursInitial)
		{
			int proposition [] = new int [p.getGrandeurDuNb()];
			int j = (p.getNbChiffres() - 1 - (nbToursInitial - nbTours));
			for(int i = 0; i < p.getGrandeurDuNb() && j > 0; i++)
			{
				proposition[i] = j;
			}
			return proposition;
		}
			
		public int [][] combinaisonChoisieEtape2(int [][] combinaison,int [] reponse, int [] reponseInitiale, int chiffreTeste, int [] premierChiffreATester)
		{
			if (combinaison[2][0] == p.getGrandeurDuNb())
			{
				combinaison[0] = finirDeRemplirCombinaison(combinaison, premierChiffreATester[0]);
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
				if (combinaison[2][0] == p.getGrandeurDuNb())
				{
					combinaison[0] = finirDeRemplirCombinaison(combinaison, premierChiffreATester[0]);
					return combinaison;
				}
				combinaison[0][k] = premierChiffreATester[0];
				k = 0;
				k = trouverEmplacementVide(combinaison[1], 0);
				int z = trouverProchainChiffreATester(combinaison[3]);
				if (k == p.getGrandeurDuNb() || z == p.getGrandeurDuNb())
				{
				
					combinaison[0] = finirDeRemplirCombinaison(combinaison, premierChiffreATester[0]);
					combinaison[2][0] = p.getGrandeurDuNb();
					return combinaison;
				}
				combinaison[0][k] = combinaison[3][z];
			}
			else if (reponse[0] < reponseInitiale[0])
			{
				combinaison[1][k] = premierChiffreATester[0];
				combinaison[2][0] = combinaison[2][0]+1;
				m = trouverIndexChiffreDifferent(premierChiffreATester[0], combinaison[0]);
				tmp = combinaison[0][m];
				combinaison[0][m] = premierChiffreATester[0];
				m++;
				m = trouverEmplacementVide(combinaison[1], m);
				combinaison[0][m] = tmp;
			}
			else
			{
				m = trouverIndexChiffreDifferent(premierChiffreATester[0], combinaison[0]);
				if (m == p.getGrandeurDuNb())
				{
					k = 0;
					k = trouverEmplacementVide(combinaison[1], 0);
					int z =	trouverProchainChiffreATester(combinaison[3]);
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

	
		public int [] premiereCombinaisonEtape2 (int combinaison[], int premierChiffreATester)
		{
			for(int i=0;i<p.getGrandeurDuNb();i++)
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
	    
	    public int trouverProchainChiffreATester(int [] combinaison3)
	    {
	    	int i = 0;
	    	while (i < p.getGrandeurDuNb())
	    	{
	    		if (combinaison3[i] != 99) {
	    			return i;
	    		}
	    		i++;	
	    	}

	    	return i;
	    }

	    public int trouverIndexChiffreDifferent(int premierChiffreATester, int []combinaison)
	    {
	    	int i = 0;
	    	while (i < p.getGrandeurDuNb() && (combinaison[i] == premierChiffreATester))
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
	   
	    public int [] remplirCombinaison1(int [] combinaison1)
	    {
	    	int i = 0;
	    	while (i < p.getGrandeurDuNb())
	    	{
	    		combinaison1[i] = 99;
	    		i++;
	    	}
	    	return combinaison1;
	    }
	    
	    public int [] finirDeRemplirCombinaison(int [][]combinaison, int premierChiffreATester)
	    {
	    	int i = 0;
	    	while (i < p.getGrandeurDuNb())
	    	{
	    		if (combinaison[1][i] == 99)
	    		{
	    			combinaison[1][i] = premierChiffreATester;
	    		}
	    		i++;
	    	}
	    	return combinaison[1];
	    }
	   
	    public boolean victoireMastermindDefenseur(int [] []combinaison, boolean victoire, int nbTours, int nbTourInitial, String type)
	    {
	    	int nbToursAAfficher = nbTourInitial - nbTours + 1;
	    	victoire = true;
	    	String proposition = transformationArrayIntEnString(combinaison[0]);
			if (type == "ORDI") {
				System.out.println("Tour Ordinateur " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + p.getGrandeurDuNb() + " bien placé(s)");
			}
			else
			{
				System.out.println("Tour " + nbToursAAfficher + " : Proposition : " + proposition + " -> Réponse : " + p.getGrandeurDuNb() + " bien placé(s)");
			}
	    	return victoire;
	    }
	    
	    public void phraseDeFinMSMDuel(int nbAleatoire[], boolean victoireHumain, boolean victoireOrdi)
		{

			String nbAleatoireString = transformationArrayIntEnString(nbAleatoire);
			if (victoireHumain && victoireOrdi)
			{
				System.out.println("Match nul entre l'ordinateur et vous, vous avez trouvés la solution au même tour.");
			}
			else if (victoireHumain)
			{
				System.out.println("Félicitation, vous avez remporté le duel.");
			}
			else if (victoireOrdi)
			{
				System.out.println("Vous avez perdu contre l'ordinateur. La solution était " + nbAleatoireString);
			}
			else
			{
				System.out.println("Ni vous, ni l'ordinateur n'avez trouvé la réponse adverse.");
			}
		}
	
	    public void modeDeveloppeur(int[] nbAleatoire)
	    {
	    	if (p.getModeDev() == 99)
	    	{
	    		String solution = transformationArrayIntEnString(nbAleatoire);
	    		System.out.println("Mode Developpeur activé, la solution est " + solution);
	    	}
	    }
}
