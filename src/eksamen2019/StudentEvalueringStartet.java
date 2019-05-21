package eksamen2019;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class StudentEvalueringStartet extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(127, 29, 293, 24);
		contentPanel.add(textPane);
		
		JLabel lblSprsml = new JLabel("Sp\u00F8rsm\u00E5l:");
		lblSprsml.setBounds(12, 29, 79, 24);
		contentPanel.add(lblSprsml);
		
		JRadioButton radioButton = new JRadioButton("Svar alternativ 1");
		radioButton.setBounds(12, 72, 127, 25);
		contentPanel.add(radioButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Svar alternativ 2");
		rdbtnNewRadioButton.setBounds(12, 102, 127, 25); 
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Svar alternativ 3");
		rdbtnNewRadioButton_1.setBounds(12, 132, 127, 25);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		JButton btnAvbryt = new JButton("Avbryt");
		btnAvbryt.setBounds(323, 215, 97, 25);
		contentPanel.add(btnAvbryt);
		
		JButton btnNesteSprsml = new JButton("Neste Sp\u00F8rsm\u00E5l");
		btnNesteSprsml.setBounds(12, 166, 127, 25);
		contentPanel.add(btnNesteSprsml);

	}
}
