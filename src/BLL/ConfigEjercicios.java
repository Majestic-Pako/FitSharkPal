package BLL;

import javax.swing.JOptionPane;

import DLL.Ejercicios;

public class ConfigEjercicios extends Ejercicios {
	private int repeticiones;
	private int series;
	private int cantPeso;
	private int pausaEntreSerie;
	private int tiempo;

	public ConfigEjercicios(String piernas, String brazos, String pecho, String espalda, String zonaMedia,
			String cardio, int repeticiones, int series, int cantPeso, int pausaEntreSerie, int tiempo) {
		super(piernas, brazos, pecho, espalda, zonaMedia, cardio);
		this.repeticiones = repeticiones;
		this.series = series;
		this.cantPeso = cantPeso;
		this.pausaEntreSerie = pausaEntreSerie;
		this.tiempo = tiempo;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getCantPeso() {
		return cantPeso;
	}

	public void setCantPeso(int cantPeso) {
		this.cantPeso = cantPeso;
	}

	public int getPausaEntreSerie() {
		return pausaEntreSerie;
	}

	public void setPausaEntreSerie(int pausaEntreSerie) {
		this.pausaEntreSerie = pausaEntreSerie;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public void Configuracion(int repeticiones, int series, int cantPeso, int pausaEntreSerie, int tiempo) {
		
		tiempo = Integer.parseInt(
				JOptionPane.showInputDialog("Ingrese tiempo de entrada en calor:"));
		repeticiones = Integer.parseInt(
				JOptionPane.showInputDialog("Ingrese cuantas repeticiones se hara por cada ejercicio:"));
		series = Integer.parseInt(
				JOptionPane.showInputDialog("Ingrese cuantas series se haran en la rutina:"));
		cantPeso = Integer.parseInt(
				JOptionPane.showInputDialog("Ingrese el peso para el ejercicio:"));
		pausaEntreSerie = Integer.parseInt(
				JOptionPane.showInputDialog("Ingrese tiempo de pausa entre serie:"));
	}

}
