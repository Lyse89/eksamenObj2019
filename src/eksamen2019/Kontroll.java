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
        	String sqlSetning = "SELECT evalNavn FROM kurs.tblevaluering";
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
    	}catch(Exception e) {try {
			throw new Exception("Finner ikke kurset");
		} catch (Exception e1) {
			e1.printStackTrace();
		}}
    	return resultat;
	}

	// metoder for rapport-jpanel-------------------------------------------------------------
	public ResultSet hentAntPerSvar(String evaluering) throws Exception {
		resultat = null;
		try {
				String sqlSporring = "";
				sqlSporring += "select tblsporsmal.spmTekst, tblalternativ.altTekst, count(tblsvar.svarAltID) as antallSvar ";
				sqlSporring += "from tblsporsmal inner join ";
				sqlSporring += "(";
				sqlSporring += "tblalternativ left join tblsvar ";
				sqlSporring += "on tblalternativ.altID = tblsvar.svarAltID ";
				sqlSporring += ") ";
				sqlSporring += "on tblsporsmal.spmID = tblalternativ.altSpmID ";
				sqlSporring += "group by tblalternativ.altTekst, tblsporsmal.spmTekst ";
				sqlSporring += "order by tblsporsmal.spmTekst;";
				
				utsagn = forbindelse.createStatement();
				resultat = utsagn.executeQuery(sqlSporring);
		} catch(Exception e){
				e.printStackTrace();
				throw new Exception("kan ikke utfore sporringen");
		}
		return resultat;        
	}
	
	public ResultSet hentRespondenter(String evaluering) throws Exception {
		resultat = null;
		try {
				String sqlSporring = "";
				sqlSporring += "select tblstudent.studNavn ";
				sqlSporring += "from tblstudent, tblsvar, tblalternativ, tblsporsmal, tblevaluering ";
				sqlSporring += "where tblstudent.studId = tblsvar.svarStudID ";
				sqlSporring += "and tblsvar.svarAltID = tblalternativ.altID ";
				sqlSporring += "and tblalternativ.altSpmID = tblsporsmal.spmID ";
				sqlSporring += "and tblsporsmal.spmEvalID = tblevaluering.evalID ";
				sqlSporring += "and tblevaluering.evalNavn = '" + evaluering + "';";

				utsagn = forbindelse.createStatement();
				resultat = utsagn.executeQuery(sqlSporring);
		} catch(Exception e){
				e.printStackTrace();
				throw new Exception("kan ikke utfore sporringen");
		}
		return resultat;        
	}
	public void slettEvalueringssvar(String evaluering) throws Exception {
		
		try {
			// Ingen vasking av escape chars
			String sqlSporring = "";
			sqlSporring += 
			sqlSporring += "delete from tblsvar ";
			sqlSporring += "where tblsvar.svarAltID in ";
			sqlSporring += "(select tblsvar.svarAltID ";
			sqlSporring += "from tblalternativ, tblsporsmal, tblevaluering ";
			sqlSporring += "where tblsvar.svarAltID = tblalternativ.altID ";
			sqlSporring += "and tblalternativ.altSpmID = tblsporsmal.spmID ";
			sqlSporring += "and tblsporsmal.spmEvalID = tblevaluering.evalID ";
			sqlSporring += "and tblevaluering.evalNavn = '" + evaluering + "');";

			utsagn = forbindelse.createStatement();
			utsagn.executeUpdate(sqlSporring);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception("Sletting av evalueringsdata mislyktes");
		}
	}

	// ---------------------------------------------------------------------------------------

}
