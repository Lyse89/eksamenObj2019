package eksamen2019;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Kontroll {
	
	private Kontroll kontroll = Kontroll.getInstance();
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
    
    public ResultSet hentSpørsmål(String valgtSpørreSkjema) throws Exception {
        ResultSet resultat = null;
        try {
			String sqlSetning = "SELECT tblsporsmal.spmTekst FROM tblsporsmal INNER JOIN tblevaluering ON tblevaluering.evalNavn = " + valgtSpørreSkjema  + "awd" +" AND tblsporsmal.spmEvalID =tblevaluering.evalID";
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

	/**
	 * Metode som gir kursID tilbake
	 */
	public ResultSet getKursID(String kursNavn) throws Exception {
		try {
			resultat = null;
			String sqlSetning = "SELECT kursID FROM tblkurs WHERE kursNavn = '" + kursNavn + "';";
    		utsagn = forbindelse.createStatement();
    		resultat = utsagn.executeQuery(sqlSetning);
    	}catch(Exception e) {throw new Exception("Finner ikke kurset");}
    	return resultat;
	}
	
	/**
	 * Metode som gir evalID tilbake
	 */
	public ResultSet getEvalID(String evuNavn) throws Exception {
		resultat = null;
		try {
			String sqlSetning = "SELECT evalID FROM tblevaluering WHERE evalNavn = '" + evuNavn + "';";
			utsagn = forbindelse.createStatement();
            resultat = utsagn.executeQuery(sqlSetning);
    	}catch(Exception e) {throw new Exception("Finner ikke kurset");}
    	return resultat;
	}
	
	/**
	 * Metode som gir spmID tilbake
	 */
	public ResultSet getSpmID(String sporsmal) throws Exception {
		resultat = null;
		try {
			String sqlSetning = "SELECT spmID FROM tblsporsmal WHERE spmTekst = '" + sporsmal + "';";;
			utsagn = forbindelse.createStatement();
            resultat = utsagn.executeQuery(sqlSetning);
    	}catch(Exception e) {throw new Exception("Finner ikke kurset");}
    	return resultat;
	}
	
	
	/**
	 * Denne metoden Registrere
	 * til tblevaluering
	 * tblsporsmal
	 * tlbalternative
	 */
	public void nyttSporsmal(int antsp, String kurset, String evuNavn, String sporsmal, Date startTid, Date slutTid, String alt1, String alt2, String alt3, String alt4, String alt5) throws Exception {
		if (antsp==1) {
				ResultSet kurs = getKursID(kurset);
				
				kurs.next();
				int kursID = kurs.getInt(1);
				String sqlSetning = "INSERT INTO tblevaluering VALUES(NULL,'" + kursID + "','" + evuNavn + "','" + startTid + "','" + slutTid + "');";
				try {
					Statement utsagn = forbindelse.createStatement();
	        		utsagn.executeUpdate(sqlSetning);    
				}catch(Exception ex) {throw new Exception("Kan ikke legge til evaluering");}
				ResultSet eval = getEvalID(evuNavn);
				eval.next();
				int evalID = eval.getInt(1);
				String sqlSetning2 = "INSERT INTO tblsporsmal VALUES(NULL,'" + evalID + "','" + sporsmal + "');";
				try { 
					Statement utsagn = forbindelse.createStatement();
					utsagn.executeUpdate(sqlSetning2); 
				}catch(Exception ex) {throw new Exception("Kan ikke legge til sporsmal");}
				ResultSet spm = getSpmID(sporsmal);
				spm.next();
				int spmID = spm.getInt(1);
				int tellenull = 0;
				if(alt1 != null) {tellenull++;}
				if(alt2 != null) {tellenull++;}
				if(alt3 != null) {tellenull++;}
				if(alt4 != null) {tellenull++;}
				if(alt5 != null) {tellenull++;}
				int tall = 1;
				String alternativ = null;
				for(int i = 0; i<tellenull; i++) {
					if(i==0) {alternativ=alt1;}
					if(i==1) {alternativ=alt2;}
					if(i==2) {alternativ=alt3;}
					if(i==3) {alternativ=alt4;}
					if(i==4) {alternativ=alt5;}
					String sqlSetning3 = "INSERT INTO tblalternativ VALUES(NULL,'" + spmID + "','" + alternativ + "');";
					try { 
						Statement utsagn = forbindelse.createStatement();
						utsagn.executeUpdate(sqlSetning3); 
					}catch(Exception ex) {throw new Exception("Kan ikke legge til alternativ");}
					tall++;
					}
				//Vis antSp er 2 eller mer så registreres bare spørsmål og alternativer
			} else if (antsp>1) {
				ResultSet eval = getEvalID(evuNavn);
				eval.next();
				int evalID = eval.getInt(1);
				String sqlSetning = "INSERT INTO tblsporsmal VALUES(NULL,'" + evalID + "','" + sporsmal + "');";
				try {
					Statement utsagn = forbindelse.createStatement();
	        		utsagn.executeUpdate(sqlSetning);   
				}catch(Exception e){throw new Exception("kan ikke utføre spørringen");} //catch
				ResultSet spm = getSpmID(sporsmal);
				spm.next();
				int spmID = spm.getInt(1);
				int tellenull = 0;
				if(alt1 != null) {tellenull++;}
				if(alt2 != null) {tellenull++;}
				if(alt3 != null) {tellenull++;}
				if(alt4 != null) {tellenull++;}
				if(alt5 != null) {tellenull++;}
				int tall = 1;
				String alternativ = null;
				for(int i = 0; i<tellenull; i++) {
					if(i==0) {alternativ=alt1;}
					if(i==1) {alternativ=alt2;}
					if(i==2) {alternativ=alt3;}
					if(i==3) {alternativ=alt4;}
					if(i==4) {alternativ=alt5;}
					String sqlSetning3 = "INSERT INTO tblalternativ VALUES(NULL,'" + spmID + "','" + alternativ + "');";
					try { 
						Statement utsagn = forbindelse.createStatement();
						utsagn.executeUpdate(sqlSetning3); 
					}catch(Exception ex) {throw new Exception("Kan ikke legge til alternativ");}
					tall++;
					}
				
		}
		
	}




}
