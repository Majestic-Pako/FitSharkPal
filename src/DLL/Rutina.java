package DLL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BLL.Gamificacion;

public class Rutina extends Gamificacion{

	public Rutina(int pts, int ptsTotal, ArrayList<String> carta, String piernas, String brazos, String pecho,
			String espalda, String zonaMedia, String cardio, int repeticiones, int series, int cantPeso,
			int pausaEntreSerie, int tiempo) {
		super(pts, ptsTotal, carta, piernas, brazos, pecho, espalda, zonaMedia, cardio, repeticiones, series, cantPeso,
				pausaEntreSerie, tiempo);
	}

	public static void Ver(int pts, int ptsTotal, ArrayList<String> carta, String piernas, String brazos, String pecho, String espalda, String zonaMedia, String cardio,
			int repeticiones, int series, int cantPeso, int pausaEntreSerie, int tiempo) {

		JOptionPane.showMessageDialog(null, 
				"RUTINA COMPLETA:" + 
				"\n Entrada en calor: " + cardio + " por " + tiempo + " minutos" +
				"\n Ejercicios: " + 
				"\n" + zonaMedia + " -> " + repeticiones + " reps x" + series + " sets" +
				"\n" + brazos + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg" +
				"\n" + pecho + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg" +
				"\n" + espalda + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg" +
				"\n" + piernas + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg" +
				"\n Pausa recomendada entre cada set: " + pausaEntreSerie +
				"\n Puntaje Final = " + ptsTotal + 
				"\n Clasificacion = " + carta);
		//Calificacion final= Pensar nombre
		//Clasifiacion==
	}

}