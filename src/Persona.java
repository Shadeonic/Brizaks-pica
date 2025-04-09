import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Persona {
//	atribūti
private String adrese, vards, uzvards, parole;
private int talrunis;
// Konstruktors
Persona(String adrese, String vards, String uzvards, String parole, int talrunis){
	this.adrese = adrese;
	this.vards = vards;
	this.uzvards = uzvards;
	this.parole = parole;
	this.talrunis = talrunis;
}
//Getteri
public String getAdrese() {
	return adrese;
}

public String getVards() {
	return vards;
}

public String getUzvards() {
	return uzvards;
}

public String getParole() {
	return parole;
}

public int getTalrunis() {
	return talrunis;
}
public ArrayList<Object> rediget(ArrayList<Object> klienti, int klients) {
	String[] rediget = {"Vārdu", "Uzvārdu", "Adresi", "Paroli", "Telefona numuru", "Dzēst profilu", "Atpakaļ"};
	int izvelesIndekss=-1;
	boolean dzests = false;
	do {
	String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, rediget, rediget[0]);
	izvelesIndekss = Arrays.asList(rediget).indexOf(izvele);
	switch(izvelesIndekss) {
	case 0:
		nomVards();
	break;
	case 1:
		nomUzvards();
		break;
	case 2:
		nomAdresi();
		break;
	case 3:
		this.parole = Metodes.izvParoli();
		break;
	case 4:
		nomTel();
		break;
	case 5:
		String[] atbilde = {"Jā", "Nē"};
		izvele = (String) JOptionPane.showInputDialog(null, "Tiešām vēlies dzēst savu profilu?", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
		if(izvele=="Jā") {
			izvele = (String) JOptionPane.showInputDialog(null, "Šī darbība ir neatgriežama!", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
			if(izvele=="Jā") {
				String apstiprini = JOptionPane.showInputDialog(null, "Apstiprini izvēli, ievadot \"Apstiprinu\"!");
				if(apstiprini.equals("Apstiprinu"))
				dzests = true;
				izvelesIndekss=6;
			}else
				JOptionPane.showMessageDialog(null, "Darbība atcelta", "Sistēmas paziņojums", JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "Darbība atcelta", "Sistēmas paziņojums", JOptionPane.INFORMATION_MESSAGE);
		break;
	case 6:
		JOptionPane.showMessageDialog(null, "Notiek atgriešanās", "Sistēmas paziņojums. Informācija", JOptionPane.INFORMATION_MESSAGE);
		break;
	}
	}while(izvelesIndekss!=6);
	klienti.remove(klients);
	if(!dzests)
		klienti.add(new Persona(adrese, vards, uzvards, parole, talrunis));
	Metodes.saglabatFaila(klienti);
	return klienti;
}
public void nomVards() {
	String[] atbilde = {"Jā", "Nē"};
	String vards=getVards();
	do {
		vards = JOptionPane.showInputDialog("Ievadi savu jauno vārdu: ");
		if (vards == null) vards="";
	}while(!vards.matches("^[-\\p{L} ]+$") || vards.length()<3);
	String izvele = (String) JOptionPane.showInputDialog(null, "Nomainīt vārdu uz "+vards+"?", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
	if(izvele.equals("Jā"))
		this.vards = vards;
}

public void nomUzvards() {
	String[] atbilde = {"Jā", "Nē"};
	String uzvards=getUzvards();
	do {
		uzvards = JOptionPane.showInputDialog("Ievadi savu jauno uzvārdu: ");
		if (uzvards == null) uzvards="";
	}while(!uzvards.matches("^[-\\p{L} ]+$") || uzvards.length()<3);
	String izvele = (String) JOptionPane.showInputDialog(null, "Nomainīt uzvārdu uz "+uzvards+"?", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
	if(izvele.equals("Jā"))
		this.uzvards = uzvards;
}

public void nomAdresi() {
	String[] atbilde = {"Jā", "Nē"};
	String adrese=getAdrese();
	do {
		adrese = JOptionPane.showInputDialog("Ievadi savu jauno adresi: ");
		if (adrese == null) adrese="";
	}while(!adrese.matches("^[-\\p{L}\\d ]+$") || adrese.length()<3);
	String izvele = (String) JOptionPane.showInputDialog(null, "Nomainīt adresi uz "+adrese+"?", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
	if(izvele.equals("Jā"))
		this.adrese = adrese;
}

public void nomTel() {
	String[] atbilde = {"Jā", "Nē"};
	int talrunis=getTalrunis();
	do {
		try {
			String telNrS = JOptionPane.showInputDialog("Ievadi savu jauno telefona numuru (bez valsts koda): ");
			talrunis = Integer.parseInt(telNrS);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Tu neievadīji korektu numuru!", "Sistēmas paziņojums. Kļūda", JOptionPane.ERROR_MESSAGE);	
			}
	}while(talrunis>99999999 || talrunis<10000000);
	String izvele = (String) JOptionPane.showInputDialog(null, "Nomainīt talruni uz "+talrunis+"?", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
	if(izvele.equals("Jā"))
		this.talrunis = talrunis;
}
}
