import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
public class Pamatmape {
	static int klientaIzvele(ArrayList <Object> klienti) {
		String[] rSaraksts = new String[klienti.size()];
		for(int i=0; i<rSaraksts.length; i++) {
			rSaraksts[i] =((Persona)klienti.get(i)).getVards()+" "+((Persona)klienti.get(i)).getUzvards();
		}
		String izveletais = (String)JOptionPane.showInputDialog(null, "Izvēlies profilu", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, rSaraksts, rSaraksts[0]);
		return Arrays.asList(rSaraksts).indexOf(izveletais);
	}
	public static void main(String[] args) {
		String[] darbibas = {"Izveidot profilu", "Pieslēgties","Aizvērt programmu"};
		String[] darbibas2 = {"Pasūtīt picu", "Saņemt picu", "Apskatīties visus pasūtījums", "Rediģēt/Dzēst profilu", "Izlogoties"};
		String[] picasVeidi = {"Izveidot savu", "Sēņu pica", "Margarita", "Četri sieri", "Karaliskā liellopa", "Pica ar ananāsiem", "Studentu pica", "Atpakaļ"};
		String[] sanemtPicu = {"Uz vietas", "Piegāde uz mājām"};
		String[] izvLielumu = {"20 cm", "30 cm", "42 cm"};
		String[] izveidotPicu_piedevas = {"Mocarella siers", "Peperoni", "Tomāti", "Ananāsi", "Vistas gaļa"};
		String[] izveidotPicu_merces = {"Ķiploku mērce", "Tomātu mērce", "Zaļumu un eļļas mērce"};
		String[] atbilde = {"Jā", "Nē"};
		ArrayList <Object> picas = new ArrayList <Object>();
		ArrayList <Object> klienti = new ArrayList <Object>();
		String izvele;
		int izvelesIndekss;
		Metodes.nolasitFailu(klienti);
		do {
		izvele =(String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
		izvelesIndekss = Arrays.asList(darbibas).indexOf(izvele);
		switch(izvelesIndekss) {
		case 0:
			String vards="", uzvards="", adrese="";
			do {
				vards = JOptionPane.showInputDialog("Ievadi savu vārdu: ");
				if (vards == null) break;
			}while(!vards.matches("^[-\\p{L}]+$") || vards.length()<3);
			if(vards == null)
				break;
			do {
				uzvards = JOptionPane.showInputDialog("Ievadi savu uzvārdu: ");
				if (uzvards == null) break;
			}while(!uzvards.matches("^[-\\p{L}]+$") || vards.length()<3);
			if(uzvards == null)
				break;
			
			do {
				adrese = JOptionPane.showInputDialog("Ievadi savu adresi: ");
				if (adrese == null) break;
			}while(!adrese.matches("^[-\\p{L}]+$") || vards.length()<3);
			if(adrese == null)
				break;
			int telNr=0;
			do {
				try {
					String telNrS = JOptionPane.showInputDialog("Ievadi savu telefona numuru (bez valsts koda): ");
					telNr = Integer.parseInt(telNrS);
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Tu neievadīji korektu skaitli!", "Kļūda", JOptionPane.ERROR_MESSAGE);	
					}
			}while(telNr>99999999 || telNr<10000000);
			String parole="", apstParoli="";
			do {
				parole = JOptionPane.showInputDialog("Ievadi savu paroli: ");
				apstParoli = JOptionPane.showInputDialog("Apstiprini savu paroli: ");
				if(!parole.equals(apstParoli)) 
					JOptionPane.showMessageDialog(null, "Paroles nesakrīt!", "Kļūda", JOptionPane.ERROR_MESSAGE);	
			}while(!parole.equals(apstParoli));
			klienti.add(new Persona(adrese, vards, uzvards, parole, telNr));//Ideja pievienot šo info kādā teksta dokumentā un pēc programmas izslēgšanas info saglabājas
			Metodes.saglabatFaila(adrese, vards, uzvards, parole, telNr);
			break;
		case 1:
			String[] registr_izvele = {"Atgriezties un izveidot savu profilu", "Pieslēgties kā viesis"};
			if(klienti.size()==0) {
				izvele =(String) JOptionPane.showInputDialog(null, "Tu vēl neizveidoju profilu vai tas netika saglabāts", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, registr_izvele, registr_izvele[0]);
				izvelesIndekss = Arrays.asList(darbibas).indexOf(izvele);
				if(izvelesIndekss==0)
					break;
				else {
					Metodes.pasutitPicu(-1);
				}
			}else {
				int kursPok = klientaIzvele(klienti);
				parole = JOptionPane.showInputDialog("Ievadi savu paroli: ");
				if(!((Persona)klienti.get(kursPok)).getParole().equals(parole)) {
					JOptionPane.showMessageDialog(null, "Paroles nesakrīt!", "Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}else 
					Metodes.pasutitPicu(kursPok);
			}
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Programma apturēta", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}while(izvelesIndekss != 2);
	}
}