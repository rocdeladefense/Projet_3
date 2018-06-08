package fr;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fr.PropertiesFile;


public class ClasseDuMain {

	   static final Logger logger = LogManager.getLogger(ClasseDuMain.class.getName());

	  
	public static void main(String[] args) {
	       InitJeux initJeux = new InitJeux();
	       if (args.length == 0 || !args[0].equals("99"))
	       {
		       initJeux.lancementJeu(); 
	       }
	       else
			{
		       PropertiesFile properties = new PropertiesFile();
		       properties.setModeDev2(99);
			   initJeux.lancementJeu();
			}
	       }
}
