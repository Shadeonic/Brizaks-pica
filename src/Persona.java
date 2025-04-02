public class Persona {
//	atribūti
private String adrese, vards, uzvards;
private int talrunis;
private double cena;
private boolean sanemta_uz_vietas;
// Konstruktors
Persona(String adrese, String vards, String uzvards, int talrunis, double cena, boolean sanemta_uz_vietas){
	this.adrese = adrese;
	this.vards = vards;
	this.uzvards = uzvards;
	this.talrunis = talrunis;
	this.cena = cena;
	this.sanemta_uz_vietas = sanemta_uz_vietas;
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

public int getTalrunis() {
	return talrunis;
}

public double getCena() {
	return cena;
}

public boolean getVieta() {
	return sanemta_uz_vietas;
}
//Setteri
//Metodes
}
