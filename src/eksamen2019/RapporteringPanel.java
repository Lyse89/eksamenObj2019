package eksamen2019;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import innUt.InnUt;

public class RapporteringPanel extends JPanel{
	private Kontroll kontroll = Kontroll.getInstance();
	private JComboBox evalComboBox = new JComboBox();

	private JTable table_1;
	private JTable table_2;

	private final Object[][] defaulttabell = new Object[][] {{null,null,null},{null,null,null}};
	private final String[] kolonnenavn = {"Spørsmål","Alternativ","Antall"};
	private final Object[][] defaulttabell2 = new Object[][] {{null},{null}};
	private final String[] kolonnenavn2 = {"Navn"};

	private String valgtEvaluering;
	public RapporteringPanel(){
		
		// Panelet for rapportering -----------------------------------------------------------------------
		setLayout(null);
		
		JLabel lblVelgEvaluering = new JLabel("Velg evaluering:");
		lblVelgEvaluering.setBounds(30, 40, 124, 15);
		add(lblVelgEvaluering);
		
		// combobox
		evalComboBox.setBounds(164, 35, 349, 24);
		add(evalComboBox);
		
		JButton btnVelg = new JButton("velg");
		btnVelg.setBounds(525, 35, 117, 25);
		add(btnVelg);

		btnVelg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// henter valgt data i combobox
				valgtEvaluering = (String)evalComboBox.getItemAt(evalComboBox.getSelectedIndex());

				// Her kommer kall paa metode for henting av statistikk
				try {
					// antall svar per alternativ
					fyllTabeller(valgtEvaluering);
					// ResultSet antPerSvar = kontroll.hentAntPerSvar(valgtEvaluering);
					// hvem som har svart paa evalueringen
					// ResultSet respondenter = kontroll.hentRespondenter(valgtEvaluering);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 98, 619, 164);
		add(scrollPane);
	
		table_1 = new JTable();
		//table_1.setModel(new DefaultTableModel(defaulttabell, kolonnenavn));
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {"Sporsmal", "Alternativ", "Antall"}
		));
		
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 346, 242, 260);
		add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Navn"
			}
		));
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblFordelingAvSvar = new JLabel("Fordeling av svar");
		lblFordelingAvSvar.setBounds(35, 79, 177, 15);
		add(lblFordelingAvSvar);
		
		JLabel lblStudenterSomHar = new JLabel("Studenter som har svart");
		lblStudenterSomHar.setBounds(30, 319, 201, 15);
		add(lblStudenterSomHar);
		
		JButton eksportKnapp = new JButton("Eksporter");
		eksportKnapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valgtEvaluering = (String)evalComboBox.getItemAt(evalComboBox.getSelectedIndex());
				// hent data fra JTable
				lagRapport(valgtEvaluering);
			}
		});
		eksportKnapp.setBounds(346, 342, 117, 25);
		add(eksportKnapp);
		
		JButton slettEvalueringKnapp = new JButton("Slett data");
		slettEvalueringKnapp.setBounds(525, 342, 117, 25);
		slettEvalueringKnapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valgtEvaluering = (String)evalComboBox.getItemAt(evalComboBox.getSelectedIndex());
				try {
					kontroll.slettEvalueringssvar(valgtEvaluering);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		add(slettEvalueringKnapp);
		{

		}
	}
	public void fyllCombobox() throws Exception {
		// henter info fra databasen
		ResultSet evaluering = kontroll.hentEvaluering();
		try {
			while(evaluering.next()) {
			String EvalueringsNavn = evaluering.getString(1);
			// Legger til verdien i comboboxen
			evalComboBox.addItem(EvalueringsNavn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object[][] listeAntPerSvar(String evaluering) throws Exception {

		Object[][] innhold = null;
		int teller = 0;
		try {
			ResultSet liste = kontroll.hentAntPerSvar(evaluering);
			//ResultSet liste = kontroll.hentOrdre(ordrenr);

			liste.last();                         // record pointer is placed on the last row
			int counter = liste.getRow();
			liste.beforeFirst();
			innhold = new Object[counter][6];
			while(liste.next()) {
			   String sporsmal = liste.getString(1);
			   String alternativ = liste.getString(2);
			   String antall = liste.getString(3);

			   innhold[teller][0] = sporsmal;
			   innhold[teller][1] = alternativ;
			   innhold[teller][2] = antall;
			   setVisible(true);
			   teller++;
			}
		}catch(Exception e){JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell 222");e.printStackTrace();}
		return innhold;
	} //metode

	public void fyllAntPerSvarTabell(String evaluering) throws Exception{

		Object[][] liste = listeAntPerSvar(evaluering);
		table_1.setModel(new DefaultTableModel(liste,kolonnenavn));
	}
	private void fyllRespondenterTabell(String evaluering) throws Exception {
		Object[][] liste = listeRespondenter(evaluering);
		// kolonnenavn maa endres
		table_2.setModel(new DefaultTableModel(liste,kolonnenavn2));
		
	}
	private void fyllTabeller(String evaluering) throws Exception {
		fyllAntPerSvarTabell(evaluering);
		fyllRespondenterTabell(evaluering);
		
	}

	// metoder for fylling av tabel_2
	public Object[][] listeRespondenter(String evaluering) throws Exception {

		Object[][] innhold = null;
		int teller = 0;
		try {
			ResultSet liste = kontroll.hentRespondenter(evaluering);

			// pointer er plasser paa siste rad
			liste.last(); 
			// finner antall rader
			int counter = liste.getRow(); 
			// Setter pointeren tilbake til forste
			liste.beforeFirst();

			innhold = new Object[counter][1];
			while(liste.next()) {
			   String navn = liste.getString(1);

			   innhold[teller][0] = navn;
			   setVisible(true);
			   teller++;
			}
		}catch(Exception e){JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell 222");e.printStackTrace();}
		return innhold;
	} //metode
	
	public void lagRapport(String evaluering) {
		String pattern = "MMddyyyy-HHmm";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();
		String dag = df.format(today);
		dag = dag.trim();
		String rapportnavn = "rapporter/eval" + dag + ".csv";

		//String tid =(String)java.time.LocalDate.now();
		String rad;
		try {
			PrintWriter utfil = InnUt.lagSkriveForbindelse(rapportnavn);

			ResultSet liste = kontroll.hentAntPerSvar(evaluering);
			//ResultSet liste = kontroll.hentOrdre(ordrenr);
			while(liste.next()) {
			   String sporsmal = liste.getString(1);
			   String alternativ = liste.getString(2);
			   String antall = liste.getString(3);
			   rad = sporsmal + ", " + alternativ + ", " + antall;

			   utfil.println(rad);
			}
			utfil.close();
		}catch(Exception e){JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell 222");e.printStackTrace();}
	}
}
