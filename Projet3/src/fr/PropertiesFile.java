package fr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesFile {

	   static final Logger logger = LogManager.getLogger(PropertiesFile.class.getName());

		private static int grandeurDuNb;		
		private static int nbTours;				
		private static int nbChiffres;			//nombre de chiffres utilisables dans le mastermind
		private static int modeDev;	
		public static int modeDev2;		//mode pour connaître la réponse avant de commencer dans les modes challenger et duel
		
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
		         logger.error("ERREUR : Le fichier properties n'a pas été trouvé.");
		         e.printStackTrace();
		      }
		      try {
		         properties.load(input);
		      } catch (IOException e) {
		         logger.error("ERREUR : Le fichier properties n'a pas été chargé.");
		         e.printStackTrace();
		      }
		      grandeurDuNb = Integer.parseInt(properties.getProperty("GRANDEURDUNB"));
		      logger.debug("grandeurDuNb " + grandeurDuNb);
		      nbTours = Integer.parseInt(properties.getProperty("NBTOURS"));
		      logger.debug("NbTours " + nbTours);
		      nbChiffres = Integer.parseInt(properties.getProperty("NBCHIFFRES"));
		      logger.debug("NbChiffres " + nbChiffres);
		      modeDev = Integer.parseInt(properties.getProperty("MODEDEVELOPPEUR"));
				      logger.debug("Mode Developpeur " + modeDev);
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


		public int getModeDev() {
			return modeDev;
		}

		public int getModeDev2() {
			return this.modeDev2;
		}

		public void setModeDev2(int modeDev2) {
			PropertiesFile.modeDev2 = modeDev2;
		}

}
