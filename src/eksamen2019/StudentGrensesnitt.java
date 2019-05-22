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
import javax.swing.border.TitledBorder;

public class StudentGrensesnitt extends JDialog {
	private Kontroll kontroll = Kontroll.getInstance();
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
		setBounds(100, 100, 426, 181);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Innlogging", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 380, 112);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBrukernavn = new JLabel("Brukernavn:");
		lblBrukernavn.setBounds(6, 19, 139, 16);
		panel.add(lblBrukernavn);
		
		JLabel lblPassord = new JLabel("Passord:");
		lblPassord.setBounds(6, 48, 139, 16);
		panel.add(lblPassord);
		
		Brukernavnlogintextfield = new JTextField();
		Brukernavnlogintextfield.setBounds(157, 16, 217, 22);
		panel.add(Brukernavnlogintextfield);
		Brukernavnlogintextfield.setColumns(10);
		
		Passordlogintextfield = new JTextField();
		Passordlogintextfield.setBounds(157, 45, 217, 22);
		panel.add(Passordlogintextfield);
		Passordlogintextfield.setColumns(10);
		
		
		JButton Loginknapp = new JButton("Login");
		Loginknapp.setBounds(277, 80, 97, 25);
		panel.add(Loginknapp);
		Loginknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEvaluering newWindow = new StudentEvaluering();
				newWindow.setVisible(true);
				dispose();
			}
		});
		
		JButton logintilbakeknapp = new JButton("Tilbake");
		logintilbakeknapp.setBounds(157, 80, 97, 25);
		panel.add(logintilbakeknapp);
		logintilbakeknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		{

		}
	}
}
