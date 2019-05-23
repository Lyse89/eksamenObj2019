package eksamen2019;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LærerGrensesnitt extends JDialog {
	private Kontroll kontroll = Kontroll.getInstance();
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldevalueringsnavn;
	private JTextField textFieldspørsmål;
	private JTextField textFieldsvar1;
	private JTextField textFieldsvar2;
	private JTextField textFieldsvar3;
	private JTextField textFieldsvar4;
	private JTextField textFieldsvar5;
	private JTable table;
	JComboBox comboBoxkursnavn = new JComboBox();
	private JTextField textField;
	private JTextField textField_1;

	// Test, fjern hvis det ikke fungerer
	private JPanel panel_1 = new RapporteringPanel();
	/*
	// For rapport-panel ----------------------------------------------------------
	private JTable table_1;
	private JTable table_2;

	private JComboBox evalComboBox = new JComboBox();
	// Brukes for JTable
	private final Object[][] defaulttabell = new Object[][] {{null,null,null,null},{null,null,null,null}};
	private final String[] kolonnenavn = {"OrdreNr","VNr","PrisPerEnhet","Antall"};
	*/
	// ----------------------------------------------------------------------------
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LærerGrensesnitt dialog = new LærerGrensesnitt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LærerGrensesnitt() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				try {
					laglistecombobox();
					//fyllCombobox();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 688, 711);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 672, 664);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ny Evaluering", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Oppretting av spørreundersøkelse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(24, 17, 622, 355);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblKursnavn = new JLabel("Kursnavn:");
		lblKursnavn.setBounds(10, 24, 165, 16);
		panel_2.add(lblKursnavn);
		
		
		
		comboBoxkursnavn.setBounds(217, 21, 393, 22);
		panel_2.add(comboBoxkursnavn);
		

		
		
		JLabel lblEvalueringsNavn = new JLabel("Evaluerings navn:");
		lblEvalueringsNavn.setBounds(10, 48, 165, 16);
		panel_2.add(lblEvalueringsNavn);
		
		textFieldevalueringsnavn = new JTextField();
		textFieldevalueringsnavn.setBounds(217, 48, 393, 22);
		panel_2.add(textFieldevalueringsnavn);
		textFieldevalueringsnavn.setColumns(10);
		
		JLabel lblspørsmål = new JLabel("Spørsmål:");
		lblspørsmål.setBounds(10, 122, 165, 16);
		panel_2.add(lblspørsmål);
		
		textFieldspørsmål = new JTextField();
		textFieldspørsmål.setBounds(217, 119, 393, 22);
		panel_2.add(textFieldspørsmål);
		textFieldspørsmål.setColumns(10);
		
		textFieldsvar1 = new JTextField();
		textFieldsvar1.setBounds(217, 145, 393, 22);
		panel_2.add(textFieldsvar1);
		textFieldsvar1.setColumns(10);
		
		JLabel lblsvar1 = new JLabel("Svaralternativ 1:");
		lblsvar1.setBounds(10, 148, 165, 16);
		panel_2.add(lblsvar1);
		
		textFieldsvar2 = new JTextField();
		textFieldsvar2.setBounds(217, 172, 393, 22);
		panel_2.add(textFieldsvar2);
		textFieldsvar2.setColumns(10);
		
		JLabel lblsvar2 = new JLabel("Svaralternativ 2:");
		lblsvar2.setBounds(10, 175, 165, 16);
		panel_2.add(lblsvar2);
		
		textFieldsvar3 = new JTextField();
		textFieldsvar3.setBounds(217, 199, 393, 22);
		panel_2.add(textFieldsvar3);
		textFieldsvar3.setColumns(10);
		
		JLabel lblsvar3 = new JLabel("Svaralternativ 3:");
		lblsvar3.setBounds(10, 202, 165, 16);
		panel_2.add(lblsvar3);
		
		JButton btnNesteSprml = new JButton("Neste spørsmål");
		btnNesteSprml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNesteSprml.setBounds(470, 292, 140, 23);
		panel_2.add(btnNesteSprml);
		
		JButton btnAvbryt = new JButton("Avbryt");
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAvbryt.setBounds(318, 292, 140, 23);
		panel_2.add(btnAvbryt);
		
		JLabel lblsvar4 = new JLabel("Svaralternativ 4:");
		lblsvar4.setBounds(10, 231, 165, 16);
		panel_2.add(lblsvar4);
		
		textFieldsvar4 = new JTextField();
		textFieldsvar4.setBounds(217, 228, 393, 22);
		panel_2.add(textFieldsvar4);
		textFieldsvar4.setColumns(10);
		
		JLabel lblsvar5 = new JLabel("Svaralternativ 5:");
		lblsvar5.setBounds(10, 260, 163, 16);
		panel_2.add(lblsvar5);
		
		textFieldsvar5 = new JTextField();
		textFieldsvar5.setBounds(217, 257, 393, 22);
		panel_2.add(textFieldsvar5);
		textFieldsvar5.setColumns(10);
		
		JLabel lblStartDato = new JLabel("Start og slutt dato:");
		lblStartDato.setBounds(10, 74, 119, 16);
		panel_2.add(lblStartDato);
		
		textField = new JTextField();
		textField.setBounds(217, 74, 192, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(421, 74, 189, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 437, 622, 151);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Spørsmål", "Svar 1", "Svar 2", "Svar 3"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblDineSprsmlS = new JLabel("Dine sp\u00F8rsm\u00E5l s\u00E5 langt:");
		lblDineSprsmlS.setBounds(24, 410, 137, 14);
		panel.add(lblDineSprsmlS);
		
		JButton btnLagSprreunderskelse = new JButton("Ferdig");
		btnLagSprreunderskelse.setBounds(460, 596, 186, 25);
		panel.add(btnLagSprreunderskelse);
		
		// Test av eksternt panel
		tabbedPane.addTab("Rapport", null, panel_1, null);

		
		/*
		// Panelet for rapportering -----------------------------------------------------------------------
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rapport", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblVelgEvaluering = new JLabel("Velg evaluering:");
		lblVelgEvaluering.setBounds(30, 40, 124, 15);
		panel_1.add(lblVelgEvaluering);
		
		// combobox
		evalComboBox.setBounds(164, 35, 349, 24);
		panel_1.add(evalComboBox);
		
		JButton btnVelg = new JButton("velg");
		btnVelg.setBounds(525, 35, 117, 25);
		panel_1.add(btnVelg);

		btnVelg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// henter valgt data i combobox
				String valgtEvaluering = (String)evalComboBox.getItemAt(evalComboBox.getSelectedIndex());

				// testprint
				System.out.println(valgtEvaluering);
				
				// Her kommer kall paa metode for henting av
				
				// antall svar per alternativ
				// hvem som har svart paa evalueringen
			}
		});
	
		table_1 = new JTable();
		table_1.setBounds(23, 98, 619, 173);
		panel_1.add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(23, 346, 242, 266);
		panel_1.add(table_2);
		
		JLabel lblFordelingAvSvar = new JLabel("Fordeling av svar");
		lblFordelingAvSvar.setBounds(35, 79, 177, 15);
		panel_1.add(lblFordelingAvSvar);
		
		JLabel lblStudenterSomHar = new JLabel("Studenter som har svart");
		lblStudenterSomHar.setBounds(30, 319, 201, 15);
		panel_1.add(lblStudenterSomHar);
		{

		}
		*/

		// ------------------------------------------------------------------------------------------------
		// eksempel fjern

			// hente ut valgt element fra combobox
			// String test23 = Arrays.toString((String[])evalComboBox.getSelectedItem());

			/* Eksempel henting av data til comboboxen
			*/

		// slutt eksempel ------------------------------------------------------------------------------------
	}
/*	
	private void fyllCombobox() throws Exception {
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
*/

	private Object laglistecombobox() throws Exception {
		ResultSet kurs = kontroll.hentKurs();
		try {
			while(kurs.next()) {
			String KursNavn = kurs.getString(1);
			comboBoxkursnavn.addItem(KursNavn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return kurs;
	}
	
	
	private void nyttSporsmal() throws Exception {
		String evuNavn = textFieldevalueringsnavn.getText();
		String sporsmal = textFieldspørsmål.getText();
		String alt1 = textFieldsvar1.getText();
		String alt2 = textFieldsvar2.getText();
		String alt3 = textFieldsvar3.getText();
		//Grensesnitt.regSpormal(evuNavn, sporsmal, alt1, alt2, alt3);
	}

	public static LærerGrensesnitt getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
