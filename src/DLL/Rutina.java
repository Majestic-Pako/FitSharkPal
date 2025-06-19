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

	// esto es por no poner autoincrement al idRutina
	// Es un parque hasta que se corrija en la BD, cuando se corrija hacer lo mismo
	// que IdGami
	private static int IdRutina() throws SQLException {
		String sql = "SELECT IFNULL(MAX(idRutina), 0) + 1 AS nuevoId FROM Rutina";
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
			return rs.getInt("nuevoId");
		return 1;
	}

	public static boolean RutinaBD(int idCuenta, int idEjercicios, int idGamificacion) throws SQLException {
		int idRutina = IdRutina(); 
		String sql = "INSERT INTO Rutina (idRutina, Cuenta_idCuenta, Ejercicios_idEjercicios, Gamificacion_idGamificacion) VALUES (?, ?, ?, ?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, idRutina);
			ps.setInt(2, idCuenta);
			ps.setInt(3, idEjercicios);
			ps.setInt(4, idGamificacion);
			int affectedRows = ps.executeUpdate();
			return affectedRows > 0;
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
		// Calificacion final= Pensar nombre
		// Clasifiacion==
	}
	

}