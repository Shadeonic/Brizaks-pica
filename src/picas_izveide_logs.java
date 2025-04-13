import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
public class picas_izveide_logs extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    @SuppressWarnings("unused")
    private int klients;
    @SuppressWarnings("unused")
    private ArrayList<Object> picas;
    private boolean beidza = false;
    public boolean beidza() {
        return beidza;
    }
    public picas_izveide_logs(int klients, ArrayList<Object> picas) {
        this.klients = klients;
        this.picas = picas;
        
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pizza.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        contentPane = new JPanel();
        ImageIcon fonsatt = new ImageIcon(getClass().getResource("/fons4.png"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);     

        JButton button = new JButton("Sēņu pica");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(0, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        button.setBounds(31, 54, 95, 31);
        contentPane.add(button);

        JButton button2 = new JButton("Margarita");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(1, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        button2.setBounds(166, 54, 95, 31);
        contentPane.add(button2);

        JButton button3 = new JButton("Četri sieri");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(2, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        button3.setBounds(305, 54, 100, 31);
        contentPane.add(button3);

        JButton button4 = new JButton("Čempionu");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(3, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        button4.setBounds(31, 123, 95, 31);
        contentPane.add(button4);

        JButton button5 = new JButton("Pepperoni");
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
            	Metodes.pasutitPicu(4, klients, picas);
            	picas_izveide_logs.this.setVisible(true);
            }
        });
        button5.setBounds(166, 123, 95, 31);
        contentPane.add(button5);

        JButton button6 = new JButton("Studentu");
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
            	Metodes.pasutitPicu(5, klients, picas);
            	picas_izveide_logs.this.setVisible(true);
            }
        });
        button6.setBounds(305, 123, 100, 31);
        contentPane.add(button6);

        JButton button7 = new JButton("Sava pica");
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
            	Metodes.pasutitPicu(6, klients, picas);
            	picas_izveide_logs.this.setVisible(true);
            }
        });
        button7.setBounds(90, 182, 95, 31);
        contentPane.add(button7);

        JButton button8 = new JButton("Atgriezties");
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                beidza = true; 
                dispose(); 
            }
        });
        button8.setBounds(240, 182, 109, 31);
        contentPane.add(button8);

        JLabel fonsLabel = new JLabel(fonsatt);
        fonsLabel.setBounds(-16, -39, fonsatt.getIconWidth(), fonsatt.getIconHeight());
        contentPane.add(fonsLabel);
    }
}