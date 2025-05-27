package Code;

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
	public void RutinaFuerza(String tipoFuerza, boolean usarMaquinas, String nivel) {
		tipoFuerza = JOptionPane.showInputDialog(null, "Ingrese si quiere fuerza maxima o explosiva: ");
		nivel = JOptionPane.showInputDialog(null, "Ingrese su nivel(Principiante/Intermedio/Avanzado");
		if (!nivel.equalsIgnoreCase("principiante") && !nivel.equalsIgnoreCase("intermedio")
				&& !nivel.equalsIgnoreCase("avanzado")) {
			JOptionPane.showMessageDialog(null, "Nivel desconocida, intente nuevamente.");
			return;
		}
		if (tipoFuerza.equalsIgnoreCase("maxima")) {
			String respuesta = JOptionPane.showInputDialog(null, "¿Quiere usar maquina?(SI/NO");
			String mensaje = "";
			if (respuesta.equalsIgnoreCase("SI")) {
				usarMaquinas = true;
				if (nivel.equalsIgnoreCase("principiante")) {
					mensaje += "-Press en maquina pecho: 3x10\n";
					mensaje += "-Prensa de piernas ligera: 3x10\n";
					JOptionPane.showMessageDialog(null, mensaje);
				} else if (nivel.equalsIgnoreCase("intermedio")) {
					mensaje += "- Press de pecho en máquina: 4x6\n";
					mensaje += "- Remo en máquina: 4x6\n";
					mensaje += "- Prensa de piernas: 4x6\n";
					JOptionPane.showMessageDialog(null, mensaje);
				} else {
					mensaje += "- Press de pecho en máquina: 5x3\n";
					mensaje += "- Remo en máquina: 4x4\n";
					mensaje += "- Prensa de piernas: 5x3\n";
					mensaje += "- Curl femoral en máquina: 4x5\n";
					mensaje += "- Press de hombros en máquina: 4x3\n";
					mensaje += "- Crunch abdominal en máquina: 3x10\n";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} else if (respuesta.equalsIgnoreCase("NO")) {
				usarMaquinas = false;
				if (nivel.equalsIgnoreCase("principiante")) {
					mensaje += "- Sentadilla goblet: 3x10\n";
					mensaje += "- Peso muerto con mancuernas: 3x10\n";
					JOptionPane.showMessageDialog(null, mensaje);
				} else if (nivel.equalsIgnoreCase("intermedio")) {
					mensaje += "- Sentadilla con barra: 4x5\n";
					mensaje += "- Peso muerto: 4x5\n";
					mensaje += "- Press de banca: 4x5\n";
					JOptionPane.showMessageDialog(null, mensaje);
				} else {
					mensaje += "- Sentadilla libre con barra: 5x3\n";
					mensaje += "- Peso muerto: 5x3\n";
					mensaje += "- Press de banca con barra: 5x3\n";
					mensaje += "- Remo con barra: 4x5\n";
					mensaje += "- Press militar con barra: 4x4\n";
					mensaje += "- Plancha con peso: 3x30 segundos\n";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Opcion desconocida");
				return;
			}

		} else if (tipoFuerza.equalsIgnoreCase("explosiva")) {
			String respuesta = JOptionPane.showInputDialog(null, "¿Quiere usar máquina? (SI/NO):");
			String mensaje = "";
			 if (respuesta.equalsIgnoreCase("SI")) {
		            usarMaquinas = true;
		            if (nivel.equalsIgnoreCase("principiante")) {
		                mensaje += "- Prensa ligera: 3x8 (explosivo)\n";
		                mensaje += "- Press de pecho máquina: 3x8 (rápido)\n";
		                JOptionPane.showMessageDialog(null, mensaje);
		            } else if (nivel.equalsIgnoreCase("intermedio")) {
		                mensaje += "- Sentadilla en máquina Smith: 4x6\n";
		                mensaje += "- Extensiones de pierna rápidas: 3x8\n";
		                mensaje += "- Remo en máquina: 4x6\n";
		                JOptionPane.showMessageDialog(null, mensaje);
		            } else {
		                mensaje += "- Sentadilla en máquina Smith (barra ligera): 4x5\n";
		                mensaje += "- Prensa de piernas: 4x6 (subida rápida)\n";
		                mensaje += "- Extensiones de pierna rápidas: 3x8\n";
		                mensaje += "- Press de pecho en máquina: 4x6\n";
		                mensaje += "- Remo en máquina: 4x6\n";
		                mensaje += "- Jalón al pecho: 4x6\n";
		                mensaje += "- Crunch en máquina: 3x10\n";
		                mensaje += "- Rotaciones con cable (woodchopper): 3x10 por lado\n";
		                JOptionPane.showMessageDialog(null, mensaje);
		            }
		}else if(respuesta.equalsIgnoreCase("NO")) {
			usarMaquinas=false;
			 if (nivel.equalsIgnoreCase("principiante")) {
	                mensaje += "- Sentadilla con salto: 3x6\n";
	                mensaje += "- Flexiones rápidas: 3x8\n";
	                JOptionPane.showMessageDialog(null, mensaje);
	            } else if (nivel.equalsIgnoreCase("intermedio")) {
	                mensaje += "- Saltos al cajón: 4x6\n";
	                mensaje += "- Zancadas con salto: 3x6\n";
	                mensaje += "- Flexiones explosivas: 4x6\n";
	                JOptionPane.showMessageDialog(null, mensaje);
	            } else {
	                mensaje += "- Saltos al cajón: 4x6 repeticiones\n";
	                mensaje += "- Sentadillas con salto: 3x8\n";
	                mensaje += "- Zancadas con salto: 3x6 por pierna\n";
	                mensaje += "- Flexiones explosivas: 4x6\n";
	                mensaje += "- Mountain climbers: 3x30 segundos\n";
	                mensaje += "- Rotaciones con peso (disco o balón): 3x10 por lado\n";
	                mensaje += "- (Opcional) Clean con barra ligera o mancuernas: 4x4\n";
	                JOptionPane.showMessageDialog(null, mensaje);
	            }
		}else {
			JOptionPane.showMessageDialog(null, "Opcion de fuerza desconocida.");
		}
	}

}
