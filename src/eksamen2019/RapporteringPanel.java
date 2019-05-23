package eksamen2019;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class RapporteringPanel extends JPanel{
	private JTable table_1;
	private JTable table_2;

	private JComboBox evalComboBox = new JComboBox();
	// Brukes for JTable
	private final Object[][] defaulttabell = new Object[][] {{null,null,null,null},{null,null,null,null}};
	private final String[] kolonnenavn = {"OrdreNr","VNr","PrisPerEnhet","Antall"};


	public RapporteringPanel(){
		
		// Panelet for rapportering -----------------------------------------------------------------------
		setLayout(null);
		
		JLabel lblVelgEvaluering = new JLabel("Velg evaluering:");
		lblVelgEvaluering.setBounds(30, 40, 124, 15);
		add(lblVelgEvaluering);
		
		// combobox
		evalComboBox.setBounds(164, 35, 349, 24);
		add(evalComboBox);
		
		JButton btnVelg = new JButton("velg");
		btnVelg.setBounds(525, 35, 117, 25);
		add(btnVelg);

		btnVelg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// henter valgt data i combobox
				String valgtEvaluering = (String)evalComboBox.getItemAt(evalComboBox.getSelectedIndex());

				// testprint
				System.out.println(valgtEvaluering);
				
				// Her kommer kall paa metode for henting av
				
				// antall svar per alternativ
				// hvem som har svart paa evalueringen
			}
		});
	
		table_1 = new JTable();
		table_1.setBounds(23, 98, 619, 173);
		add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(23, 346, 242, 266);
		add(table_2);
		
		JLabel lblFordelingAvSvar = new JLabel("Fordeling av svar");
		lblFordelingAvSvar.setBounds(35, 79, 177, 15);
		add(lblFordelingAvSvar);
		
		JLabel lblStudenterSomHar = new JLabel("Studenter som har svart");
		lblStudenterSomHar.setBounds(30, 319, 201, 15);
		add(lblStudenterSomHar);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(405, 346, 117, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(405, 404, 117, 25);
		add(btnNewButton_1);
		{

		}
	}
}
