package fr.plusoumoins;

import java.util.Arrays;

public class Utile {

	
	
	
	public int[] transformationIntEnArrayInt (int proposition){
	
		String essai = String.valueOf(proposition);
		int[] montableau = new int[essai.length()];
		int i = 0;
		for (i=0; i < essai.length(); i++){
		  montableau[i]=Integer.parseInt(""+essai.charAt(i));
	}
		return montableau;
}
	
	
	
	
	public void comparaisonPlusOuMoins(int nbAleatoire[], int proposition[], int grandeurDuNb ) 
	{	
		char reponse [] = new char[grandeurDuNb]; 

		for(int i = 0; i < grandeurDuNb; i++)
		{
			if(nbAleatoire[i] > proposition[i])
			{
				reponse[i] = '+';
			}
			else if(nbAleatoire[i] < proposition[i]) {
				reponse[i] = '-';
			}
			else
			{
				reponse[i] = '=';
			}
		}
		String str = Arrays.toString(reponse);
		System.out.println(str);
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
				if (tmp < 48 && tmp > 57) 
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
	
}