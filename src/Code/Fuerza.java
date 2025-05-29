package Code;

import javax.swing.JOptionPane;

public class Fuerza extends Ejercicios{
	private Ejercicios ejercicios;
	private  String tipoFuerza;
	private static  boolean usarMaquinas;
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
                Principiante(usarMaquinas);
                break;
            case "Intermedio":
                Intermedia(usarMaquinas);
                break;
            case "Avanzado":
                Avanzada(usarMaquinas); 
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nivel no válido");

        }
    }

	
	public static void Principiante(boolean usarMaquinas) {
		String respuesta = JOptionPane.showInputDialog(null, "¿Quiere usar maquina?(SI/NO");
		if (respuesta.equalsIgnoreCase("SI")) {
			usarMaquinas = true;
			String mensaje = "=== RUTINA PARA PRINCIPIANTES (CON MÁQUINAS) ===\n\n"
    + "1. **Press en máquina para pecho**\n"
    + "   - Objetivo: Pecho, hombros y tríceps.\n"
    + "   - Ejecución: Ajusta el asiento para que los agarres queden a la altura del pecho. Empuja sin bloquear codos.\n"
    + "   - Series/Reps: 3 × 10\n"
    + "   - Descanso: 45 segundos\n\n"
    + "2. **Prensa de piernas ligera**\n"
    + "   - Objetivo: Cuádriceps y glúteos.\n"
    + "   - Ejecución: Empuja con los talones (no puntas) y evita bloquear rodillas.\n"
    + "   - Series/Reps: 3 × 10\n\n"
    + "3. **Jalón al pecho con agarre ancho**\n"
    + "   - Objetivo: Espalda y postura.\n"
    + "   - Ejecución: Tira de la barra al pecho (no al cuello) y controla el movimiento.\n"
    + "   - Series/Reps: 3 × 10\n\n"
    + "4. **Curl de piernas sentado (isquiotibiales)**\n"
    + "   - Objetivo: Parte posterior de los muslos.\n"
    + "   - Ejecución: Flexiona las piernas sin levantar los muslos del asiento.\n"
    + "   - Series/Reps: 3 × 12\n\n"
    + "5. **Curl de bíceps en máquina**\n"
    + "   - Objetivo: Bíceps (aislado).\n"
    + "   - Ejecución: Apoya los codos en la almohadilla y sube sin balancearte.\n"
    + "   - Series/Reps: 3 × 12\n\n"
    + "6. **Extensión de tríceps en polea alta**\n"
    + "   - Objetivo: Tríceps.\n"
    + "   - Ejecución: Usa la cuerda, empuja hacia abajo manteniendo codos pegados al cuerpo.\n"
    + "   - Series/Reps: 3 × 12\n\n"
    + "7. **Abdominales en máquina**\n"
    + "   - Objetivo: Core seguro.\n"
    + "   - Ejecución: Flexiona el torso sin tirar del cuello.\n"
    + "   - Series/Reps: 3 × 15\n\n"
    + "--- RECOMENDACIONES ---\n"
    + "- Calentamiento: 5-10 min de movilidad.\n"
    + "- Descanso entre series: 30-60 segundos.\n"
    + "- Progresión: Aumenta 1 repetición por semana.\n\n"
    + "--- RECOMENDACIONES ---\n"
    + "- Material: Usa botellas de agua (1-2L) o bandas elásticas.\n"
    + "- Dificultad: Si un ejercicio es muy fácil, aumenta las repeticiones.\n"
    + "- Consistencia: 3 veces por semana.";
		
JOptionPane.showMessageDialog(null, mensaje);
			
		} else if (respuesta.equalsIgnoreCase("NO")) {
			usarMaquinas = false;
			        String mensaje="=== RUTINA PARA PRINCIPIANTES (SIN MÁQUINAS) ===\n\n"
					    + "1. **Flexiones con rodillas apoyadas**\n"
					    + "   - Objetivo: Pecho y brazos adaptado.\n"
					    + "   - Ejecución: Manos más anchas que hombros, baja el pecho sin arquear la espalda.\n"
					    + "   - Series/Reps: 3 × 10\n\n"
					    + "2. **Sentadillas al aire**\n"
					    + "   - Objetivo: Piernas y glúteos.\n"
					    + "   - Ejecución: Baja como si te sentaras (rodillas detrás de los dedos).\n"
					    + "   - Series/Reps: 3 × 15\n\n"
					    + "3. **Remo con banda elástica o botellas**\n"
					    + "   - Objetivo: Espalda.\n"
					    + "   - Ejecución: Tira de la banda hacia la cintura o usa botellas como peso.\n"
					    + "   - Series/Reps: 3 × 12\n\n"
					    + "4. **Puente de glúteos**\n"
					    + "   - Objetivo: Glúteos y lumbar.\n"
					    + "   - Ejecución: Levanta la cadera hasta formar línea recta hombros-rodillas.\n"
					    + "   - Series/Reps: 3 × 15\n\n"
					    + "5. **Curl de bíceps con botellas**\n"
					    + "   - Objetivo: Bíceps.\n"
					    + "   - Ejecución: Sube las botellas girando las palmas hacia arriba.\n"
					    + "   - Series/Reps: 3 × 12\n\n"
					    + "6. **Fondos en silla (tríceps)**\n"
					    + "   - Objetivo: Parte posterior de los brazos.\n"
					    + "   - Ejecución: Baja el cuerpo flexionando codos hacia atrás (no a los lados).\n"
					    + "   - Series/Reps: 3 × 10\n\n"
					    + "7. **Plancha básica**\n"
					    + "   - Objetivo: Abdomen y core.\n"
					    + "   - Ejecución: Mantén el cuerpo recto (20 segundos por serie).\n"
					    + "   - Series: 3\n\n";
			 JOptionPane.showMessageDialog(null, mensaje);
			
		
		} else {
			JOptionPane.showMessageDialog(null, "Opcion desconocida");
			return;
		}
	}
	public static void Intermedia(boolean usarMaquina) {
		String respuesta = JOptionPane.showInputDialog(null, "¿Quiere usar maquina?(SI/NO");
		String mensaje = "";
		if (respuesta.equalsIgnoreCase("SI")) {
			usarMaquinas = true;
			String mensaje_intermedia = "=== RUTINA INTERMEDIA (CON MÁQUINAS) ===\n\n"
				    + "1. **Press de pecho inclinado en máquina**\n"
				    + "   - Objetivo: Parte superior del pecho y hombros.\n"
				    + "   - Ejecución: Ajusta el banco a 45°, empuja con control y evita arquear la espalda.\n"
				    + "   - Series/Reps: 4 × 8-10\n"
				    + "   - Descanso: 60 segundos\n\n"
				    + "2. **Prensa de piernas con pies en posición baja**\n"
				    + "   - Objetivo: Enfocar glúteos y femorales.\n"
				    + "   - Ejecución: Coloca los pies abajo en la plataforma, empuja con los talones.\n"
				    + "   - Series/Reps: 4 × 10\n\n"
				    + "3. **Remo cerrado en máquina**\n"
				    + "   - Objetivo: Espalda media y bíceps.\n"
				    + "   - Ejecución: Agarre cerrado, tira hacia el abdomen contrayendo omóplatos.\n"
				    + "   - Series/Reps: 4 × 10\n\n"
				    + "4. **Extensión de cuadríceps en máquina (una pierna)**\n"
				    + "   - Objetivo: Fuerza unilateral y equilibrio.\n"
				    + "   - Ejecución: Extiende una pierna a la vez, manteniendo tensión en el músculo.\n"
				    + "   - Series/Reps: 3 × 10 por pierna\n\n"
				    + "5. **Press militar en máquina**\n"
				    + "   - Objetivo: Hombros (deltoides) y tríceps.\n"
				    + "   - Ejecución: Respaldo ajustado, empuja hacia arriba sin bloquear codos.\n"
				    + "   - Series/Reps: 4 × 8\n\n"
				    + "6. **Curl femoral de pie**\n"
				    + "   - Objetivo: Isquiotibiales profundos.\n"
				    + "   - Ejecución: Apoya el talón en el rodillo, flexiona la pierna con control.\n"
				    + "   - Series/Reps: 3 × 12 por pierna\n\n"
				    + "7. **Abdominales en polea con cuerda**\n"
				    + "   - Objetivo: Core resistente.\n"
				    + "   - Ejecución: Arrodillado, lleva la cuerda hacia abajo contrayendo el abdomen.\n"
				    + "   - Series/Reps: 3 × 15\n\n"
				    + "--- PROGRESIÓN ---\n"
				    + "- Aumenta peso gradualmente (5-10% por semana).\n"
				    + "- Descanso: 60-90 segundos entre series.\n"
				    + "- Incluye superseries (ej: bíceps/tríceps).\n\n";
			 JOptionPane.showMessageDialog(null, mensaje_intermedia);
			
		
		} else if (respuesta.equalsIgnoreCase("NO")) {
			usarMaquinas = false;
			String mensaje_intermedia= "=== RUTINA INTERMEDIA (SIN MÁQUINAS) ===\n\n"
		    + "1. **Flexiones diamante**\n"
		    + "   - Objetivo: Tríceps y pecho (mayor intensidad).\n"
		    + "   - Ejecución: Manos juntas en forma de diamante, codos pegados al cuerpo.\n"
		    + "   - Series/Reps: 4 × 12\n\n"
		    + "2. **Sentadillas búlgaras (con silla o banco)**\n"
		    + "   - Objetivo: Piernas y equilibrio unilateral.\n"
		    + "   - Ejecución: Apoya un pie en un banco, baja hasta 90° en la rodilla delantera.\n"
		    + "   - Series/Reps: 3 × 10 por pierna\n\n"
		    + "3. **Dominadas asistidas (con banda elástica)**\n"
		    + "   - Objetivo: Espalda y brazos.\n"
		    + "   - Ejecución: Pisa la banda en una barra y colócala en las rodillas.\n"
		    + "   - Series/Reps: 4 × 8\n\n"
		    + "4. **Peso muerto con barra/mancuernas (o mochila cargada)**\n"
		    + "   - Objetivo: Cadena posterior (espalda baja, glúteos).\n"
		    + "   - Ejecución: Flexiona cadera (no espalda), mantén el peso cerca del cuerpo.\n"
		    + "   - Series/Reps: 4 × 10\n\n"
		    + "5. **Fondos en anillas o entre bancos**\n"
		    + "   - Objetivo: Tríceps y pecho (avanzado).\n"
		    + "   - Ejecución: Codos hacia atrás, baja hasta 90°.\n"
		    + "   - Series/Reps: 3 × 10\n\n"
		    + "6. **Plancha con elevación de pierna/brazo**\n"
		    + "   - Objetivo: Core y estabilidad.\n"
		    + "   - Ejecución: Alterna levantar una pierna o brazo durante 30 segundos.\n"
		    + "   - Series: 3\n\n"
		    + "7. **Saltos al cajón (o escalón alto)**\n"
		    + "   - Objetivo: Potencia en piernas.\n"
		    + "   - Ejecución: Salta explosivamente y aterriza suavemente.\n"
		    + "   - Series/Reps: 3 × 8\n\n"
		    + "--- PROGRESIÓN ---\n"
		    + "- Usa chaleco lastrado o mochila con peso para aumentar dificultad.\n"
		    + "- Descanso: 45-60 segundos.\n"
		    + "- Combina ejercicios en circuitos (ej: sentadillas + flexiones).";
			 JOptionPane.showMessageDialog(null, mensaje_intermedia);
			
			// }
		} else {
			JOptionPane.showMessageDialog(null, "Opcion desconocida");
			return;
		}
		
	}
	public static void Avanzada(boolean usarMaquina) {
		String respuesta = JOptionPane.showInputDialog(null, "¿Quiere usar maquina?(SI/NO");
		String mensaje = "";
		if (respuesta.equalsIgnoreCase("SI")) {
			usarMaquinas = true;
			String mensaje_avanzada = "=== RUTINA AVANZADA (CON MÁQUINAS) ===\n\n"
				    + "1. **Press de pecho en máquina con paradas isométricas**\n"
				    + "   - Objetivo: Máxima activación de fibras pectorales.\n"
				    + "   - Ejecución: Ajusta el peso al 80% de tu máximo. Haz pausas de 2 segundos a mitad del movimiento.\n"
				    + "   - Series/Reps: 4 × 6-8\n"
				    + "   - Descanso: 90 segundos\n\n"
				    + "2. **Prensa de piernas con carga excéntrica**\n"
				    + "   - Objetivo: Cuádriceps y glúteos (énfasis en fase negativa).\n"
				    + "   - Ejecución: Usa un 20% más de peso. Baja en 4 segundos, sube explosivamente.\n"
				    + "   - Series/Reps: 4 × 8\n\n"
				    + "3. **Jalón al pecho con sobrecarga excéntrica**\n"
				    + "   - Objetivo: Espalda ancha (mayor tiempo bajo tensión).\n"
				    + "   - Ejecución: Agarre prono. Tira rápido, baja en 5 segundos con ayuda de un compañero.\n"
				    + "   - Series/Reps: 4 × 6\n\n"
				    + "4. **Extensión de cuadríceps unilateral con rest-pause**\n"
				    + "   - Objetivo: Fuerza unilateral y resistencia.\n"
				    + "   - Ejecución: 8 repeticiones, descansa 15 segundos, repite hasta fallo.\n"
				    + "   - Series: 3 por pierna\n\n"
				    + "5. **Press militar en máquina con cluster sets**\n"
				    + "   - Objetivo: Hombros (deltoides anteriores y laterales).\n"
				    + "   - Ejecución: 5 repeticiones, descansa 10 segundos, otras 5 repeticiones.\n"
				    + "   - Series: 4\n\n"
				    + "6. **Curl femoral en máquina con técnica 1½**\n"
				    + "   - Objetivo: Isquiotibiales (mayor congestión).\n"
				    + "   - Ejecución: Haz una rep completa + media repetición sin extender del todo.\n"
				    + "   - Series/Reps: 3 × 10\n\n"
				    + "7. **Rotación rusa con polea (anti-rotación)**\n"
				    + "   - Objetivo: Core oblicuo y estabilidad.\n"
				    + "   - Ejecución: Usa polea baja, resiste la rotación manteniendo tensión.\n"
				    + "   - Series/Reps: 3 × 12 por lado\n\n"
				    + "--- TÉCNICAS AVANZADAS ---\n"
				    + "- **Drop sets**: Reduce peso tras el fallo (ej: en press de pecho).\n"
				    + "- **Isométricos**: Mantén la contracción 5 segundos en cada serie.\n"
				    + "- **Descanso activo**: 30 segundos de movilidad entre ejercicios.\n\n";
			 JOptionPane.showMessageDialog(null, mensaje_avanzada);
			
			
		} else if (respuesta.equalsIgnoreCase("NO")) {
			usarMaquinas = false;
			String mensaje_avanzada= "=== RUTINA AVANZADA (SIN MÁQUINAS) ===\n\n"
    + "1. **Flexiones con lastre y paradas en isométrico**\n"
    + "   - Objetivo: Pecho y tríceps (sobrecarga progresiva).\n"
    + "   - Ejecución: Usa chaleco lastrado o mochila con peso. Pausa 3 segundos abajo.\n"
    + "   - Series/Reps: 4 × 8\n\n"
    + "2. **Sentadillas pistol (a una pierna)**\n"
    + "   - Objetivo: Fuerza unilateral y equilibrio.\n"
    + "   - Ejecución: Pierna estirada al frente, baja hasta tocar el glúteo en el talón.\n"
    + "   - Series/Reps: 3 × 6 por pierna\n\n"
    + "3. **Dominadas explosivas con agarre mixto**\n"
    + "   - Objetivo: Espalda y potencia.\n"
    + "   - Ejecución: Sube rápido hasta que el pecho toque la barra.\n"
    + "   - Series/Reps: 4 × 5\n\n"
    + "4. **Peso muerto a una pierna con mancuernas**\n"
    + "   - Objetivo: Cadena posterior y equilibrio.\n"
    + "   - Ejecución: Pierna libre estirada atrás, baja el torso manteniendo la espalda recta.\n"
    + "   - Series/Reps: 3 × 8 por pierna\n\n"
    + "5. **Fondos en anillas con lastre**\n"
    + "   - Objetivo: Tríceps y pecho (inestabilidad añadida).\n"
    + "   - Ejecución: Añade peso con mochila. Baja hasta 90° con control.\n"
    + "   - Series/Reps: 4 × 8\n\n"
    + "6. **Plancha dinámica con desplazamientos**\n"
    + "   - Objetivo: Core funcional.\n"
    + "   - Ejecución: En posición de plancha, mueve manos/pies hacia los lados.\n"
    + "   - Series/Tiempo: 3 × 30 segundos\n\n"
    + "7. **Saltos pliométricos (cajón + profundos)**\n"
    + "   - Objetivo: Potencia explosiva.\n"
    + "   - Ejecución: Salta desde el suelo a un cajón, luego salta hacia abajo y rebota.\n"
    + "   - Series/Reps: 3 × 8\n\n"
    + "--- PROTOCOLO AVANZADO ---\n"
    + "- **Técnica 5x5**: 5 series de 5 repeticiones al 85% RM (ej: dominadas).\n"
    + "- **Pirámides**: Aumenta peso y reduce repeticiones cada serie.\n"
    + "- **Superseries antagonistas**: Ej: Flexiones + Remo con banda.\n"
    + "- **Material recomendado**: Mancuernas, chaleco lastrado (hasta 20 kg), anillas.";
			 JOptionPane.showMessageDialog(null, mensaje_avanzada);
		} else {
			JOptionPane.showMessageDialog(null, "Opcion desconocida");
			return;
		}
	}
	
	
}
