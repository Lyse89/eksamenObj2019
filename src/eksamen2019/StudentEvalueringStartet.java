package eksamen2019;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StudentEvalueringStartet extends JDialog {
	private Kontroll kontroll = Kontroll.getInstance();
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextPane textPane = new JTextPane();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentEvalueringStartet dialog = new StudentEvalueringStartet();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentEvalueringStartet() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				try {
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		setBounds(100, 100, 450, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Spørreskjema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 420, 259);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		textPane.setBounds(82, 21, 322, 24);
		panel.add(textPane);
		
		JLabel lblSprsml = new JLabel("Sp\u00F8rsm\u00E5l:");
		lblSprsml.setBounds(10, 21, 394, 24);
		panel.add(lblSprsml);
		
		JRadioButton radioButtonsvar1 = new JRadioButton("Svar alternativ 1");
		buttonGroup.add(radioButtonsvar1);
		radioButtonsvar1.setBounds(79, 52, 127, 25);
		panel.add(radioButtonsvar1);
		
		JRadioButton radioButtonsvar2 = new JRadioButton("Svar alternativ 2");
		buttonGroup.add(radioButtonsvar2);
		radioButtonsvar2.setBounds(79, 80, 127, 25);
		panel.add(radioButtonsvar2);
		
		JRadioButton radioButtonsvar3 = new JRadioButton("Svar alternativ 3");
		buttonGroup.add(radioButtonsvar3);
		radioButtonsvar3.setBounds(79, 108, 127, 25);
		panel.add(radioButtonsvar3);
		
		JButton btnAvbryt = new JButton("Avbryt");
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAvbryt.setBounds(307, 221, 97, 25);
		panel.add(btnAvbryt);
		
		JButton btnNesteSprsml = new JButton("Neste Sp\u00F8rsm\u00E5l");
		btnNesteSprsml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fyllSporsmal();
			}
		});
		btnNesteSprsml.setBounds(170, 221, 127, 25);
		panel.add(btnNesteSprsml);
		
		JRadioButton rdbtnSvarAlternativ = new JRadioButton("Svar alternativ 4");
		buttonGroup.add(rdbtnSvarAlternativ);
		rdbtnSvarAlternativ.setBounds(79, 138, 127, 25);
		panel.add(rdbtnSvarAlternativ);
		
		JRadioButton rdbtnSvarAlternativ_1 = new JRadioButton("Svar alternativ 5");
		buttonGroup.add(rdbtnSvarAlternativ_1);
		rdbtnSvarAlternativ_1.setBounds(79, 168, 127, 25);
		panel.add(rdbtnSvarAlternativ_1);

	}
	
	public ResultSet fyllSporsmal(String valgtSpørreSkjema) throws Exception {
		ResultSet sporsmal = kontroll.hentSpørsmål(valgtSpørreSkjema);
		textPane.setText(textPane.getText() + "HEY");
		return sporsmal;
	}
}
