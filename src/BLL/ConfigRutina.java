package BLL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedList;

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

	public static ConfigRutina Form() {
        LinkedList<String> cardioList = new LinkedList<>(Arrays.asList(
                "Incline Walk", "Biking", "Jogging"
            ));
            
            LinkedList<String> zonaMediaList = new LinkedList<>(Arrays.asList(
                "Crunches", "Planche", "Leg Raises"
            ));
            
            LinkedList<String> piernasList = new LinkedList<>(Arrays.asList(
                "Deadlift", "Bulgarian Split Squat", "Hip Adductor/Abductor Machine"
            ));
            
            LinkedList<String> brazosList = new LinkedList<>(Arrays.asList(
                "Face Away Bayesian Cable Curls", "Preacher Hammer Curls", "EZ Bar Skull Crushers"
            ));
            
            LinkedList<String> pechoList = new LinkedList<>(Arrays.asList(
                "Bench Press", "Incline Shoulder Press", "Dumbbell Fly"
            ));
            
            LinkedList<String> espaldaList = new LinkedList<>(Arrays.asList(
                "Narrow Grip Lat Pulldowns", "Wide Grip Chest Supported Row", "One-Arm Cable Row"
            ));

            String cardio = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione actividad de Cardio:",
                "Cardio",
                JOptionPane.PLAIN_MESSAGE,
                null,
                cardioList.toArray(),
                cardioList.getFirst());

            String zonaMedia = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione ejercicio para Zona Media:",
                "Zona Media",
                JOptionPane.PLAIN_MESSAGE,
                null,
                zonaMediaList.toArray(),
                zonaMediaList.getFirst());

            String piernas = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione ejercicio para Piernas:",
                "Piernas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                piernasList.toArray(),
                piernasList.getFirst());

            String brazos = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione ejercicio para Brazos:",
                "Brazos",
                JOptionPane.PLAIN_MESSAGE,
                null,
                brazosList.toArray(),
                brazosList.getFirst());

            String pecho = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione ejercicio para Pecho:",
                "Pecho",
                JOptionPane.PLAIN_MESSAGE,
                null,
                pechoList.toArray(),
                pechoList.getFirst());

            String espalda = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione ejercicio para Espalda:",
                "Espalda",
                JOptionPane.PLAIN_MESSAGE,
                null,
                espaldaList.toArray(),
                espaldaList.getFirst());


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
	                "SELECT e.repeticiones, e.series, e.cantidad_peso, e.pausa_series, e.tiempo," +
	                "pi.ejercicio_piernas AS piernas, br.ejercicio_brazos AS brazos, pe.ejercicio_pecho AS pecho, " +
	                "es.ejercicio_espalda AS espalda, zm.ejercicio_zona_media AS zonaMedia, ca.Actividad AS cardio "+
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
	                rs.getInt("pausa_series"),
	                rs.getInt("tiempo")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public static int Calculo(int repeticiones, int series, int cantPeso) {
	    // Validación de valores mínimos
	    repeticiones = Math.max(0, repeticiones);
	    series = Math.max(0, series);
	    cantPeso = Math.max(0, cantPeso);
	    
	    // Factores de ponderación (ajustables)
	    double factorRepeticiones = 0.15;  // Más sensible a repeticiones
	    double factorSeries = 0.5;         // Valor intermedio para series
	    double factorPeso = 0.03;          // Menos peso al kilogramaje
	    
	    // Cálculo proporcional
	    double puntos = 0;
	    puntos += repeticiones * factorRepeticiones;
	    puntos += series * factorSeries;
	    puntos += cantPeso * factorPeso;
	    
	    // Redondeo y límite máximo
	    int puntosFinales = (int) Math.round(puntos);
	    return puntosFinales;  // Aumentamos límite a 15 para permitir crecimiento
	}
	
	//esto serian getter y setter de las rutinas pero como no existen en esta clase se le tuvo q declarar asi
	//Ta dificil sacarlos porque esta clase tiene datos q necesita Ejercicios
	//Hablar si lo hacemos todo en la clase Ejercicios para mayor simplicidad
    public int getRepeticiones() { return repeticiones; }
    public int getSeries() { return series; }
    public int getCantPeso() { return cantPeso; }
    public int getPausaEntreSerie() { return pausaEntreSerie; }
    public int getTiempo() { return tiempo; }

	
}
