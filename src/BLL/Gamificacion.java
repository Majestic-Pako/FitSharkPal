package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import repository.Conexion;

public class Gamificacion extends ConfigRutina {
	private int pts;
	private int ptsTotal;
	private ArrayList<String> Carta = new ArrayList<String>();

	public Gamificacion(int pts, int ptsTotal, ArrayList<String> carta, String piernas, String brazos, String pecho,
			String espalda, String zonaMedia, String cardio, int repeticiones, int series, int cantPeso,
			int pausaEntreSerie, int tiempo) {
		super(piernas, brazos, pecho, espalda, zonaMedia, cardio, repeticiones, series, cantPeso, pausaEntreSerie,
				tiempo);
		this.pts = pts;
		this.ptsTotal = ptsTotal;
		Carta = carta;
	}
	public Gamificacion(int puntaje, String carta) {
	    super(null, null, null, null, null, null, 0, 0, 0, 0, 0);
	    this.pts = puntaje;
	    this.Carta = new ArrayList<>();
	    this.Carta.add(carta);
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

	public void setCarta(ArrayList<String> carta) {
		this.Carta = carta;
	}

	public ArrayList<String> getCarta() {
		return Carta;
	}

	private static Connection con = Conexion.getInstance().getConnection();
	
	public static int IdGami(int idCliente, int idCuenta) throws SQLException {
	    String sqlSelect = "SELECT idGamificacion FROM Gamificacion WHERE Cliente_idCliente = ? AND Cliente_Cuenta_idCuenta = ? LIMIT 1";
	    PreparedStatement psSelect = con.prepareStatement(sqlSelect);
	    psSelect.setInt(1, idCliente);
	    psSelect.setInt(2, idCuenta);
	    ResultSet rs = psSelect.executeQuery();
	    if (rs.next()) {
	        return rs.getInt("idGamificacion");
	    }

	    String sqlInsert = "INSERT INTO Gamificacion (Cliente_idCliente, Cliente_Cuenta_idCuenta, puntaje) VALUES (?, ?, 0)";
	    PreparedStatement psInsert = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
	    psInsert.setInt(1, idCliente);
	    psInsert.setInt(2, idCuenta);
	    psInsert.executeUpdate();
	    ResultSet rsInsert = psInsert.getGeneratedKeys();
	    if (rsInsert.next()) {
	        return rsInsert.getInt(1);
	    }

	    throw new SQLException("No se pudo crear registro en Gamificacion");
	}
	
	public static void ActPts(int idGamificacion, int puntajeNuevo) throws SQLException {
	    String carta;

	    if (puntajeNuevo <= 0) {
	        carta = "Bronce";
	    } else if (puntajeNuevo <= 20) {
	        carta = "Bronce";
	    } else if (puntajeNuevo <= 46) {
	        carta = "Plata";
	    } else {
	        carta = "Oro";
	    }

	    String sql = "UPDATE Gamificacion SET puntaje = ?, carta = ? WHERE idGamificacion = ?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, puntajeNuevo);
	        ps.setString(2, carta);
	        ps.setInt(3, idGamificacion);
	        ps.executeUpdate();
	    }
	}
	
	public static Gamificacion GamiVer(int idCuenta) {
	    try {
	        String sql = "SELECT puntaje, carta FROM Gamificacion WHERE Cliente_Cuenta_idCuenta = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, idCuenta);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return new Gamificacion(rs.getInt("puntaje"), rs.getString("carta"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
}