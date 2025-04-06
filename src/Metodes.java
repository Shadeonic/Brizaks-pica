import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
public class Metodes {
static ArrayList<Object> pasutitPicu(int klients, ArrayList<Object> picas) {
	String[] izvLielumu = {"20 cm", "30 cm", "42 cm"};
	String[] izveidotPicu_piedevas = {"Mocarella siers", "Peperoni", "Tomāti", "Ananāsi", "Vistas gaļa"};
	String[] izveidotPicu_merces = {"Ķiploku mērce", "Tomātu mērce", "Zaļumu un eļļas mērce"};
	String[] atbilde = {"Jā", "Nē"};
	
	return picas;
}

static ArrayList<Object> izvProfilu(ArrayList<Object> klienti) {
String vards="", uzvards="", adrese="", parole="";
do {
	vards = JOptionPane.showInputDialog("Ievadi savu vārdu: ");
	if (vards == null) vards="";;
}while(!vards.matches("^[-\\p{L} ]+$") || vards.length()<3);
do {
	uzvards = JOptionPane.showInputDialog("Ievadi savu uzvārdu: ");
	if (uzvards == null) uzvards="";;
}while(!uzvards.matches("^[-\\p{L}]+$") || vards.length()<3);
do {
	adrese = JOptionPane.showInputDialog("Ievadi savu adresi: ");
	if (adrese == null) adrese="";;
}while(!adrese.matches("^[-\\p{L}\\d ]+$") || vards.length()<3);
int telNr=0;
do {
	try {
		String telNrS = JOptionPane.showInputDialog("Ievadi savu telefona numuru (bez valsts koda): ");
		telNr = Integer.parseInt(telNrS);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Tu neievadīji korektu numuru!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);	
		}
}while(telNr>99999999 || telNr<10000000);
parole = Metodes.izvParoli();
klienti.add(new Persona(adrese, vards, uzvards, parole, telNr));
saglabatFaila(adrese, vards, uzvards, parole, telNr);
return klienti;
}

static void raditSarakstu(ArrayList<Object> picas) {
    String str = "Pieejamās picas: " + picas.size() +
            "\n________________________\n";
    for (int i = 0; i < picas.size(); i++) {
        str += ((Pica) picas.get(i)).izvadit() +
                "\n________________________\n";
    }
    JTextArea ta = new JTextArea(str, 10, 35);
    ta.setEditable(false);
    JScrollPane sp = new JScrollPane(ta);
    sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(sp, BorderLayout.CENTER);
    JOptionPane.showMessageDialog(null, panel, "Picu saraksts", JOptionPane.PLAIN_MESSAGE);
}

static void saglabatFaila(String adrese, String vards, String uzvards, String parole, int telNr) {
	try {
		FileWriter fr = new FileWriter("Klienti.txt", false);
		PrintWriter pw = new PrintWriter(fr);
			pw.println(vards+": "+uzvards+": "+adrese+": "+telNr+": "+parole);
		pw.close();
	}catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda!", "Sistēmas paziņojums. Kļūme", JOptionPane.ERROR_MESSAGE);
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
            	JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda", "Sistēmas paziņojums. Kļūme", JOptionPane.ERROR_MESSAGE);
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
		ImageIcon logo = new ImageIcon(Pamatmape_frame.class.getResource("/user.png")); 
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
	    		JOptionPane.showMessageDialog(null, "Nepareiza parole!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);
	}while(!(Arrays.equals(Cparole, ApstParole) && x == JOptionPane.OK_OPTION));
	    String parole="";
	try {
		parole = String.copyValueOf(Cparole);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Notika kāda neparedzēta kļūda!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);	
		}
	return parole;
}

static boolean ievadParoli(int klients, ArrayList<Object> klienti) {
	do {
	String Saglab_parole = ((Persona)klienti.get(klients)).getParole();
	
	ImageIcon logo = new ImageIcon(Pamatmape_frame.class.getResource("/user.png")); 
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
    		JOptionPane.showMessageDialog(null, "Notika kāda neparedzēta kļūda!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);	
    	}
    if (x == JOptionPane.OK_OPTION) 
    	if(parole.equals(Saglab_parole)) {
    		return true;
    	}else
    		JOptionPane.showMessageDialog(null, "Nepareiza parole!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);
    else
    	break;
	}while(true);
	return false;
}

static void sanemtPicu(int klients, ArrayList<Object> klienti, ArrayList<Object> pica) {
	String[] sanemtPicu = {"Uz vietas", "Piegāde uz mājām"};
	String izvele;
	if(pica.size()>0) {
		int kuraPica = Izvele(pica, 1);
		izvele = (String)JOptionPane.showInputDialog(null, "Kā vēlies saņemt picu?", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, sanemtPicu, sanemtPicu[0]);
		if(izvele=="Uz vietas") {
			int x = JOptionPane.showConfirmDialog(null, "Par picu būs jāsamaksā "+((Pica)pica.get(kuraPica)).getCena()+"EUR.\nApmaksāt?","Sistēmas paziņojums. Samaksa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (x == JOptionPane.OK_OPTION) 
				JOptionPane.showMessageDialog(null, "Pica veiksmīgi piegādāta pie tava galdiņa!", "Sistēmas paziņojums. Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			 else
				 policija();
		} else {
			int x = JOptionPane.showConfirmDialog(null, "Par picu būs jāsamaksā "+(((Pica)pica.get(kuraPica)).getCena()+5)+"EUR.\nApmaksāt?","Sistēmas paziņojums. Samaksa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (x == JOptionPane.OK_OPTION) 
			JOptionPane.showMessageDialog(null, "Pica veiksmīgi piegādāta uz tavām mājām: "+((Persona)klienti.get(klients)).getAdrese(), "Sistēmas paziņojums. Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			else
				policija();
		}
		pica.remove(kuraPica);
	}else
		JOptionPane.showMessageDialog(null, "Tev nav nevienas picas!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);
}

static ArrayList<Object> pasutitPicu(int klients, ArrayList<Object> klienti, ArrayList<Object> picas) {
	
	return picas;
}

public static void policija() {
	 	ImageIcon policijaAtbr = new ImageIcon("/policija.gif");
	    Image scaledImage = policijaAtbr.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
	    policijaAtbr = new ImageIcon(scaledImage);
	    JLabel gifLabel = new JLabel(policijaAtbr);
	    JOptionPane optionPane = new JOptionPane(gifLabel, JOptionPane.PLAIN_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Policija...");
	    dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(Pamatmape_frame.class.getResource("/pizza.png")));
	    dialog.setPreferredSize(new Dimension(500, 400)); 
	    dialog.pack();
	    dialog.setVisible(true);        
	}

static int Izvele(ArrayList <Object> saraksts, int kas) {
	String[] rSaraksts = new String[saraksts.size()];
	if(kas==1) {
		for(int i=0; i<rSaraksts.length; i++) {//Saraksts ar picām
			rSaraksts[i] =((Pica)saraksts.get(i)).getPiedevas()+" "+((Pica)saraksts.get(i)).getLielums();
		}
	}else {
		for(int i=0; i<rSaraksts.length; i++) {//Sarakats ar klientiem
			rSaraksts[i] =((Persona)saraksts.get(i)).getVards()+" "+((Persona)saraksts.get(i)).getUzvards();
		}
	}
		String izveletais = (String)JOptionPane.showInputDialog(null, "Izvēlies", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, rSaraksts, rSaraksts[0]);
	return Arrays.asList(rSaraksts).indexOf(izveletais);
	}
}
