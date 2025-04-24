package Code;

public class Volumen extends Ejercicios {
	private Ejercicios ejercicios;
	private  String grupoMuscular;
	private  boolean supersets;
	public Volumen(int repeticiones, int series, int cantPeso, int pausaEntreSerie, Ejercicios ejercicios,
			String grupoMuscular, boolean supersets) {
		super(repeticiones, series, cantPeso, pausaEntreSerie);
		this.ejercicios = ejercicios;
		this.grupoMuscular = grupoMuscular;
		this.supersets = supersets;
	}
	public String getGrupoMuscular() {
		return grupoMuscular;
	}
	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
	public boolean isSupersets() {
		return supersets;
	}
	public void setSupersets(boolean supersets) {
		this.supersets = supersets;
	}
	
}
