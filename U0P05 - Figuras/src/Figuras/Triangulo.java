package Figuras;

public class Triangulo extends Figura {
	private double base;
	private double altura;
	
	public Triangulo(String titulo,Color color,double base,double altura) {
		super.setTitulo(titulo);
		super.setColor(color);
		this.base=base;
		this.altura=altura;
	}
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double area() {
		return this.getBase()*this.getAltura()/2;
	}
	
	public double perimetro() {
		return (Math.sqrt(Math.pow(this.getBase(), 2)+(Math.pow(this.getAltura(), 2))));
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", getTitulo()=" + getTitulo() + ", getColor()="
				+ getColor() + "]";
	}
	
	
}
