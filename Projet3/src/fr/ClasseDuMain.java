package fr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClasseDuMain {

	   static final Logger logger = LogManager.getLogger(ClasseDuMain.class.getName());

	public static void main(String[] args) {	      	
	       InitJeux initJeux = new InitJeux();
	       initJeux.lancementJeu();
	}
}
