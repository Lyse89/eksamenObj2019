package eksamen2019;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kontroll {
	
	private String databasenavn = "jdbc:mysql://localhost:3306/kurs";
    private String databasedriver = "com.mysql.jdbc.Driver";
    private Connection forbindelse;
    private ResultSet resultat;
    private Statement utsagn;
	
    public void kobleTil() throws Exception {        
    	try {
                forbindelse = DriverManager.getConnection(databasenavn,"root","OBJ2100");
    		} catch(Exception e) {                    
                throw new Exception("Kan ikke oppnå kontakt med databasen");                        
    		}            
        }

	public static Kontroll getInstance() {
		return KontrollHolder.INSTANCE;
	}
	
	private static class KontrollHolder {

        private static final Kontroll INSTANCE = new Kontroll();
    }

}
