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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEvalueringsnavn = new JLabel("Evalueringsnavn:");
			lblEvalueringsnavn.setBounds(12, 71, 118, 16);
			contentPanel.add(lblEvalueringsnavn);
		}
		
		JComboBox Studentevalueringdropdown = new JComboBox();
		Studentevalueringdropdown.setBounds(142, 68, 278, 22);
		contentPanel.add(Studentevalueringdropdown);
		
		JButton startevalueringbutton = new JButton("Start");
		startevalueringbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEvalueringStartet newWindow = new StudentEvalueringStartet();
				newWindow.setVisible(true);
			}
		});
		startevalueringbutton.setBounds(323, 103, 97, 25);
		contentPanel.add(startevalueringbutton);
		
		JLabel LabelStudentEvaluering = new JLabel("Utf\u00F8r en evaluering");
		LabelStudentEvaluering.setFont(new Font("Tahoma", Font.PLAIN, 23));
		LabelStudentEvaluering.setBounds(12, 13, 408, 25);
		contentPanel.add(LabelStudentEvaluering);
		
		JButton StudentEvalueringTilbakeKnapp = new JButton("Tilbake");
		StudentEvalueringTilbakeKnapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		StudentEvalueringTilbakeKnapp.setBounds(214, 103, 97, 25);
		contentPanel.add(StudentEvalueringTilbakeKnapp);
	}
}
