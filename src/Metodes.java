import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		JOptionPane.showMessageDialog(null, "Radās kāda neparedzēta kļūda", "Kļūme", JOptionPane.ERROR_MESSAGE);
	}
}
static ArrayList<Persona> nolasitFailu() {//Metode, kas nolasīs failu un saglabas klienta ievaddatus pirms switch konstrukcijas
	ArrayList<Persona> klienti = new ArrayList<>();
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
            return klienti;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
