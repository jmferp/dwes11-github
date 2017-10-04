package Figuras;

public class Circunferencia extends Figura{
	private double radio;

	public Circunferencia(String titulo,Color color,double radio) {
		super.setTitulo(titulo);
		super.setColor(color);
		this.radio=radio;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double area() {
		return Math.PI*Math.pow(this.radio, 2);
	}
	
	public double perimetro() {
		return 2*Math.PI*this.radio;
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + ", getTitulo()=" + getTitulo() + ", getColor()=" + getColor() + "]";
	}

	
	
}
