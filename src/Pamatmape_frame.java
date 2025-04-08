import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
		klienti = Metodes.nolasitFailu(klienti);
		
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
				if(klienti.size()==0) 
					JOptionPane.showMessageDialog(null, "Tu vēl neizveidoju profilu vai tas netika saglabāts", "Sistēmas paziņojums. Kļūda", JOptionPane.INFORMATION_MESSAGE);
				else {
					String[] darbibas2 = {"Pasūtīt picu", "Saņemt picu", "Apskatīties visus pasūtījumus", "Rediģēt/Dzēst profilu", "Izlogoties"};
					int klients = Metodes.Izvele(klienti,2);
					if(Metodes.ievadParoli(klients, klienti)) {
						int izvelesIndekss=-1;
						do {
					String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas2, darbibas2[0]);
					izvelesIndekss = Arrays.asList(darbibas2).indexOf(izvele);
					if (izvele==null)
						izvelesIndekss=-1;
					switch(izvelesIndekss) {
					case 0:
						Metodes.pasutitPicu(klients, picas);
					    break;
					case 1:
						if(picas.size()==0) {
							JOptionPane.showMessageDialog(null, "Tu vēl nepasūtīji nevienu picu!", "Sistēmas paziņojums. Kļūda", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
							Metodes.sanemtPicu(klients, klienti, picas);						
						break;
					case 2:
						if(picas.size()==0) {
							JOptionPane.showMessageDialog(null, "Tu vēl nepasūtīji nevienu picu!", "Sistēmas paziņojums. Kļūda", JOptionPane.INFORMATION_MESSAGE);
						break;
						}
						Metodes.raditSarakstu(picas);
					break;
					case 3:
						klienti = ((Persona)klienti.get(klients)).rediget(klienti, klients);
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Veiksmīgi izrakstījies!", "Sistēmas paziņojums", JOptionPane.INFORMATION_MESSAGE);
						break;
					}	
					}while(izvelesIndekss!=4);
					}
				}
				Pamatmape_frame.this.setVisible(true);
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
