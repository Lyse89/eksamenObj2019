package eksamen2019;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grensesnitt extends JFrame {

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
		setBounds(100, 100, 552, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Hovedmenylærerknapp = new JButton("Lærer");
		Hovedmenylærerknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LærerGrensesnitt newWindow = new LærerGrensesnitt();
				newWindow.setVisible(true);
			}
		});
		Hovedmenylærerknapp.setBounds(92, 82, 353, 25);
		contentPane.add(Hovedmenylærerknapp);
		
		JButton Hovedmenystudentknapp = new JButton("Student");
		Hovedmenystudentknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGrensesnitt newWindow = new StudentGrensesnitt();
				newWindow.setVisible(true);
			}
		});
		Hovedmenystudentknapp.setBounds(92, 121, 353, 25);
		contentPane.add(Hovedmenystudentknapp);
		
		JButton Hovedmenyavsluttknapp = new JButton("Avslutt");
		Hovedmenyavsluttknapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Hovedmenyavsluttknapp.setBounds(221, 159, 97, 25);
		contentPane.add(Hovedmenyavsluttknapp);
	}
}
