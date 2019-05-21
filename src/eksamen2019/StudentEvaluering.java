package eksamen2019;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class StudentEvaluering extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 450, 181);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Valg av spørreskjema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 13, 420, 101);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblEvalueringsnavn = new JLabel("Evalueringsnavn:");
			lblEvalueringsnavn.setBounds(6, 19, 118, 16);
			panel.add(lblEvalueringsnavn);
		}
		
		JComboBox Studentevalueringdropdown = new JComboBox();
		Studentevalueringdropdown.setBounds(136, 16, 278, 22);
		panel.add(Studentevalueringdropdown);
		
		JButton startevalueringbutton = new JButton("Start");
		startevalueringbutton.setBounds(317, 65, 97, 25);
		panel.add(startevalueringbutton);
		startevalueringbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEvalueringStartet newWindow = new StudentEvalueringStartet();
				newWindow.setVisible(true);
				dispose();
			}
		});
		
		JButton StudentEvalueringTilbakeKnapp = new JButton("Tilbake");
		StudentEvalueringTilbakeKnapp.setBounds(207, 65, 97, 25);
		panel.add(StudentEvalueringTilbakeKnapp);
		StudentEvalueringTilbakeKnapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
