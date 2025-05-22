package Code;

public class Fuerza extends Ejercicios{
	private Ejercicios ejercicios;
	private  String tipoFuerza;
	private  boolean usarMaquinas;
	public Fuerza(int repeticiones, int series, int cantPeso, int pausaEntreSerie, Ejercicios ejercicios,
			String tipoFuerza, boolean usarMaquinas) {
		super(repeticiones, series, cantPeso, pausaEntreSerie);
		this.ejercicios = ejercicios;
		this.tipoFuerza = tipoFuerza;
		this.usarMaquinas = usarMaquinas;
	}
	public String getTipoFuerza() {
		return tipoFuerza;
	}
	public void setTipoFuerza(String tipoFuerza) {
		this.tipoFuerza = tipoFuerza;
	}
	public boolean isUsarMaquinas() {
		return usarMaquinas;
	}
	public void setUsarMaquinas(boolean usarMaquinas) {
		this.usarMaquinas = usarMaquinas;
	}
	

}
