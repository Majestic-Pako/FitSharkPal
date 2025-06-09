package Code;

import java.util.ArrayList;

public class Gamificacion extends ConfigEjercicios{
	private int pts;
	private int ptsTotal;
private ArrayList<String>Carta= new ArrayList<String>();

public Gamificacion(int pts, int ptsTotal, ArrayList<String> carta, String piernas, String brazos, String pecho, String espalda, String zonaMedia,
		String cardio, int repeticiones, int series, int cantPeso, int pausaEntreSerie, int tiempo) {
	super(piernas, brazos, pecho, espalda, zonaMedia, cardio, repeticiones, series, cantPeso, pausaEntreSerie, tiempo);
	this.pts = pts;
	this.ptsTotal = ptsTotal;
	Carta = carta;
}
public int getPts() {
	return pts;
}
public void setPts(int pts) {
	this.pts = pts;
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

//Ahi va el mensaje de Esteban :]
public static boolean cartasPuntuaje(int pts, int ptsTotal,String Carta) {
	if(pts<=0) {
		Carta="Nada";
		ptsTotal+=pts;
		return true;
		//falta un nombre para del 1 hasta el 3 xd
	}else if(pts>=4 && pts<=6) {
		Carta="Medium";
		ptsTotal+=pts;
		return true;
	}else if(pts>=7 && pts<=10) {
		Carta="Pro";
		ptsTotal+=pts;
		return true;
	}
	return false;
	
}


}
