package eksamen2019;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Grensesnitt extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Kontroll kontroll = Kontroll.getInstance();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grensesnitt frame = new Grensesnitt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grensesnitt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Hovedmenylærerknapp = new JButton("Lærer");
		Hovedmenylærerknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					kontroll.kobleTil();
					JOptionPane.showMessageDialog(null, "Database forbindelse oprettet");
					LærerGrensesnitt newWindow = new LærerGrensesnitt();
					newWindow.setVisible(true);
					
				}catch (Exception e1) {JOptionPane.showMessageDialog(null, e1.getMessage());}
			}
		});
		Hovedmenylærerknapp.setBounds(83, 56, 353, 25);
		contentPane.add(Hovedmenylærerknapp);
		
		JButton Hovedmenystudentknapp = new JButton("Student");
		Hovedmenystudentknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					kontroll.kobleTil();
					JOptionPane.showMessageDialog(null, "Database forbindelse oprettet");
					StudentGrensesnitt newWindow = new StudentGrensesnitt();
					newWindow.setVisible(true);
				}catch (Exception e1) {JOptionPane.showMessageDialog(null, e1.getMessage());}
			}
		});
		Hovedmenystudentknapp.setBounds(83, 95, 353, 25);
		contentPane.add(Hovedmenystudentknapp);
		
		JButton Hovedmenyavsluttknapp = new JButton("Avslutt");
		Hovedmenyavsluttknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Hovedmenyavsluttknapp.setBounds(212, 133, 97, 25);
		contentPane.add(Hovedmenyavsluttknapp);
		
		JLabel lblEvalueringAvKurs = new JLabel("Evaluering av kurs");
		lblEvalueringAvKurs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEvalueringAvKurs.setBounds(185, 11, 173, 34);
		contentPane.add(lblEvalueringAvKurs);
	}

	public static void regSpormal(String evuNavn, String sporsmal, String alt1, String alt2, String alt3) {
		// TODO Auto-generated method stub
		
	}
	
}
