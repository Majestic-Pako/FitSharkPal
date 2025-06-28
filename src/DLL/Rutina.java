package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import BLL.ConfigRutina;
import BLL.Gamificacion;
import repository.Conexion;

public class Rutina extends Gamificacion {

	public Rutina(int pts, int ptsTotal, ArrayList<String> carta, String piernas, String brazos, String pecho,
			String espalda, String zonaMedia, String cardio, int repeticiones, int series, int cantPeso,
			int pausaEntreSerie, int tiempo) {
		super(pts, ptsTotal, carta, piernas, brazos, pecho, espalda, zonaMedia, cardio, repeticiones, series, cantPeso,
				pausaEntreSerie, tiempo);
	}

	private static Connection con = Conexion.getInstance().getConnection();

	public static boolean RutinaBD(int idCuenta, int idEjercicios, int idGamificacion) {
	    String sql = "INSERT INTO Rutina (Cuenta_idCuenta, Ejercicios_idEjercicios, Gamificacion_idGamificacion) VALUES (?, ?, ?)";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, idCuenta);
	        ps.setInt(2, idEjercicios);
	        ps.setInt(3, idGamificacion);
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static void Ver(int pts, int ptsTotal, ArrayList<String> carta, String piernas, String brazos, String pecho,
			String espalda, String zonaMedia, String cardio, int repeticiones, int series, int cantPeso,
			int pausaEntreSerie, int tiempo) {

		JOptionPane.showMessageDialog(null,
				"RUTINA COMPLETA:" + "\n Entrada en calor: " + cardio + " por " + tiempo + " minutos"
						+ "\n Ejercicios: " + "\n" + zonaMedia + " -> " + repeticiones + " reps x" + series + " sets"
						+ "\n" + brazos + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg"
						+ "\n" + pecho + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg"
						+ "\n" + espalda + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg"
						+ "\n" + piernas + " -> " + repeticiones + " reps x" + series + " sets, con " + cantPeso + "kg"
						+ "\n Pausa recomendada entre cada set: " + pausaEntreSerie + "\n Puntaje Final = " + ptsTotal
						+ "\n Clasificacion = " + carta);
	}
	

}