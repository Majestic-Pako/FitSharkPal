package BLL;

import java.util.ArrayList;

public class Gamificacion {
private int ptsFuerza;
private int ptsResistencia;
private int ptsTotal;
private ArrayList<String>Carta= new ArrayList<String>();

public Gamificacion(int ptsFuerza, int ptsResistencia, int ptsTotal, ArrayList<String> carta) {
	super();
	this.ptsFuerza = ptsFuerza;
	this.ptsResistencia = ptsResistencia;
	this.ptsTotal = ptsTotal;
	Carta = carta;
}
public int getPtsFuerza() {
	return ptsFuerza;
}
public void setPtsFuerza(int ptsFuerza) {
	this.ptsFuerza = ptsFuerza;
}
public int getPtsResistencia() {
	return ptsResistencia;
}
public void setPtsResistencia(int ptsResistencia) {
	this.ptsResistencia = ptsResistencia;
}
public int getPtsTotal() {
	return ptsTotal;
}
public void setPtsTotal(int ptsTotal) {
	this.ptsTotal = ptsTotal;
}
public ArrayList<String> getCarta() {
	return Carta;
}
public void setCarta(ArrayList<String> carta) {
	Carta = carta;
}
@Override
public String toString() {
	return "Gamificacion [ptsFuerza=" + ptsFuerza + ", ptsResistencia=" + ptsResistencia + ", ptsTotal=" + ptsTotal
			+ ", Carta=" + Carta + ", getPtsFuerza()=" + getPtsFuerza() + ", getPtsResistencia()=" + getPtsResistencia()
			+ ", getPtsTotal()=" + getPtsTotal() + ", getCarta()=" + getCarta() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}


}
