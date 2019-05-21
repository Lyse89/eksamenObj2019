package eksamen2019;

import java.sql.Connection;
import java.sql.DriverManager;


public class Kontroll {
	private Connection forbindelse;
	private String databasenavn = "jdbc:mysql://localhost:3306/kurs";
	private String databasedriver = "com.mysql.jdbc.Driver";

	public static Kontroll getInstance() {
        return KontrollHolder.INSTANCE;
    }
    
    private static class KontrollHolder {

        private static final Kontroll INSTANCE = new Kontroll();
    }


	public void kobleFra() throws Exception {
		 try {
             if(forbindelse != null) {
                 forbindelse.close();
             }
         }catch(Exception e) {
             throw new Exception("Forbineldsen kan ikke lukkes");
         }  
		
	}

	public void kobleTil() throws Exception {
		try {
            forbindelse = DriverManager.getConnection(databasenavn,"root","OBJ2100");
		} catch(Exception e) {                    
            throw new Exception("Oppkobling mislykket");                        
		} 
	}

}
