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
	public static void main(String[] args) {
		String[] darbibas = {"Izveidot profilu", "Pieslēgties","Aizvērt programmu"};
		String[] darbibas2 = {"Pasūtīt picu", "Saņemt picu", "Apskatīties visus pasūtījums", "Rediģēt/Dzēst profilu", "Izlogoties"};
		String[] picasVeidi = {"Izveidot savu", "Sēņu pica", "Margarita", "Četri sieri", "Karaliskā liellopa", "Pica ar ananāsiem", "Studentu pica", "Atpakaļ"};
		String[] sanemtPicu = {"Uz vietas", "Piegāde uz mājām"};
		String[] izvLielumu = {"20 cm", "30 cm", "42 cm"};
		String[] izveidotPicu_piedevas = {"Mocarella siers", "Peperoni", "Tomāti", "Ananāsi", "Vistas gaļa"};
		String[] izveidotPicu_merces = {"Ķiploku mērce", "Tomātu mērce", "Zaļumu un eļļas mērce"};
		String[] atbilde = {"Jā", "Nē"};
		ArrayList <Object> pokemoni = new ArrayList <Object>();
		String izvele;
		int izvelesIndekss;
		do {
		izvele =(String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
		izvelesIndekss = Arrays.asList(darbibas).indexOf(izvele);
		switch(izvelesIndekss) {
		case 0:
			break;
		case 1:
			break;
		case 2://Saraksts
			break;
		case 3:
			break;
		case 4://Metodes
			break;
		case 5:
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Programma apturēta", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}while(izvelesIndekss != 6);
		
	}
}