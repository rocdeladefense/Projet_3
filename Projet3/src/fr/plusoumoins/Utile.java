package fr.plusoumoins;

import java.lang.reflect.Array;
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
}