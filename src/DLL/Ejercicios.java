package DLL;
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
	
	
	
}