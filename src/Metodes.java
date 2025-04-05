import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class Metodes {
static void pasutitPicu(int klients) {//Ja -1, tad kā viesis
	
}

static void saglabatFaila(String adrese, String vards, String uzvards, String parole, int telNr) {
	try {
		FileWriter fr = new FileWriter("Klienti.txt", true);
		PrintWriter pw = new PrintWriter(fr);
			pw.println(vards+": "+uzvards+": "+adrese+": "+telNr+": "+parole);
		pw.close();
	}catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda!", "Kļūme", JOptionPane.ERROR_MESSAGE);
	}
}
static ArrayList<Object> nolasitFailu(ArrayList<Object> klienti) {//Metode, kas nolasīs failu un saglabas klienta ievaddatus pirms switch konstrukcijas
	try {
    	FileReader fr = new FileReader("Klienti.txt");
		BufferedReader br = new BufferedReader(fr);
        String teksts;
        
        while ((teksts = br.readLine()) != null) {
            String[] parts = teksts.split(": "); 
            
            if (parts.length == 5) { 
                String vards = parts[0].trim();  
                String uzvards = parts[1].trim(); 
                String adrese = parts[2].trim();  
                String telNrS = parts[3].trim();
                int telNr = Integer.parseInt(telNrS);
                String parole = parts[4].trim();  
                klienti.add(new Persona(adrese, vards, uzvards, parole, telNr));
            } else {
            	JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda", "Kļūme", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
	
	return klienti;
}

static String izvParoli() {
	char[] Cparole="T".toCharArray(), ApstParole;
	int x = JOptionPane.CANCEL_OPTION;
	do {
		ImageIcon logo = new ImageIcon(Pamatmape.class.getResource("/user.jpg")); 
        Image logoImage = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Pielāgo attēlu
        ImageIcon pielagotsLogo = new ImageIcon(logoImage);
     
        JPasswordField jpf1 = new JPasswordField(16);//paroli
		jpf1.setEchoChar( '*' );
	    JLabel jl1 = new JLabel("Ievadi paroli: ");
	    JCheckBox raditParoli1 = new JCheckBox("");
	    raditParoli1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (raditParoli1.isSelected()) {
	                jpf1.setEchoChar((char) 0); // Show password
	            } else {
	                jpf1.setEchoChar('*'); // Hide password
	            }
	        }
	    });
	    Box box1 = Box.createHorizontalBox();
	    box1.add(jl1);
	    box1.add(jpf1);
	    box1.add(Box.createHorizontalStrut(7));
	    box1.add(raditParoli1);
	    
		JPasswordField jpf2 = new JPasswordField(16);//apstiprina paroli
		jpf2.setEchoChar( '*' );
	    JLabel jl2 = new JLabel("Apstiprini paroli: ");
	    JCheckBox raditParoli2 = new JCheckBox("");
	    raditParoli2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (raditParoli2.isSelected()) {
	                jpf2.setEchoChar((char) 0); // Show password
	            } else {
	                jpf2.setEchoChar('*'); // Hide password
	            }
	        }
	    });
	    Box box2 = Box.createHorizontalBox();
	    box2.add(jl2);
	    box2.add(jpf2);
	    box2.add(Box.createHorizontalStrut(7));
	    box2.add(raditParoli2);
	    
	    Box kopBox = Box.createVerticalBox();
	    kopBox.add(box1);
	    box1.add(Box.createHorizontalStrut(7));
	    kopBox.add(box2);
	    box2.add(Box.createHorizontalStrut(7));
	    
	    x = JOptionPane.showConfirmDialog(null, kopBox, "Pieslēgties", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, pielagotsLogo);
	    Cparole = jpf1.getPassword( );
	    ApstParole = jpf2.getPassword( );
	    if (x == JOptionPane.OK_OPTION) 
	    	if(Arrays.equals(Cparole, ApstParole)) {
	    	}else
	    		JOptionPane.showMessageDialog(null, "Nepareiza parole!", "Kļūda", JOptionPane.ERROR_MESSAGE);
	}while(!(Arrays.equals(Cparole, ApstParole) && x == JOptionPane.OK_OPTION));
	    String parole="";
	try {
		parole = String.copyValueOf(Cparole);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Notika kāda neparedzēta kļūda!", "Kļūda", JOptionPane.ERROR_MESSAGE);	
		}
	return parole;
}

static boolean ievadParoli(int klients, ArrayList<Object> klienti) {
	do {
	String Saglab_parole = ((Persona)klienti.get(klients)).getParole();
	
	ImageIcon logo = new ImageIcon(Pamatmape.class.getResource("/user.jpg")); 
    Image logoImage = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Pielāgo attēlu
    ImageIcon pielagotsLogo = new ImageIcon(logoImage);
 
    JPasswordField jpf1 = new JPasswordField(16);//paroli
	jpf1.setEchoChar( '*' );
    JLabel jl1 = new JLabel("Ievadi paroli: ");
    JCheckBox raditParoli1 = new JCheckBox("");
    raditParoli1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (raditParoli1.isSelected()) {
                jpf1.setEchoChar((char) 0); // Show password
            } else {
                jpf1.setEchoChar('*'); // Hide password
            }
        }
    });
    Box box1 = Box.createHorizontalBox();
    box1.add(jl1);
    box1.add(jpf1);
    box1.add(Box.createHorizontalStrut(7));
    box1.add(raditParoli1);
    
    int x = JOptionPane.showConfirmDialog(null, box1, "Pieslēgties", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, pielagotsLogo);
    char[] Cparole = jpf1.getPassword( );
    String parole="";
    try {
    	parole = String.copyValueOf(Cparole);
    	}catch(NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "Notika kāda neparedzēta kļūda!", "Kļūda", JOptionPane.ERROR_MESSAGE);	
    	}
    if (x == JOptionPane.OK_OPTION) 
    	if(parole.equals(Saglab_parole)) {
    		return true;
    	}else
    		JOptionPane.showMessageDialog(null, "Nepareiza parole!", "Kļūda", JOptionPane.ERROR_MESSAGE);
    else
    	break;
	}while(true);
	return false;
}
}
