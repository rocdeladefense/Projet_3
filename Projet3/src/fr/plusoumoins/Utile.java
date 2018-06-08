package fr.plusoumoins;

import fr.PropertiesFile;
import java.util.Arrays;
import java.util.Scanner;

public class Utile {

	private Scanner scb;
	private PropertiesFile p;

	
	public Utile() {
		super();
		p = PropertiesFile.getInstance();
	}

	public int[] transformationStringEnArrayInt (String proposition){
		int[] montableau = new int[p.getGrandeurDuNb()];
		int difference = 0;
		int j = 0;
		if (proposition.length() < p.getGrandeurDuNb())
		{
			difference = p.getGrandeurDuNb()- proposition.length();
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
	
	public String phraseDeDebut()
	 {
		   System.out.println("Quelle est votre proposition ? (Entrez un nombre à " + p.getGrandeurDuNb() + " chiffres)");
         scb = new Scanner(System.in);
         String proposition = scb.nextLine();
		 return proposition;
	 }
	
	public String phraseDeDebutDefenseur ()
	{
		 System.out.println("Quelle est votre solution ? (Entrez un nombre à " + p.getGrandeurDuNb() + " chiffres)");
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
	
	public int [] tranformationIntEnArrayIntPropre(int nbAleatoire) {
		String essai = String.valueOf(nbAleatoire);
		int montableau[] = transformationStringEnArrayInt(essai);
		return montableau;
	}

	public boolean comparaisonPlusOuMoins(int nbAleatoire, int nbTours, String proposition, boolean victoire, int nbToursInitial, String type) 
	{	
    	int propositionAdapt[] = transformationStringEnArrayInt(proposition);
    	int nbAleatoireAdapt[] = tranformationIntEnArrayIntPropre(nbAleatoire);
		char reponse [] = new char[p.getGrandeurDuNb()];
		int nbDeEgal = 0;
		victoire = false;

		for(int i = 0; i < p.getGrandeurDuNb(); i++)
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
		if (nbDeEgal == p.getGrandeurDuNb())
		{
			victoire = true;
		}
		String str = transformationArrayCharEnString(reponse);
		phraseFinComparaison(nbToursInitial, nbTours, proposition, str, type);
		return victoire;
	}

	public char[] comparaisonPlusOuMoinsDefenseur(int nbAleatoire, String proposition, boolean victoire ) 
		{	
	    	int propositionAdapt[] = transformationStringEnArrayInt(proposition);
	    	int nbAleatoireAdapt[] = tranformationIntEnArrayIntPropre(nbAleatoire);
			char reponse [] = new char[p.getGrandeurDuNb()]; 
			victoire = false;
		
			for(int i = 0; i < p.getGrandeurDuNb(); i++)
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

	public String combinaisonChoisie(char [] reponse, String proposition)
	{
		String combinaison = "";
		int [] propositionArrayInt = transformationStringEnArrayInt(proposition);
		if (reponse[0] != '=' && reponse[0] != '+' && reponse[0] != '-')
		{
			int combinaisonInt = genererNbAleatoire();
			combinaison = transformationIntEnString(combinaisonInt);
		}
		else 
		{
			//int tmp = 0;
			int combinaisonArrayInt [] = new int [p.getGrandeurDuNb()];
			for (int i = 0; i < p.getGrandeurDuNb(); i++)
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
		int grandeurDuNb = p.getGrandeurDuNb();
    	int nbAleatoire = ((int)( Math.random()*( (Math.pow(a, ((double)grandeurDuNb))))) + 1);
    	return nbAleatoire;
	}

	public String genererPremiereProposition ()
	{
		int [] propositionArrayInt = new int[p.getGrandeurDuNb()];
		int i = 0;
		int grandeurDuNb = p.getGrandeurDuNb();
		while (grandeurDuNb > 0)
		{
			propositionArrayInt[i] = 5;
			i++;
			grandeurDuNb--;
		}
		String propositionString = transformationArrayIntEnString(propositionArrayInt);
		return propositionString;
	}
	
	public void phraseDeFinDuel(int nbAleatoire, boolean victoire, boolean victoireOrdi)
	{
		String nbAleatoireString = transformationIntEnString(nbAleatoire);
		int [] nbAleatoireArrayInt = transformationStringEnArrayInt(nbAleatoireString);
		nbAleatoireString = transformationArrayIntEnString(nbAleatoireArrayInt);
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
			System.out.println("Vous avez perdu contre l'ordinateur. La solution était " + nbAleatoireString);
		}
		else
		{
			System.out.println("Ni vous, ni l'ordinateur n'avez trouvé la réponse adverse.");
		}
	}
	
	  public void modeDeveloppeur(int nbAleatoire)
	    {
	    	if (p.getModeDev() == 99 || p.getModeDev2() == 99)
	    	{
	    		String solution = transformationIntEnString(nbAleatoire);
	    		int [] solutionArrayInt = transformationStringEnArrayInt(solution);
	    		solution = transformationArrayIntEnString(solutionArrayInt);
	    		System.out.println("Mode Developpeur activé, la solution est " + solution);
	    	}
	    }
}

