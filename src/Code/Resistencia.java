package Code;

public class Resistencia extends Ejercicios{
	private Ejercicios ejercicios;
	private  double tiempoTotal;
	private  String tipoActividad;
	public Resistencia(int repeticiones, int series, int cantPeso, int pausaEntreSerie, Ejercicios ejercicios,
			double tiempoTotal, String tipoActividad) {
		super(repeticiones, series, cantPeso, pausaEntreSerie);
		this.ejercicios = ejercicios;
		this.tiempoTotal = tiempoTotal;
		this.tipoActividad = tipoActividad;
	}
	public double getTiempoTotal() {
		return tiempoTotal;
	}
	public void setTiempoTotal(double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}
	public String getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
}
