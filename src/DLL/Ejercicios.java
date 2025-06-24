package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import BLL.ConfigRutina;
import repository.Conexion;

public class Ejercicios {
	private String piernas;
	private String brazos;
	private String pecho;
	private String espalda;
	private String zonaMedia;
	private String cardio;
	
	public Ejercicios (String piernas, String brazos, String pecho, String espalda, String zonaMedia, String cardio) { 
	super();
	this.piernas = piernas;
	this.brazos = brazos;
	this.pecho = pecho;
	this.espalda = espalda;
	this.zonaMedia = zonaMedia;
	this.cardio = cardio;
	}

	public String getPiernas() {
		return piernas;
	}

	public void setPiernas(String piernas) {
		this.piernas = piernas;
	}

	public String getBrazos() {
		return brazos;
	}

	public void setBrazos(String brazos) {
		this.brazos = brazos;
	}

	public String getPecho() {
		return pecho;
	}

	public void setPecho(String pecho) {
		this.pecho = pecho;
	}

	public String getEspalda() {
		return espalda;
	}

	public void setEspalda(String espalda) {
		this.espalda = espalda;
	}

	public String getZonaMedia() {
		return zonaMedia;
	}

	public void setZonaMedia(String zonaMedia) {
		this.zonaMedia = zonaMedia;
	}

	public String getCardio() {
		return cardio;
	}

	public void setCardio(String cardio) {
		this.cardio = cardio;
	}
	
	private static Connection con1 = Conexion.getInstance().getConnection();

	
	public static int NombreID(String nombreEjercicio, String tabla, String columnaEjercicio, String columnaId) {
	    int id = -1;
	    try {
	        String sqlSelect = "SELECT " + columnaId + " FROM " + tabla + " WHERE " + columnaEjercicio + " = ?";
	        PreparedStatement ps = con1.prepareStatement(sqlSelect);
	        ps.setString(1, nombreEjercicio);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            id = rs.getInt(columnaId);
	        } else {
	            String sqlInsert = "INSERT INTO " + tabla + " (" + columnaEjercicio + ") VALUES (?)";
	            PreparedStatement psInsert = con1.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
	            psInsert.setString(1, nombreEjercicio);
	            psInsert.executeUpdate();

	            ResultSet rsInsert = psInsert.getGeneratedKeys();
	            if (rsInsert.next()) {
	                id = rsInsert.getInt(1);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return id;
	}
	 
		private static Connection con = Conexion.getInstance().getConnection();

		public static int ind(String tabla, String columna, String valor) {
		    String sql = "INSERT INTO " + tabla + " (" + columna + ") VALUES (?)";
		    try (PreparedStatement ps = con1.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		        ps.setString(1, valor);
		        ps.executeUpdate();
		        ResultSet rs = ps.getGeneratedKeys();
		        if (rs.next()) {
		            return rs.getInt(1);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return -1; 
		}
	 
		public static int EjercicioBD(ConfigRutina rutina) {
		    int idEjercicios = -1;
		    try {
		        int idEspalda = Ejercicios.NombreID(rutina.getEspalda(), "Espalda", "ejercicio_espalda", "idEspalda");
		        int idBrazos = Ejercicios.NombreID(rutina.getBrazos(), "Brazos", "ejercicio_brazos", "idBrazos");
		        int idPecho = Ejercicios.NombreID(rutina.getPecho(), "Pecho", "ejercicio_pecho", "idPecho");
		        int idCardio = Ejercicios.NombreID(rutina.getCardio(), "Cardio", "Actividad", "idCardio");
		        int idZonaMedia = Ejercicios.NombreID(rutina.getZonaMedia(), "ZonaMedia", "ejercicio_zona_media", "idZonaMedia");
		        int idPiernas = Ejercicios.NombreID(rutina.getPiernas(), "Piernas", "ejercicio_piernas", "idPiernas");

		        String sql = "INSERT INTO Ejercicios (repeticiones, series, cantidad_peso, pausa_series, tiempo," +
		                "Espalda_idEspalda, Brazos_idBrazos, Pecho_idPecho, Cardio_idCardio, ZonaMedia_idZonaMedia, Piernas_idPiernas) " +
		                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		        try (PreparedStatement ps = con1.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		            ps.setInt(1, rutina.getRepeticiones());
		            ps.setInt(2, rutina.getSeries());
		            ps.setInt(3, rutina.getCantPeso());
		            ps.setInt(4, rutina.getPausaEntreSerie());
		            ps.setInt(5, rutina.getTiempo());
		            ps.setInt(6, idEspalda);
		            ps.setInt(7, idBrazos);
		            ps.setInt(8, idPecho);
		            ps.setInt(9, idCardio);
		            ps.setInt(10, idZonaMedia);
		            ps.setInt(11, idPiernas);

		            if (ps.executeUpdate() > 0) {
		                ResultSet rs = ps.getGeneratedKeys();
		                if (rs.next()) {
		                    idEjercicios = rs.getInt(1);
		                }
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return idEjercicios;
		}
		
		public static int Calculo(int repeticiones, int series, int cantPeso) {
		    int puntos = 0;
		    puntos += repeticiones / 5;
		    puntos += series;
		    puntos += cantPeso / 5;
		    return Math.min(puntos, 10); 
		}

	
}