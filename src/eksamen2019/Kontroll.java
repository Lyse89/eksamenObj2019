package eksamen2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Kontroll {
	
	private String databasenavn = "jdbc:mysql://localhost:3306/kurs?serverTimezone=UTC";
    private String databasedriver = "com.mysql.jdbc.Driver";
    private Connection forbindelse;
    private ResultSet resultat;
    private Statement utsagn;
	
    public void kobleTil() throws Exception {        
    	try {
                forbindelse = DriverManager.getConnection(databasenavn,"Kurs","Surk");
    		}catch(Exception e) {throw new Exception("Kan ikke oppnå kontakt med databasen");
    		}                        	            
    }

    public ResultSet hentKurs() throws Exception {
        ResultSet resultat = null;
        try {
        	String sqlSetning = "SELECT kursNavn FROM kurs.tblkurs";
        	Statement utsagn = forbindelse.createStatement();
        	resultat = utsagn.executeQuery(sqlSetning);
        }catch(Exception e){
        	throw new Exception("Kan ikke utføre spørringen");
        }
        return resultat;      
        }
    
    public ResultSet hentEvaluering() throws Exception {
        ResultSet resultat = null;
        try {
        	String sqlSetning = "SELECT evalNavn FROM tblevaluering";
        	Statement utsagn = forbindelse.createStatement();
        	resultat = utsagn.executeQuery(sqlSetning);
        }catch(Exception e){
        	throw new Exception("Kan ikke utføre spørringen");
        }
        return resultat;      
        }
    
    
    

    
    
    
    
    
	public static Kontroll getInstance() {
		return KontrollHolder.INSTANCE;
	}
	
	private static class KontrollHolder {

        private static final Kontroll INSTANCE = new Kontroll();
    }

}
