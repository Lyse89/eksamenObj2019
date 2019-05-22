package eksamen2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

	public static Kontroll getInstance() {
		return KontrollHolder.INSTANCE;
	}
	
	private static class KontrollHolder {

        private static final Kontroll INSTANCE = new Kontroll();
    }

	public void nyttSporsmal(int antSp, String evuNavn, String sporsmal, String alt1, String alt2, String alt3) throws Exception {
		if (antSp==1) { 
			try {
				
				String sqlSetning = "INSERT INTO tblevaluering VALUES";
				}catch(Exception e){
				throw new Exception("kan ikke utføre spørringen");
				} //catch     
		} else if (antSp>1) {
			try {
				String sqlSetning = "";
				}catch(Exception e){
				throw new Exception("kan ikke utføre spørringen");
				} //catch   
		}
		
	}

	public ResultSet getKursID(String kursNavn) throws Exception {
		resultat = null;
		PreparedStatement ps = null;
		String sqlSetning = "SELECT kursID FROM tblkurs WHERE kursNavn = ?;";
		try {
    		ps = forbindelse.prepareStatement(sqlSetning);
    		ps.setString(1, (kursNavn));
    		resultat = (ResultSet)ps.executeQuery();
    	}catch(Exception e) {throw new Exception("Finner ikke kurset");}
    	return resultat;
	}

	public ResultSet getEvalID(String evuNavn) throws Exception {
		resultat = null;
		PreparedStatement ps = null;
		String sqlSetning = "SELECT evalID FROM tblevaluering WHERE evalNavn = ?;";
		try {
    		ps = forbindelse.prepareStatement(sqlSetning);
    		ps.setString(1, (evuNavn));
    		resultat = (ResultSet)ps.executeQuery();
    	}catch(Exception e) {throw new Exception("Finner ikke kurset");}
    	return resultat;
	}

	public ResultSet getSpmID(String sporsmal) {
		resultat = null;
		PreparedStatement ps = null;
		String sqlSetning = "SELECT spmID FROM tblsporsmal WHERE spmTekst = ?;";
		try {
    		ps = forbindelse.prepareStatement(sqlSetning);
    		ps.setString(1, (sporsmal));
    		resultat = (ResultSet)ps.executeQuery();
    	}catch(Exception e) {throw new Exception("Finner ikke kurset");}
    	return resultat;
	}

}
