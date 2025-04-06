import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
public class picas_izveide extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 // Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					picas_izveide frame = new picas_izveide();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 // Create the frame.
	public picas_izveide() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pamatmape_frame.class.getResource("/pizza.png"))); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		ImageIcon fonsatt = new ImageIcon(Pamatmape_frame.class.getResource("/fons4.png"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Sēņu pica");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(42, 54, 89, 23);
		contentPane.add(button);
		
		JButton button2 = new JButton("Margarita");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button2.setBounds(176, 54, 89, 23);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Četri sieri");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button3.setBounds(305, 54, 89, 23);
		contentPane.add(button3);
		
		JButton button4 = new JButton("Čempionu");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		button4.setBounds(42, 131, 89, 23);
		contentPane.add(button4);
		
		JButton button5 = new JButton("Pepperoni");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button5.setBounds(176, 131, 89, 23);
		contentPane.add(button5);
		
		JButton button6 = new JButton("Studentu");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button6.setBounds(305, 131, 89, 23);
		contentPane.add(button6);
		
		JButton button7 = new JButton("Sava pica");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button7.setBounds(112, 190, 89, 23);
		contentPane.add(button7);
		
		JButton button8 = new JButton("Atpakaļ");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button8.setBounds(240, 190, 89, 23);
		contentPane.add(button8);
		JLabel fonsLabel = new JLabel(fonsatt);
		fonsLabel.setBounds(-16, -39, fonsatt.getIconWidth(), fonsatt.getIconHeight());
		contentPane.add(fonsLabel);
	}
}
