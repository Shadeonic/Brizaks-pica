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
import java.text.DecimalFormat;
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
static void pasutitPicu(int izvelesIndekss, int klients, ArrayList<Object> picas) {//veido picu
	DecimalFormat df = new DecimalFormat("0.##");
	String[] atbilde = {"Jā", "Nē"};
	double cena=0;
	int lielums = 0;
	String piedevas="", merces="";
	boolean vieta=false;
	switch(izvelesIndekss) {
	case 0:
		//------sēņu pica ------
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = 0.25*lielums;
		cena = Pica.final_cena(cena, vieta);
		piedevas = "Sēnes";
		merces = "Tomātu un ķiploku mērces";	
		break;
	case 1:
		// ------ Margarita -----
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = Pica.final_cena(0.2*lielums, vieta);
		piedevas = "Mocarella";
		merces = "Tomātu un ķiploku mērces";
		break;
	case 2:
		//-------4 sieri ------
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = Pica.final_cena(0.3*lielums, vieta);
		piedevas = "Vārīts cūkgaļas šķiņķis, šampinjoni";
		merces = "Taco, tomātu un ķiploku mērces";	
	case 3:
		//----Čempionu pica --------
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = Pica.final_cena(0.3*lielums, vieta);
		piedevas = "Salami \"Pepperoni\", mocarella";
		merces = "Taco, tomātu un ķiploku mērces";	
		break;
	case 4:
		//------Peperoni------
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = Pica.final_cena(0.38*lielums, vieta);
		piedevas = "Vārīts cūkgaļas šķiņķis, salami \"Pepperoni\"";
		merces = "BBQ mērce";	
		break;
	case 5:
		//----Studentu pica-------
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = Pica.final_cena(0.43*lielums, vieta);
		piedevas = "Vārīts cūkgaļas šķiņķis, cīsiņi, mocarella";
		merces = "Tomātu mērce, eļļas un ķiploku mērce";	
		break;
	case 6:
		//----Sava pica-----
		String[] piedevasIzv = {"Karsti kūpināts bekons", "Kūpināta vistas fileja", "Malta liellopa gaļa", "Ananāsi", "Vistas gaļa"};
		String[] mercesIzv = {"Ķiploku mērce", "Tomātu mērce", "Zaļumu un eļļas mērce"};
		
		piedevas = (String) JOptionPane.showInputDialog(null, "Izvēlies picas piedevas", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, piedevasIzv, piedevasIzv[0]);
		merces = (String) JOptionPane.showInputDialog(null, "Izvēlies picas mērces", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, mercesIzv, mercesIzv[0]);
		lielums = izvLielumu();
		vieta = izvVietu();
		cena = Pica.final_cena(0.4*lielums, vieta);
		if(piedevas=="Ananāsi" || piedevas== "Vistas gaļa")
			cena-=1.47;
		else if(piedevas=="Karsti kūpināts bekons")
			cena+=1.32;
		break;
	}
	//Apmaksa///-----picas pasūtīšana-------
	if(lielums!=0 && JOptionPane.showInputDialog(null, "Par picu ar piedevām \""+piedevas+"\", picas mērci \""+merces+"\",\nizmēru "+lielums+"cm, kas "+((vieta)? "ir":"nav")+" iegādāta uz vietas, būs jāsamaksā "+df.format(cena)+"EUR. \nApstiprināt?", "Sistēmas paziņojums. Apstiprinājums", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0])=="Jā") {
		picas.add(new Pica(lielums, piedevas, merces, cena, vieta));
		JOptionPane.showMessageDialog(null, "Pica veiksmīgi iegādāta!");
	}else
		JOptionPane.showMessageDialog(null, "Pasūtījums atcelts", "Sistēmas paziņojums. Informācija", JOptionPane.INFORMATION_MESSAGE);
	saglabatFailaPicas("gatvasPicas.txt", picas, false);
}

static int izvLielumu() {
	String[] izvLielumu = {"20 cm", "30 cm", "42 cm"};
	String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies picas lielumu", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, izvLielumu, izvLielumu[0]);
	if (izvele=="20 cm") return 20;
	else if (izvele=="30 cm") return 30;
	return 42;
}

static boolean izvVietu() {
	String[] vieta = {"Saņem uz vietas", "Piegāde uz mājām"};
	String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies piegādi", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, vieta, vieta[0]);
	if (izvele=="Saņem uz vietas") return true;
	return false;
}
//-----------------------------------------------------------------Beidzās picu veidošanas nodaļa----------------------------------------------------------------------------
static ArrayList<Object> izvProfilu(ArrayList<Object> klienti) {//veido profilu
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
saglabatFaila(klienti);
return klienti;
}

static void raditSarakstu(ArrayList<Object> picas) {//rāda visu sarakstu ar izveidotām picām
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

static void apskatitIzdzestasPicas() {
	try {
	FileReader fr = new FileReader("izpirktasPicas.txt");
	BufferedReader br = new BufferedReader(fr);
	StringBuilder nolasitais = new StringBuilder();
	String teksts;
	while((teksts = br.readLine()) !=null) {
		teksts = teksts.replace("true", "uz vietas").replace("false", "uz mājām");
        nolasitais.append(teksts).append("\n");
	}
	br.close();
	JOptionPane.showMessageDialog(null, nolasitais, "Faila saturs", JOptionPane.INFORMATION_MESSAGE);
	}catch(IOException e){
		JOptionPane.showMessageDialog(null, "Radās kļūda, nolasot failu!", "Kļūda", JOptionPane.WARNING_MESSAGE);
	}
}

static String izvParoli() {//Veido un apstiprina paroli
	char[] Cparole="T".toCharArray(), ApstParole;
	int x = JOptionPane.CANCEL_OPTION;
	do {
		ImageIcon logo = new ImageIcon(Pamatmape_frame.class.getResource("/user.png")); 
        Image logoImage = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Pielāgo attēlu
        ImageIcon pielagotsLogo = new ImageIcon(logoImage);
     
        JPasswordField jpf1 = new JPasswordField(16);//parole
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
 
    JPasswordField jpf1 = new JPasswordField(16);//parole
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
//-----------------------------------------------------------------Beidzās personas info nodaļa--------------------------------------------
static void saglabatFaila(ArrayList<Object> saraksts) {//pēc katras klienta izveidošanas, tas tiek ievadīts šajā failā
	try {
	FileWriter fr = new FileWriter("Klienti.txt");
	PrintWriter pw = new PrintWriter(fr);
	for(int i=0; i<saraksts.size(); i++) {
		String adrese = ((Persona)saraksts.get(i)).getAdrese();
		String vards = ((Persona)saraksts.get(i)).getVards();
		String uzvards = ((Persona)saraksts.get(i)).getUzvards();
		String parole = ((Persona)saraksts.get(i)).getParole();
		int telNr = ((Persona)saraksts.get(i)).getTalrunis();
	
			pw.println(vards+": "+uzvards+": "+adrese+": "+telNr+": "+parole);
	}
		pw.close();
	}catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda!", "Sistēmas paziņojums. Kļūme", JOptionPane.ERROR_MESSAGE);
	}
}

static void saglabatFailaPicas(String vieta, ArrayList<Object> saraksts, boolean saglabat) {//pēc katras klienta izveidošanas, tas tiek ievadīts šajā failā
	try {
	FileWriter fr = new FileWriter(vieta, saglabat);
	PrintWriter pw = new PrintWriter(fr);
	for(int i=0; i<saraksts.size(); i++) {
		int lielums = ((Pica)saraksts.get(i)).getLielums();
		String piedevas = ((Pica)saraksts.get(i)).getPiedevas();
		String merces = ((Pica)saraksts.get(i)).getMerces();
		double cena = ((Pica)saraksts.get(i)).getCena();
		boolean sanemta_uz_vietas = ((Pica)saraksts.get(i)).getVieta();
			pw.println(piedevas+": "+merces+": "+lielums+": "+sanemta_uz_vietas+": "+cena);
	}
		pw.close();
	}catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda!", "Sistēmas paziņojums. Kļūme", JOptionPane.ERROR_MESSAGE);
	}
}

static ArrayList<Object> nolasitFailu(ArrayList<Object> saraksts, String vieta) {//Metode, kas nolasīs failu un saglabas klienta ievaddatus pirms switch konstrukcijas
	try {
    	FileReader fr = new FileReader(vieta);
		BufferedReader br = new BufferedReader(fr);
        String teksts;
        
        while ((teksts = br.readLine()) != null) {
            String[] parts = teksts.split(": "); 
            
            if (parts.length == 5) { 
            	if(vieta.equals("Klienti.txt")) {
	                String vards = parts[0].trim();  
	                String uzvards = parts[1].trim(); 
	                String adrese = parts[2].trim();  
	                String telNrS = parts[3].trim();
	                int telNr = Integer.parseInt(telNrS);
	                String parole = parts[4].trim();  
	                saraksts.add(new Persona(adrese, vards, uzvards, parole, telNr));
            	} else {
            		String piedevas = parts[0].trim(); 
            		String merces = parts[1].trim();
            		String lielumsS = parts[2].trim();
	                int lielums = Integer.parseInt(lielumsS);
	                String vietaS = parts[3].trim();
	                boolean vietaB = Boolean.parseBoolean(vietaS);
	                String cenaS = parts[4].trim();
	                double cena = Double.parseDouble(cenaS);
	                saraksts.add(new Pica(lielums, piedevas, merces, cena, vietaB));
            	}
            } else {
            	JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda", "Sistēmas paziņojums. Kļūme", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
	
	return saraksts;
}
//----------------------------------------------------beidzās failu nodaļa-----------------------------------------------------------
static void sanemtPicu(int klients, ArrayList<Object> klienti, ArrayList<Object> pica) {
	if(pica.size()>0) {
		int kuraPica = Izvele(pica, 1);
		if(((Pica)pica.get(kuraPica)).getVieta()) {//Maksā uz vietas
			int x = JOptionPane.showConfirmDialog(null, "Par picu būs jāsamaksā "+((Pica)pica.get(kuraPica)).getCena()+"EUR.\nApmaksāt?","Sistēmas paziņojums. Samaksa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (x == JOptionPane.OK_OPTION) 
				JOptionPane.showMessageDialog(null, "Pica veiksmīgi piegādāta pie tava galdiņa!", "Sistēmas paziņojums. Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			 else 
				 policija();
			 
		} else {//Maksā par piegādi
			int x = JOptionPane.showConfirmDialog(null, "Par picu būs jāsamaksā "+(((Pica)pica.get(kuraPica)).getCena()+5)+"EUR.\nApmaksāt?","Sistēmas paziņojums. Samaksa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (x == JOptionPane.OK_OPTION) 
			JOptionPane.showMessageDialog(null, "Pica veiksmīgi piegādāta uz tavām mājām: "+((Persona)klienti.get(klients)).getAdrese(), "Sistēmas paziņojums. Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			else 
				policija();
			
		}
		Object removedPica= pica.remove(kuraPica);//Itkā apmaksāta
		ArrayList<Object> delPica = new ArrayList<Object>();
		delPica.add(removedPica);
		saglabatFailaPicas("izpirktasPicas.txt", delPica, true);//saglabā apmaksāto picu sarakstā
		saglabatFailaPicas("gatvasPicas.txt", pica, false);
	}else
		JOptionPane.showMessageDialog(null, "Tev nav nevienas picas!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);
}

static ArrayList<Object> pasutitPicu(int klients, ArrayList<Object> klienti, ArrayList<Object> picas) {
	
	return picas;
}

public static void policija() {//Izvadīsies gif, ja atbildēs, ka nemaksas par picu
	 	ImageIcon policijaAtbr = new ImageIcon(Pamatmape_frame.class.getResource("/policija.gif"));
	    Image scaledImage = policijaAtbr.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
	    policijaAtbr = new ImageIcon(scaledImage);
	    JLabel gifLabel = new JLabel(policijaAtbr);
	    JOptionPane optionPane = new JOptionPane(gifLabel, JOptionPane.PLAIN_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Zvans 112...");
	    dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(Pamatmape_frame.class.getResource("/pizza.png")));
	    dialog.setPreferredSize(new Dimension(500, 400)); 
	    dialog.pack();
	    dialog.setVisible(true);        
	}

static int Izvele(ArrayList <Object> saraksts, int kas) {//Izvēlās picu vai klientu no saraksta
	String[] rSaraksts = new String[saraksts.size()];

	if(kas==1) {
		for(int i=0; i<rSaraksts.length; i++) {//Saraksts ar picām
			rSaraksts[i] =((Pica)saraksts.get(i)).getPiedevas()+" "+((Pica)saraksts.get(i)).getLielums()+" cm";
		}
	}else {
		for(int i=0; i<rSaraksts.length; i++) {//Sarakats ar klientiem
			rSaraksts[i] =((Persona)saraksts.get(i)).getVards()+" "+((Persona)saraksts.get(i)).getUzvards();
		}
	}
	String izveletais=null;
	do {
		izveletais = (String)JOptionPane.showInputDialog(null, "Izvēlies", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, rSaraksts, rSaraksts[0]);
	}while(izveletais==null);
		return Arrays.asList(rSaraksts).indexOf(izveletais);
}
}
//------------------------------------------------------------------beidzās sarakstu/izvēles un gif nodaļa---------------------------------------------------