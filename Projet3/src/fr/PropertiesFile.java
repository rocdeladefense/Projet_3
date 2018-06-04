package fr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

		private static int grandeurDuNb;		//nombre de cases
		private static int nbTours;				//nombre de tours
		private static int nbChiffres;			//nombre de chiffres utilisables dans le mastermind
		private static int modeDev;				//mode pour connaître la réponse avant de commencer dans les modes challenger et duel
		
		//singleton

		private static PropertiesFile INSTANCE = null;
		
		public static PropertiesFile getInstance() {
			if(INSTANCE==null) {
				INSTANCE = new PropertiesFile();
				init();
			}
			return INSTANCE;
		}
		
		
		 public static void init(){
		      Properties properties = new Properties();
		      InputStream input = null;

		      try {
		         input = new FileInputStream("config.properties");
		      } catch (FileNotFoundException e) {
		         System.out.println("ERREUR : Le fichier properties n'a pas été trouvé.");
		         e.printStackTrace();
		      }
		      try {
		         properties.load(input);
		      } catch (IOException e) {
		         System.out.println("ERREUR : Le fichier properties n'a pas été chargé.");
		         e.printStackTrace();
		      }
		      grandeurDuNb = Integer.parseInt(properties.getProperty("GRANDEURDUNB"));
		      nbTours = Integer.parseInt(properties.getProperty("NBTOURS"));
		      nbChiffres = Integer.parseInt(properties.getProperty("NBCHIFFRES"));
		      modeDev = Integer.parseInt(properties.getProperty("MODEDEVELOPPEUR"));
		   }
		
	

		public int getGrandeurDuNb() {
			return grandeurDuNb;
		}

		public int getNbTours() {
			return nbTours;
		}
												//getters des différentes variables
		public int getNbChiffres() {
			return nbChiffres;
		}


		public static int getModeDev() {
			return modeDev;
		}
}
