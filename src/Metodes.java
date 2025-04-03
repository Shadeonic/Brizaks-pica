import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Metodes {
static void pasutitPicu(int klients) {//Ja -1, tad kā viesis
	
}

static void saglabatFaila(String adrese, String vards, String uzvards, String parole, int telNr) {
	try {
		FileWriter fr = new FileWriter("Klienti.txt", true);
		PrintWriter pw = new PrintWriter(fr);
			pw.print(vards+": "+uzvards+": "+adrese+": "+telNr+": "+parole);
		pw.println("\n-----------------------------------------------------------");
		pw.close();
		JOptionPane.showMessageDialog(null, "Veiksmīgi saglabāts failā", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
	}catch(IOException e) {
		JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā", "Kļūme", JOptionPane.ERROR_MESSAGE);
	}
}
static void nolasitFailu() {//Metode, kas nolasīs failu un saglabas klienta ievaddatus pirms switch konstrukcijas
	
}
}
