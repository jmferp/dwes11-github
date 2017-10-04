package Figuras;

public class Cuadrado extends Figura {
	private double lado;

	public Cuadrado(String titulo,Color color,double lado) {
		super.setTitulo(titulo);
		super.setColor(color);
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double area(){
		return this.getLado()*this.getLado();
	}
	
	public double perimetro() {
		return this.getLado()*4;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", getTitulo()=" + getTitulo() + ", getColor()=" + getColor() + "]";
	}
	

	
	
	

}
