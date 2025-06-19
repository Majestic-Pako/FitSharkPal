package BLL;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import DLL.Ejercicios;
import repository.Conexion;

public class ConfigRutina extends Ejercicios {
    private int repeticiones;
    private int series;
    private int cantPeso;
    private int pausaEntreSerie;
    private int tiempo; //Hay que agregarlo en la base de datos para guardarlo

    public ConfigRutina(String piernas, String brazos, String pecho, String espalda, String zonaMedia,
                        String cardio, int repeticiones, int series, int cantPeso, int pausaEntreSerie, int tiempo) {
        super(piernas, brazos, pecho, espalda, zonaMedia, cardio);
        this.repeticiones = repeticiones;
        this.series = series;
        this.cantPeso = cantPeso;
        this.pausaEntreSerie = pausaEntreSerie;
        this.tiempo = tiempo;
    }
    
    public ConfigRutina(String piernas, String brazos, String pecho, String espalda, String zonaMedia,
            String cardio, int repeticiones, int series, int cantPeso, int pausaEntreSerie) {
    	super(piernas, brazos, pecho, espalda, zonaMedia, cardio);
    	this.repeticiones = repeticiones;
    	this.series = series;
    	this.cantPeso = cantPeso;
    	this.pausaEntreSerie = pausaEntreSerie;
}

    public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}


	public void setSeries(int series) {
		this.series = series;
	}


	public void setCantPeso(int cantPeso) {
		this.cantPeso = cantPeso;
	}


	public void setPausaEntreSerie(int pausaEntreSerie) {
		this.pausaEntreSerie = pausaEntreSerie;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	private static Connection con = Conexion.getInstance().getConnection();

	//es un prototipo hasta que se diseñe bien el ingreso de datos
	public static ConfigRutina Form() {
    	String cardio = JOptionPane.showInputDialog("Ingrese la actividad de cardio (Ej: Cinta, Bicicleta)");
        String zonaMedia = JOptionPane.showInputDialog("Ingrese un ejercicio para zona media");
        String piernas = JOptionPane.showInputDialog("Ingrese un ejercicio para piernas");
        String brazos = JOptionPane.showInputDialog("Ingrese un ejercicio para brazos");
        String pecho = JOptionPane.showInputDialog("Ingrese un ejercicio para pecho");
        String espalda = JOptionPane.showInputDialog("Ingrese un ejercicio para espalda");

        int tiempo = Integer.parseInt(JOptionPane.showInputDialog("Duración del cardio: "));
        int repeticiones = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de repeticiones por ejercicio:"));
        int series = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de series por ejercicio:"));
        int peso = Integer.parseInt(JOptionPane.showInputDialog("Peso: "));
        int pausa = Integer.parseInt(JOptionPane.showInputDialog("Descanso entre series: "));

        return new ConfigRutina(piernas, brazos, pecho, espalda, zonaMedia, cardio,
                repeticiones, series, peso, pausa, tiempo);
    }
	
	public static ConfigRutina RutinaVer(int idCuenta) {
	    try {
	    	String sql =
	                "SELECT e.repeticiones, e.series, e.cantidad_peso, e.pausa_series, " +
	                "pi.ejercicio_piernas AS piernas, br.ejercicio_brazos AS brazos, pe.ejercicio_pecho AS pecho, " +
	                "es.ejercicio_espalda AS espalda, zm.ejercicio_zona_media AS zonaMedia, ca.Actividad AS cardio " +
	                "FROM rutina r " +
	                "JOIN ejercicios e ON r.Ejercicios_idEjercicios = e.idEjercicios " +
	                "JOIN piernas pi ON e.Piernas_idPiernas = pi.idPiernas " +
	                "JOIN brazos br ON e.Brazos_idBrazos = br.idBrazos " +
	                "JOIN pecho pe ON e.Pecho_idPecho = pe.idPecho " +
	                "JOIN espalda es ON e.Espalda_idEspalda = es.idEspalda " +
	                "JOIN zonamedia zm ON e.ZonaMedia_idZonaMedia = zm.idZonaMedia " +
	                "JOIN cardio ca ON e.Cardio_idCardio = ca.idCardio " +
	                "WHERE r.Cuenta_idCuenta = ?";
	        PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
	        ps.setInt(1, idCuenta);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return new ConfigRutina(
	                rs.getString("piernas"),
	                rs.getString("brazos"),
	                rs.getString("pecho"),
	                rs.getString("espalda"),
	                rs.getString("zonaMedia"),
	                rs.getString("cardio"),
	                rs.getInt("repeticiones"),
	                rs.getInt("series"),
	                rs.getInt("cantidad_peso"),
	                rs.getInt("pausa_series")
	                //Aca deberia estar el tiempo pa cardio pero como no existe en BD no lo puedo llamar
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	// eta wea tambien hay que corregir esta muy basico xD
	public static int Calculo(ConfigRutina rutina) {
	    int puntos = 0;
	    puntos += rutina.getRepeticiones() / 5;
	    puntos += rutina.getSeries();
	    puntos += rutina.getCantPeso() / 5;
	    return Math.min(puntos, 10); 
	}

	//esto serian getter y setter de las rutinas pero como no existen en esta clase se le tuvo q declarar asi
	//No deberia aparecer en el modelo final solo es un prototipo para ver como funciona el sistema
    public int getRepeticiones() { return repeticiones; }
    public int getSeries() { return series; }
    public int getCantPeso() { return cantPeso; }
    public int getPausaEntreSerie() { return pausaEntreSerie; }
    public int getTiempo() { return tiempo; }
}
