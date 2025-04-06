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
}
