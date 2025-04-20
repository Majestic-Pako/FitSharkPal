package Code;
public class Entrenador_Choose_Ejercicios_Cliente {
	private double peso;
	private double altura;
	private String plan;
	public Entrenador_Choose_Ejercicios_Cliente(double peso, double altura, String plan) {
		super();
		this.peso = peso;
		this.altura = altura;
		this.plan = plan;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	@Override
	public String toString() {
		return "Entrenador_Choose_Ejercicios_Cliente [peso=" + peso + ", altura=" + altura + ", plan=" + plan
				+ ", getPeso()=" + getPeso() + ", getAltura()=" + getAltura() + ", getPlan()=" + getPlan()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}


