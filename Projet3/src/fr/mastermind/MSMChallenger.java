package fr.mastermind;
import fr.PropertiesFile;

public class MSMChallenger {
	private PropertiesFile p;

	
	public MSMChallenger() {
		super();
		p = PropertiesFile.getInstance();
	}


	public void init()
	{
		UtileMSM utile = new UtileMSM();
		int nbToursInitial = p.getNbTours();
		int nbTours = p.getNbTours();
		int [] nbAleatoire = utile.genererNbAleatoireMSM();
		utile.modeDeveloppeur(nbAleatoire);
		String type = "null";
        boolean victoire = false;
        boolean verificationNb = true;
        while (nbTours > 0 && victoire == false)
        { 
                String proposition = utile.phraseDeDebut();		//c'est ici que l'utilisateur rentre sa combinaison
                verificationNb = utile.verificationNb(proposition); // vérification qu'il n'y a pas d'erreur de frappe
                if (verificationNb == true) {		
                		victoire = utile.comparaisonMastermind(nbAleatoire, proposition, victoire, nbTours, nbToursInitial, type);
                		nbTours--;	                
                }
                else 
                {
                	utile.phraseErreurSaisie();
                }    
        }
        utile.issueDeLaPartie(victoire, nbAleatoire);
	}
}
