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
        button.setBounds(31, 11, 95, 31);
        contentPane.add(button);

        JButton button2 = new JButton("Margarita");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(1, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon((Pamatmape_frame.class.getResource("/peperoni.png"))));
        lblNewLabel.setBounds(171, 149, 100, 79);
        contentPane.add(lblNewLabel);
        button2.setBounds(166, 11, 95, 31);
        contentPane.add(button2);

        JButton button3 = new JButton("Četri sieri");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(2, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon((Pamatmape_frame.class.getResource("/margarita.png"))));
        lblNewLabel_1.setBounds(148, 38, 123, 84);
        contentPane.add(lblNewLabel_1);
        button3.setBounds(305, 11, 100, 31);
        contentPane.add(button3);

        JButton button4 = new JButton("Čempionu");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                Metodes.pasutitPicu(3, klients, picas);
                picas_izveide_logs.this.setVisible(true);
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon((Pamatmape_frame.class.getResource("/4sieri.png"))));
        lblNewLabel_2.setBounds(315, 45, 95, 84);
        contentPane.add(lblNewLabel_2);
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
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon((Pamatmape_frame.class.getResource("/cempions.png"))));
        lblNewLabel_3.setBounds(31, 162, 100, 56);
        contentPane.add(lblNewLabel_3);
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
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon((Pamatmape_frame.class.getResource("/senu.png"))));
        lblNewLabel_4.setBounds(31, 38, 129, 84);
        contentPane.add(lblNewLabel_4);
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
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon((Pamatmape_frame.class.getResource("/studentu.png"))));
        lblNewLabel_5.setBounds(305, 165, 100, 53);
        contentPane.add(lblNewLabel_5);
        button7.setBounds(89, 219, 95, 31);
        contentPane.add(button7);

        JButton button8 = new JButton("Atgriezties");
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	picas_izveide_logs.this.setVisible(false);
                beidza = true; 
                dispose(); 
            }
        });
        button8.setBounds(240, 219, 109, 31);
        contentPane.add(button8);

        JLabel fonsLabel = new JLabel(fonsatt);
        fonsLabel.setBounds(-16, -39, fonsatt.getIconWidth(), fonsatt.getIconHeight());
        contentPane.add(fonsLabel);
    }
}