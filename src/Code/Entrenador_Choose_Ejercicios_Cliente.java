package Code;
//El nombre es largo, puedo cambiarlo si se lo requiere, es solo para que se comprenda mejor el codigo.
public class Entrenador_Choose_Ejercicios_Cliente {
	//se crean los valores con los nombres: 
       private String ejercicio_basico;
       private String ejercicio_personalizado;
       
       
    //Constructor
	public Entrenador_Choose_Ejercicios_Cliente(String ejercicio_basico, String ejercicio_personalizado) {
		super();
		this.ejercicio_basico = ejercicio_basico;
		this.ejercicio_personalizado = ejercicio_personalizado;
	}

	//Get y set
	public String getEjercicio_basico() {
		return ejercicio_basico;
	}

	public void setEjercicio_basico(String ejercicio_basico) {
		this.ejercicio_basico = ejercicio_basico;
	}

	public String getEjercicio_personalizado() {
		return ejercicio_personalizado;
	}

	public void setEjercicio_personalizado(String ejercicio_personalizado) {
		this.ejercicio_personalizado = ejercicio_personalizado;
	}
  
	//Metodo sin retorno de Entrenamiento basico y personalizado
	//Agregado para que se entienda.
	public void EntrenamientoBasico(String texto) {
		//Imaginemos que aca en texto, ingresa el nombre predeterminado
		//Al agregarlo se fija si lo contiene, si es asi
		//es true
		//sino tira
		//false
	}
	public void Entrenamiento_Personalizado() {
		//Lo mismo pasa aca
	}
	
	@Override
	//ToString(lo que devuelve)
	public String toString() {
		return "Entrenador_Choose_Ejercicios_Cliente [ejercicio_basico=" + ejercicio_basico
				+ ", ejercicio_personalizado=" + ejercicio_personalizado + ", getEjercicio_basico()="
				+ getEjercicio_basico() + ", getEjercicio_personalizado()=" + getEjercicio_personalizado()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
       
}

//Fue pensado que ingrese el texto sea el entrenamiento que sea para que despues se aplique 
//lo que debe hacer 
//tanto si es entrenamiento basico o entrenamiento personalizado.
//Despues se hace una conversion si elige ejercicio1 del ejerciciobasico
//o ejercicio1 del ejerciciopersonalizado, etc.
//Ese es mi planteo, quedo ante tu entendimiento.


