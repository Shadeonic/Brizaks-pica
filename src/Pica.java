import javax.swing.JOptionPane;

public class Pica {
//	atribūti
private double lielums, cena;
private String piedevas, merces;
private boolean sanemta_uz_vietas;
//  Konstruktors
Pica(double lielums, String piedevas, String merces, double cena, boolean sanemta_uz_vietas){
	this.lielums = lielums;
	this.piedevas = piedevas;
	this.merces = merces;
	this.cena = cena;
	this.sanemta_uz_vietas = sanemta_uz_vietas;
}
// Getteri
public double getLielums() {
	return lielums;
}

public String getPiedevas() {
	return piedevas;
}

public String getMerces() {
	return merces;
}
public double getCena() {
	return cena;
}

public boolean getVieta() {
	return sanemta_uz_vietas;
}
// Setteri
// Metodes
public String izvadit() {
	return "Piedevas: "+getPiedevas()+
			"\nMērces: "+getMerces()+
			"\nIzmērs: "+getLielums()+" cm"+
			"\nCena: "+getCena();
}

public int izvLielumu() {
	String[] izvLielumu = {"20 cm", "30 cm", "42 cm"};
	String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies picas lielumu", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, izvLielumu, izvLielumu[0]);
	if (izvele=="20 cm") return 20;
	else if (izvele=="30 cm") return 30;
	return 42;
}

public boolean izvVietu() {
	String[] vieta = {"Saņem uz vietas", "Piegāde uz mājām"};
	String izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies piegādi", "Sistēmas paziņojums. Izvēle", JOptionPane.QUESTION_MESSAGE, null, vieta, vieta[0]);
	if (izvele=="Saņem uz vietas") return true;
	return false;
}
}
