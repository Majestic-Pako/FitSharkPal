package DLL;

import javax.swing.JOptionPane;

import BLL.Ejercicios;

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
	
	public static void afk(String nivel) {
        switch (nivel) {
            case "Principiante":
                Pri();
                break;
            case "Intermedio":
                Int();
                break;
            case "Avanzado":
                Ava();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nivel no válido");
        }
    }

	
	public static void Pri() {
		JOptionPane.showMessageDialog(null, "eSTE ENTRENAMIENTO ES PA NOOBS");
	}
	
	public static void Ava() {
		JOptionPane.showMessageDialog(null, "eSTE ENTRENAMIENTO ES PA Pros");
	}
	
	public static void Int() {
		JOptionPane.showMessageDialog(null, "eSTE ENTRENAMIENTO ES para q te importa");
	}
}
