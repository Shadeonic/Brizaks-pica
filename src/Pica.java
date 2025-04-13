import java.text.DecimalFormat;
public class Pica {
//	atribūti
private double cena;
private int lielums;
private String piedevas, merces;
private boolean sanemta_uz_vietas;
//  Konstruktors
Pica(int lielums, String piedevas, String merces, double cena, boolean sanemta_uz_vietas){
	this.lielums = lielums;
	this.piedevas = piedevas;
	this.merces = merces;
	this.cena = cena;
	this.sanemta_uz_vietas = sanemta_uz_vietas;
}
// Getteri
public int getLielums() {
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

public static double final_cena(double cena, boolean vieta) {
    return vieta ? cena : cena * 1.5;
}

// Metodes
public String izvadit() {
	DecimalFormat df = new DecimalFormat("0.##");
	return "Piedevas: "+getPiedevas()+
			"\nMērces: "+getMerces()+
			"\nIzmērs: "+getLielums()+" cm"+
			"\nIegādāta uz vietas: "+((getVieta())? "ir":"nav")+
			"\nCena: "+df.format(getCena());
}
}
