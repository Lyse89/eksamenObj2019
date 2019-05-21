package eksamen2019;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentGrensesnitt extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Brukernavnlogintextfield;
	private JTextField Passordlogintextfield;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentGrensesnitt dialog = new StudentGrensesnitt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StudentGrensesnitt() {
		setBounds(100, 100, 450, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBrukernavn = new JLabel("Brukernavn:");
		lblBrukernavn.setBounds(12, 68, 139, 16);
		contentPanel.add(lblBrukernavn);
		
		JLabel lblPassord = new JLabel("Passord:");
		lblPassord.setBounds(12, 97, 139, 16);
		contentPanel.add(lblPassord);
		
		Brukernavnlogintextfield = new JTextField();
		Brukernavnlogintextfield.setBounds(163, 65, 217, 22);
		contentPanel.add(Brukernavnlogintextfield);
		Brukernavnlogintextfield.setColumns(10);
		
		Passordlogintextfield = new JTextField();
		Passordlogintextfield.setBounds(163, 94, 217, 22);
		contentPanel.add(Passordlogintextfield);
		Passordlogintextfield.setColumns(10);
		
		
		JButton Loginknapp = new JButton("Login");
		Loginknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEvaluering newWindow = new StudentEvaluering();
				newWindow.setVisible(true);
			}
		});
		Loginknapp.setBounds(283, 129, 97, 25);
		contentPanel.add(Loginknapp);
		
		JButton logintilbakeknapp = new JButton("Tilbake");
		logintilbakeknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logintilbakeknapp.setBounds(163, 129, 97, 25);
		contentPanel.add(logintilbakeknapp);
		
		JLabel lblLoggInnMed = new JLabel("Logg inn med brukernavn og passord");
		lblLoggInnMed.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLoggInnMed.setBounds(12, 13, 394, 39);
		contentPanel.add(lblLoggInnMed);
		{

		}
	}
}
