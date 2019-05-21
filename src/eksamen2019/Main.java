package eksamen2019;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Main extends JFrame implements ActionListener {
	private Kontroll kontroll = Kontroll.getInstance();
	private DialogL�rer l�rer = new DialogL�rer(this);
	private DialogStudent student = new DialogStudent(this);
	JButton btnAvslutt, btnL�rer, btnStudent;
	
	public Main(String tittel) {
		super.setTitle(tittel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,5));
		
		btnL�rer = new JButton("L�rer");
		add(btnL�rer);
		btnL�rer.addActionListener(this);
		btnStudent = new JButton("Student");
		add(btnStudent);
		btnStudent.addActionListener(this);
		
		btnAvslutt = new JButton("Avslutt");
		add(btnAvslutt);
		btnAvslutt.addActionListener(this);
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String valg = e.getActionCommand();
		switch(valg) {
			case "L�rer" : DialogL�rer();
				break;
			case "Student" : DialogStudent();
				break;
			case "Avslutt" : System.exit(0);
		}		

	}

	private void DialogL�rer() {
		l�rer.setVisible(true);
		
	}

	private void DialogStudent() {
		student.setVisible(true);
		
	}

	public static void main(String[] args) {
		Main vinduet = new Main("Program");
		vinduet.setLocation(300, 300);
		vinduet.setVisible(true);

	}
	
}
