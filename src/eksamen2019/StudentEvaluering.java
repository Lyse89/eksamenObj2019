package eksamen2019;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextField;


public class StudentEvaluering extends JDialog {
	private Kontroll kontroll = Kontroll.getInstance();
	private final JPanel contentPanel = new JPanel();
	JComboBox<String> Studentevalueringdropdown = new JComboBox<String>();
	List<String> alleSpørsmål = new ArrayList<>();
	List<List<String>> alleAlternativer = new ArrayList<>();
	JTextPane textPane = new JTextPane();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton radioButton = new JRadioButton("Svar alternativ 1");
	JRadioButton radioButton_1 = new JRadioButton("Svar alternativ 2");
	JRadioButton radioButton_2 = new JRadioButton("Svar alternativ 3");
	JRadioButton radioButton_3 = new JRadioButton("Svar alternativ 4");
	JRadioButton radioButton_4 = new JRadioButton("Svar alternativ 5");
	int teller = 1;
	private final JLabel lblDinId = new JLabel("Din ID:");
	private JTextField textFieldID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentEvaluering dialog = new StudentEvaluering();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentEvaluering() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				try {
					laglistecombobox();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setBounds(100, 100, 497, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Valg av spørreskjema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 13, 463, 102);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblEvalueringsnavn = new JLabel("Evalueringsnavn:");
			lblEvalueringsnavn.setBounds(6, 19, 118, 16);
			panel.add(lblEvalueringsnavn);
		}
		

		Studentevalueringdropdown.setBounds(136, 16, 315, 22);
		panel.add(Studentevalueringdropdown);
		
		JButton startevalueringbutton = new JButton("Start");
		startevalueringbutton.setBounds(354, 65, 97, 25);
		panel.add(startevalueringbutton);
		lblDinId.setBounds(6, 48, 56, 16);
		
		panel.add(lblDinId);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(136, 45, 68, 22);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		startevalueringbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fyllSpørsmål();
					fyllAlternativer();
					startevalueringbutton.setEnabled(false);
			        
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Spørreskjema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(4, 140, 463, 259);
		contentPanel.add(panel_1);
		
		JLabel label = new JLabel("Sp\u00F8rsm\u00E5l:");
		label.setBounds(10, 21, 394, 24);
		panel_1.add(label);
		
		
		textPane.setBounds(82, 21, 322, 24);
		panel_1.add(textPane);
		
		
		buttonGroup.add(radioButton);
		radioButton.setBounds(79, 52, 127, 25);
		panel_1.add(radioButton);
		

		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(79, 80, 127, 25);
		panel_1.add(radioButton_1);
		

		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(79, 108, 127, 25);
		panel_1.add(radioButton_2);
		
		JButton button_1 = new JButton("Neste Sp\u00F8rsm\u00E5l");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					regSvar();
					nesteSpørsmål();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(324, 221, 127, 25);
		panel_1.add(button_1);
		

		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(79, 138, 127, 25);
		panel_1.add(radioButton_3);
		

		buttonGroup.add(radioButton_4);
		radioButton_4.setBounds(79, 168, 127, 25);
		panel_1.add(radioButton_4);
		
		JButton btnFerdig = new JButton("Ferdig");
		btnFerdig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					startevalueringbutton.setEnabled(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFerdig.setBounds(358, 412, 97, 25);
		contentPanel.add(btnFerdig);
		
		JButton button = new JButton("Avbryt");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(215, 221, 97, 25);
		panel_1.add(button);
	}
	
	public Object laglistecombobox() throws Exception {
		ResultSet evaluering = kontroll.hentEvaluering();
		try {
			while(evaluering.next()) {
			String EvalueringsNavn = evaluering.getString(1);
			Studentevalueringdropdown.addItem(EvalueringsNavn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return evaluering;
	}
	
	
	
	
	
	
	
	
	// For å få spørsmål fra DB og fylle det in I øverste TextPanen
	public Object fyllSpørsmål() throws Exception {
		String valgtSpørreSkjema = (String) Studentevalueringdropdown.getSelectedItem();
		ResultSet sporsmal = kontroll.hentSpørsmål(valgtSpørreSkjema);
		
		// While som leser alle spørsmålene for en spørreundersøkelse
		while (sporsmal.next()) {
			// Gjør om spørsmålet til String op legger det i en arraylist
			String sporsmal1 = sporsmal.getString(1);
			alleSpørsmål.add(sporsmal1);
		}
		return sporsmal;
	}
	
	// For å få alle alternativene til spørsmålene fra DB og fylle i RadioBoxes
	public Object fyllAlternativer() throws Exception {
		String valgtSpørreSkjema = (String) Studentevalueringdropdown.getSelectedItem();
		ResultSet sporsmal = kontroll.hentSpørsmål(valgtSpørreSkjema);
		
		
		// While løkke som leser alle alternativene tilhørende spørsmål. Legger spørsmålet i en arraylist også
		while (sporsmal.next()) {
			List<String> alleAlternativertemp = new ArrayList<>();
			String sporsmal1 = sporsmal.getString(1);
			ResultSet SvarAlternativ = kontroll.hentAlternativer(sporsmal1);
			//alleAlternativer.add(sporsmal1);
			
			// While inne I while for å legge alternativene til hvert spørsmål i en Arraylist
			while (SvarAlternativ.next()) {
				String SvarAlternativ1 = SvarAlternativ.getString(1);
				alleAlternativertemp.add(SvarAlternativ1);
				
				}
			alleAlternativer.add(alleAlternativertemp);
		
		}
		
		
		Fyllalternativer(0);
		
		return sporsmal;
	}
	
	public void Fyllalternativer(int spørsmål) {
		for(int i = 0; i < alleAlternativer.size(); i++) {
			String alternativ1x = alleAlternativer.get(spørsmål).get(i);
		}
		textPane.setText(alleSpørsmål.get(spørsmål));
		
		radioButton.setText(alleAlternativer.get(spørsmål).get(0));
		radioButton_1.setText(alleAlternativer.get(spørsmål).get(1));
		if(alleAlternativer.get(spørsmål).size() >= 3) {
			radioButton_2.setText(alleAlternativer.get(spørsmål).get(2));
		}else {
			radioButton_2.setText("");
		}
		
		if(alleAlternativer.get(spørsmål).size() >= 4) {
			radioButton_3.setText(alleAlternativer.get(spørsmål).get(3));
		}else {
			radioButton_3.setText("");
		}
		
		if(alleAlternativer.get(spørsmål).size() >= 5) {
			radioButton_4.setText(alleAlternativer.get(spørsmål).get(4));
		}else {
			radioButton_4.setText("");
		}
	}
	
	// Neste spørsmål knapp, Legger inn nytt spørsmål i TextPane
	public void nesteSpørsmål() {
		if (teller < alleSpørsmål.size()) {
			Fyllalternativer(teller++);
		}else {
			JOptionPane.showMessageDialog(null, "Ingen flere spørsmål");
		}
	}
	
	
	
	
	public void regSvar() throws Exception {
		String radiotekst = "";
		if(radioButton.isSelected()) {
			radiotekst = radioButton.getText();
		}
		if(radioButton_1.isSelected()) {
			radiotekst = radioButton_1.getText();
		}
		if(radioButton_2.isSelected()) {
			radiotekst = radioButton_2.getText();
		}
		if(radioButton_3.isSelected()) {
			radiotekst = radioButton_3.getText();
		}
		if(radioButton_4.isSelected()) {
			radiotekst = radioButton_4.getText();
		}
		
		
		ResultSet AltID = kontroll.hentAlternativerID(radiotekst);
		AltID.next();
		String Altidentitet = AltID.getString(1);
		String studentID = textFieldID.getText();
		kontroll.ferdigSvar(studentID, Altidentitet);
	
	}
}