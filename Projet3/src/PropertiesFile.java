import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	private int grandeurDuNb;
	private int nbTours;
	private int nbChiffres;
	
	//singleton

	private static Properties INSTANCE = null;
	
	public static Properties getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new Properties();
		}
		return INSTANCE;
	}
	
	public void initGDN()
	{
		this.initGrandeurDuNb();
	}
	
	public void initNBC()
	{
		this.initNbChiffres();
	}
	
	public void initNBT()
	{
		this.initNbTours();
	}
	
	public void initGrandeurDuNb()
	{
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
	        this.grandeurDuNb = Integer.parseInt(properties.getProperty("GRANDEURDUNB"));
	}

	
	public int initNbTours()
	{
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
	        int nbTours = Integer.parseInt(properties.getProperty("NBTOURS"));
	        return nbTours;
	}
	public int initNbChiffres()
	{
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
	        int nbChiffres = Integer.parseInt(properties.getProperty("NBCHIFFRES"));
	        return nbChiffres;
	}

	public int getGrandeurDuNb() {
		return grandeurDuNb;
	}

	public void setGrandeurDuNb(int grandeurDuNb) {
		this.grandeurDuNb = grandeurDuNb;
	}

	public int getNbTours() {
		return nbTours;
	}

	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}

	public int getNbChiffres() {
		return nbChiffres;
	}

	public void setNbChiffres(int nbChiffres) {
		this.nbChiffres = nbChiffres;
	}
}
