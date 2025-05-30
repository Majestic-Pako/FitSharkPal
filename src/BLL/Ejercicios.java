package BLL;

public class Ejercicios {
	private int repeticiones;
	private int series;
	private int cantPeso;
	private int pausaEntreSerie;
	public Ejercicios(int repeticiones, int series, int cantPeso, int pausaEntreSerie) {
		super();
		this.repeticiones = repeticiones;
		this.series = series;
		this.cantPeso = cantPeso;
		this.pausaEntreSerie = pausaEntreSerie;
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
	
}
