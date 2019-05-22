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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		lblKursnavn.setBounds(10, 21, 165, 16);
		panel_2.add(lblKursnavn);
		
		
		
		comboBoxkursnavn.setBounds(185, 18, 393, 22);
		panel_2.add(comboBoxkursnavn);
		

		
		
		JLabel lblEvalueringsNavn = new JLabel("Evaluerings navn:");
		lblEvalueringsNavn.setBounds(10, 48, 165, 16);
		panel_2.add(lblEvalueringsNavn);
		
		textFieldevalueringsnavn = new JTextField();
		textFieldevalueringsnavn.setBounds(185, 45, 393, 22);
		panel_2.add(textFieldevalueringsnavn);
		textFieldevalueringsnavn.setColumns(10);
		
		JLabel lblspørsmål = new JLabel("Spørsmål:");
		lblspørsmål.setBounds(10, 141, 165, 16);
		panel_2.add(lblspørsmål);
		
		textFieldspørsmål = new JTextField();
		textFieldspørsmål.setBounds(185, 138, 393, 22);
		panel_2.add(textFieldspørsmål);
		textFieldspørsmål.setColumns(10);
		
		textFieldsvar1 = new JTextField();
		textFieldsvar1.setBounds(185, 164, 393, 22);
		panel_2.add(textFieldsvar1);
		textFieldsvar1.setColumns(10);
		
		JLabel lblsvar1 = new JLabel("Svaralternativ 1:");
		lblsvar1.setBounds(10, 167, 165, 16);
		panel_2.add(lblsvar1);
		
		textFieldsvar2 = new JTextField();
		textFieldsvar2.setBounds(185, 191, 393, 22);
		panel_2.add(textFieldsvar2);
		textFieldsvar2.setColumns(10);
		
		JLabel lblsvar2 = new JLabel("Svaralternativ 2:");
		lblsvar2.setBounds(10, 194, 165, 16);
		panel_2.add(lblsvar2);
		
		textFieldsvar3 = new JTextField();
		textFieldsvar3.setBounds(185, 218, 393, 22);
		panel_2.add(textFieldsvar3);
		textFieldsvar3.setColumns(10);
		
		JLabel lblsvar3 = new JLabel("Svaralternativ 3:");
		lblsvar3.setBounds(10, 221, 165, 16);
		panel_2.add(lblsvar3);
		
		JButton btnNesteSprml = new JButton("Neste spørsmål");
		btnNesteSprml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNesteSprml.setBounds(438, 319, 140, 23);
		panel_2.add(btnNesteSprml);
		
		JButton btnAvbryt = new JButton("Avbryt");
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAvbryt.setBounds(286, 319, 140, 23);
		panel_2.add(btnAvbryt);
		
		JLabel lblsvar4 = new JLabel("Svaralternativ 4:");
		lblsvar4.setBounds(10, 250, 165, 16);
		panel_2.add(lblsvar4);
		
		textFieldsvar4 = new JTextField();
		textFieldsvar4.setBounds(185, 247, 393, 22);
		panel_2.add(textFieldsvar4);
		textFieldsvar4.setColumns(10);
		
		JLabel lblsvar5 = new JLabel("Svaralternativ 5:");
		lblsvar5.setBounds(12, 279, 163, 16);
		panel_2.add(lblsvar5);
		
		textFieldsvar5 = new JTextField();
		textFieldsvar5.setBounds(185, 276, 393, 22);
		panel_2.add(textFieldsvar5);
		textFieldsvar5.setColumns(10);
		
		JLabel lblStartDato = new JLabel("Start og slutt dato:");
		lblStartDato.setBounds(10, 80, 119, 16);
		panel_2.add(lblStartDato);
		
		textField = new JTextField();
		textField.setBounds(185, 77, 192, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(389, 77, 189, 22);
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
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rapport", null, panel_1, null);
		panel_1.setLayout(null);
		{

		}
	}
	
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
		Grensesnitt.regSpormal(evuNavn, sporsmal, alt1, alt2, alt3);
	}

	public static LærerGrensesnitt getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
