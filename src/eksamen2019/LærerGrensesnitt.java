package eksamen2019;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class LærerGrensesnitt extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldevalueringsnavn;
	private JTextField textFieldspørsmål;
	private JTextField textFieldsvar1;
	private JTextField textFieldsvar2;
	private JTextField textFieldsvar3;

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
		setBounds(100, 100, 826, 621);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 808, 574);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ny Evaluering", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblKursnavn = new JLabel("Kursnavn:");
		lblKursnavn.setBounds(12, 13, 201, 16);
		panel.add(lblKursnavn);
		
		JComboBox comboBoxkursnavn = new JComboBox();
		comboBoxkursnavn.setBounds(225, 13, 259, 22);
		panel.add(comboBoxkursnavn);
		
		JLabel lblEvalueringsNavn = new JLabel("Evaluerings navn:");
		lblEvalueringsNavn.setBounds(12, 42, 201, 16);
		panel.add(lblEvalueringsNavn);
		
		textFieldevalueringsnavn = new JTextField();
		textFieldevalueringsnavn.setBounds(225, 42, 259, 22);
		panel.add(textFieldevalueringsnavn);
		textFieldevalueringsnavn.setColumns(10);
		
		JLabel lblspørsmål = new JLabel("Spørsmål:");
		lblspørsmål.setBounds(12, 71, 201, 16);
		panel.add(lblspørsmål);
		
		textFieldspørsmål = new JTextField();
		textFieldspørsmål.setBounds(225, 71, 259, 22);
		panel.add(textFieldspørsmål);
		textFieldspørsmål.setColumns(10);
		
		textFieldsvar1 = new JTextField();
		textFieldsvar1.setColumns(10);
		textFieldsvar1.setBounds(225, 103, 259, 22);
		panel.add(textFieldsvar1);
		
		JLabel lblsvar1 = new JLabel("Svaralternativ 1:");
		lblsvar1.setBounds(12, 103, 201, 16);
		panel.add(lblsvar1);
		
		textFieldsvar2 = new JTextField();
		textFieldsvar2.setColumns(10);
		textFieldsvar2.setBounds(225, 138, 259, 22);
		panel.add(textFieldsvar2);
		
		JLabel lblsvar2 = new JLabel("Svaralternativ 2:");
		lblsvar2.setBounds(12, 138, 201, 16);
		panel.add(lblsvar2);
		
		textFieldsvar3 = new JTextField();
		textFieldsvar3.setColumns(10);
		textFieldsvar3.setBounds(225, 173, 259, 22);
		panel.add(textFieldsvar3);
		
		JLabel lblsvar3 = new JLabel("Svaralternativ 3:");
		lblsvar3.setBounds(12, 173, 201, 16);
		panel.add(lblsvar3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rapport", null, panel_1, null);
		panel_1.setLayout(null);
		{

		}
	}
}
