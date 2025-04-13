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
import javax.swing.border.EmptyBorder;

public class izveles_logs extends JFrame {
	private boolean userLoggedOut = false;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")//atzīmēju tos, ka tie nav lieki, jo tiek izmantoti dziļāk programmā pie klientu veidošanas/padošanas/utt
	private ArrayList<Object> klienti;//bet tā kā šie dzeltenie paziņojumi mulsina/traucē, tad es paziņoju programmai, ka tie nav lieki
	@SuppressWarnings("unused")
    private ArrayList<Object> picas;
	@SuppressWarnings("unused")
    private int klients;
	
	public izveles_logs(int klients, ArrayList<Object> klienti, ArrayList<Object> picas) {
		this.klients = klients;
        this.klienti = klienti;
        this.picas = picas;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pamatmape_frame.class.getResource("/pizza.png"))); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		ImageIcon fonsatt = new ImageIcon(Pamatmape_frame.class.getResource("/fons4.png"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Pasūtīt picu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izveles_logs.this.setVisible(false);
				Metodes.pasutitPicu(klients, picas);
				izveles_logs.this.setVisible(true);
			}
		});
		button.setBounds(164, 28, 101, 34);
		contentPane.add(button);
		
		JButton button2 = new JButton("Saņemt picu");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izveles_logs.this.setVisible(false);
				if(picas.size()==0) {
					JOptionPane.showMessageDialog(null, "Tu vēl nepasūtīji nevienu picu!", "Sistēmas paziņojums. Kļūda", JOptionPane.INFORMATION_MESSAGE);
				}else
					Metodes.sanemtPicu(klients, klienti, picas);
				izveles_logs.this.setVisible(true);
			}
		});
		button2.setBounds(152, 73, 124, 34);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Apskatīties pasūtījumus");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izveles_logs.this.setVisible(false);
				String[] izv = {"Apskatīties tikko izveidotās picas", "Apskatīties jau pārdotās picas"};
				String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, izv, izv[0]);
				int id = Arrays.asList(izv).indexOf(izvele);
				if(id==0) {
					if(picas.size()==0) {
						JOptionPane.showMessageDialog(null, "Tu vēl nepasūtīji nevienu picu!", "Sistēmas paziņojums. Kļūda", JOptionPane.INFORMATION_MESSAGE);
					}
					Metodes.raditSarakstu(picas);		
				}else
					Metodes.apskatitIzdzestasPicas();
				izveles_logs.this.setVisible(true);
			}
		});
		button3.setBounds(122, 118, 183, 34);
		contentPane.add(button3);
		
		JButton button4 = new JButton("Rediģēt/Dzēst profilu");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izveles_logs.this.setVisible(false);		     
		        try {
		            ArrayList<Object> updatedKlienti = ((Persona)klienti.get(klients)).rediget(klienti, klients);	       
		            if (updatedKlienti == null || updatedKlienti.isEmpty()) {
		                userLoggedOut = true;
		                dispose(); 
		            } else {
		                izveles_logs.this.klienti = updatedKlienti;
		                JOptionPane.showMessageDialog(null, "Profila izmaiņas saglabātas!", "Informācija", JOptionPane.INFORMATION_MESSAGE);
		                izveles_logs.this.setVisible(true);
		            }
		        } catch (IndexOutOfBoundsException ex) {
		            userLoggedOut = true;
		            dispose();
		        }
			}
		});
		
		button4.setBounds(132, 163, 162, 34);
		contentPane.add(button4);
		
		JButton button5 = new JButton("Izlogoties");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLoggedOut = true;
                dispose();
			}
		});
		button5.setBounds(164, 208, 101, 34);
		contentPane.add(button5);
		
		JLabel fonsLabel = new JLabel(fonsatt);
		fonsLabel.setBounds(-16, -39, fonsatt.getIconWidth(), fonsatt.getIconHeight());
		contentPane.add(fonsLabel);
	}
	public boolean isUserLoggedOut() {
        return userLoggedOut;
    }
}

