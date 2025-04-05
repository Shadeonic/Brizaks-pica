import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
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
			String vards="", uzvards="", adrese="", parole="";
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
			}while(!adrese.matches("^[-\\p{L} ]+$") || vards.length()<3);
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
			parole = Metodes.izvParoli();
			klienti.add(new Persona(adrese, vards, uzvards, parole, telNr));
			Metodes.saglabatFaila(adrese, vards, uzvards, parole, telNr);
			break;
		case 1:
			if(klienti.size()==0) 
				JOptionPane.showMessageDialog(null, "Tu vēl neizveidoju profilu vai tas netika saglabāts", "Kļūda", JOptionPane.INFORMATION_MESSAGE);
			else {
				String[] darbibas2 = {"Pasūtīt picu", "Saņemt picu", "Apskatīties visus pasūtījums", "Rediģēt/Dzēst profilu", "Izlogoties"};
				String[] picasVeidi = {"Izveidot savu", "Sēņu pica", "Margarita", "Četri sieri", "Karaliskā liellopa", "Pica ar ananāsiem", "Studentu pica", "Atpakaļ"};
				String[] izvLielumu = {"20 cm", "30 cm", "42 cm"};
				String[] izveidotPicu_piedevas = {"Mocarella siers", "Peperoni", "Tomāti", "Ananāsi", "Vistas gaļa"};
				String[] izveidotPicu_merces = {"Ķiploku mērce", "Tomātu mērce", "Zaļumu un eļļas mērce"};
				String[] atbilde = {"Jā", "Nē"};
				int klients = klientaIzvele(klienti);
				if(Metodes.ievadParoli(klients, klienti)) {
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas2, darbibas2[0]);
				izvelesIndekss = Arrays.asList(darbibas).indexOf(izvele);
				switch(izvelesIndekss) {
				case 0:
					picas = Metodes.pasutitPicu(klients, klienti, picas);
					break;
				case 1:
					if(picas.size()==0) {
						JOptionPane.showMessageDialog(null, "Tu vēl nepasūtīji nevienu picu!", "Kļūda", JOptionPane.INFORMATION_MESSAGE);
					}
					Metodes.sanemtPicu(klients, klienti, picas);
					break;
				case 2:
					if(picas.size()==0) {
						JOptionPane.showMessageDialog(null, "Tu vēl nepasūtīji nevienu picu!", "Kļūda", JOptionPane.INFORMATION_MESSAGE);
					}
					Metodes.raditSarakstu(picas);
				break;
				
				}
				}
			}
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Programma apturēta", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}while(izvelesIndekss != 2);
	}
}