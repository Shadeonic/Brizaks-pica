import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
public class Pamatmape_frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	 // Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pamatmape_frame frame = new Pamatmape_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 // Create the frame.
	private ArrayList<Object> klienti;
	private ArrayList <Object> picas;
	public Pamatmape_frame() {
		setResizable(false);
		klienti = new ArrayList<Object>();
		picas = new ArrayList <Object>();
		klienti = Metodes.nolasitFailu(klienti, "Klienti.txt");
		picas = Metodes.nolasitFailu(picas, "gatvasPicas.txt");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pamatmape_frame.class.getResource("/pizza.png"))); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		ImageIcon fonsatt = new ImageIcon(Pamatmape_frame.class.getResource("/fons4.png"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton izvProf = new JButton("Izveidot profilu");
		izvProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pamatmape_frame.this.setVisible(false);
				klienti = Metodes.izvProfilu(klienti);
				Pamatmape_frame.this.setVisible(true);
			}
		});
		izvProf.setBounds(156, 48, 123, 23);
		contentPane.add(izvProf);
		
		JButton pieslegties = new JButton("Pieslēgties");
		pieslegties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pamatmape_frame.this.setVisible(false);

		        if (klienti.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Tu vēl neizveidoji profilu vai tas netika saglabāts", "Sistēmas paziņojums. Kļūda", JOptionPane.INFORMATION_MESSAGE);
		            Pamatmape_frame.this.setVisible(true);
		        } else {
		        	int klients = Metodes.Izvele(klienti,2);
					if(Metodes.ievadParoli(klients, klienti)) {
		            // Initialize and show the second GUI
		            izveles_logs izveles_logs = new izveles_logs(klients, klienti, picas);
		            izveles_logs.setVisible(true);

		            // Handle logout based on profile deletion
		            izveles_logs.addWindowListener(new java.awt.event.WindowAdapter() {
		                @Override
		                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
		                    if (izveles_logs.isUserLoggedOut()) {
		                        JOptionPane.showMessageDialog(null, "Veiksmīgi izrakstījies!", "Sistēmas paziņojums", JOptionPane.INFORMATION_MESSAGE);
		                        Pamatmape_frame.this.setVisible(true);
		                    } else {
//		                        Pamatmape_frame.this.setVisible(true);
		                    }
		                }
		            });
		        }
		        }
			}
		});
		pieslegties.setBounds(156, 101, 123, 23);
		contentPane.add(pieslegties);
		
		JButton aizvProg = new JButton("Beigt darbu");
		aizvProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pamatmape_frame.this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Sistēmas paziņojums. Informācija", JOptionPane.INFORMATION_MESSAGE);
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(aizvProg); 
		        if (currentFrame != null) {
		            currentFrame.dispose(); 
		        }
			}
		});
		aizvProg.setBounds(156, 158, 123, 23);
		contentPane.add(aizvProg);
		JLabel fonsLabel = new JLabel(fonsatt);
		fonsLabel.setBounds(-16, -39, fonsatt.getIconWidth(), fonsatt.getIconHeight());
		contentPane.add(fonsLabel);
	}

}
