package eksamen2019;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LærerGrensesnitt extends JDialog  {
	private Kontroll kontroll = Kontroll.getInstance();
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldevalueringsnavn;
	private JTextField textFieldsporsmal;
	private JTextField textFieldsvar1;
	private JTextField textFieldsvar2;
	private JTextField textFieldsvar3;
	private JTextField textFieldsvar4;
	private JTextField textFieldsvar5;
	JComboBox<String> comboBoxkursnavn = new JComboBox<String>();
	private JTextField textField;
	private JTextField textField_1;
	DefaultTableModel innhold;
	JTable sporetabell;
	JScrollPane sporerulling;
	private final String[] kolonnenavn = {"Sporsmåll:","Alternativ 1:","Alternativ 2","Alternativ 3","Alternativ 4","Alternativ 5"};
	private final Object[][] defaulttable = new Object[][] {{},{}};
	int antsp = 0;
	int rader = 0;

	

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
		
		textFieldsporsmal = new JTextField();
		textFieldsporsmal.setBounds(217, 119, 393, 22);
		panel_2.add(textFieldsporsmal);
		textFieldsporsmal.setColumns(10);
		
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
		
		JButton btnNesteSprml = new JButton("Lagre spørsmål");
		btnNesteSprml.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					nyttSporsmal();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
		
		innhold = new DefaultTableModel(defaulttable, kolonnenavn);
		sporetabell = new JTable(innhold);
		sporerulling = new JScrollPane(sporetabell);
		scrollPane.setViewportView(sporetabell);
		
		JLabel lblDineSprsmlS = new JLabel("Dine sp\u00F8rsm\u00E5l s\u00E5 langt:");
		lblDineSprsmlS.setBounds(24, 410, 137, 14);
		panel.add(lblDineSprsmlS);
		
		JButton btnLagSprreunderskelse = new JButton("Ferdig");
		btnLagSprreunderskelse.setBounds(460, 596, 186, 25);
		panel.add(btnLagSprreunderskelse);
		btnLagSprreunderskelse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tømAlt();
			}

			private void tømAlt() {
				textFieldevalueringsnavn.setText("");
				textFieldsporsmal.setText("");
				textField.setText("");
				textField_1.setText("");
				textFieldsporsmal.setText("");
				textFieldsvar1.setText("");
				textFieldsvar2.setText("");
				textFieldsvar3.setText("");
				textFieldsvar4.setText("");
				textFieldsvar5.setText("");
				innhold.setRowCount(0);
				antsp = 0;
				rader = 0;
			} 
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rapport", null, panel_1, null);
		panel_1.setLayout(null);
	
	}
	
	private ResultSet laglistecombobox() throws Exception {
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
		++antsp;
		String kurset = (String)comboBoxkursnavn.getItemAt(comboBoxkursnavn.getSelectedIndex());
		String evuNavn = textFieldevalueringsnavn.getText();
		String sporsmal = textFieldsporsmal.getText();
		String startTid = textField.getText();
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
		java.time.LocalDate startTidSQL = java.time.LocalDate.parse(startTid, formatter);
		java.sql.Date sqlDateStart = java.sql.Date.valueOf(startTidSQL);
		String slutTid = textField_1.getText();
		java.time.LocalDate slutTidSQL = java.time.LocalDate.parse(slutTid, formatter);
		java.sql.Date sqlDateSlut = java.sql.Date.valueOf(slutTidSQL);
		String alt1 = textFieldsvar1.getText();
		if (textFieldsvar1.getText().trim().isEmpty()) {
		    alt1 = null;
		}
		String alt2 = textFieldsvar2.getText();
		if (textFieldsvar2.getText().trim().isEmpty()) {
		    alt2 = null;
		}
		String alt3 = textFieldsvar3.getText();
		if (textFieldsvar3.getText().trim().isEmpty()) {
		    alt3 = null;
		}
		String alt4 = textFieldsvar4.getText();
		if (textFieldsvar4.getText().trim().isEmpty()) {
		    alt4 = null;
		}
		String alt5 = textFieldsvar5.getText();
		if (textFieldsvar5.getText().trim().isEmpty()) {
		    alt5 = null;
		}
		kontroll.nyttSporsmal(antsp, kurset, evuNavn, sporsmal, sqlDateStart, sqlDateSlut, alt1, alt2, alt3, alt4, alt5);
		
		Object[] rad = {sporsmal, alt1, alt2, alt3, alt4, alt5};
		
		innhold.insertRow(rader, rad);
		rader++;
		tømFelt();
	}
	


	private void tømFelt() {
		textFieldsporsmal.setText("");
		textFieldsvar1.setText("");
		textFieldsvar2.setText("");
		textFieldsvar3.setText("");
		textFieldsvar4.setText("");
		textFieldsvar5.setText("");
		
	}
	
}
