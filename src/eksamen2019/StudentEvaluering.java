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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class StudentEvaluering extends JDialog {
	private Kontroll kontroll = Kontroll.getInstance();
	private final JPanel contentPanel = new JPanel();
	JComboBox<String> Studentevalueringdropdown = new JComboBox<String>();
	public String valgtSpørreSkjema = (String) Studentevalueringdropdown.getSelectedItem();

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
		
		// Dropdown meny 
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
	
	private Object laglistecombobox() throws Exception {
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
	

}
