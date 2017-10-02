package Figuras;

public class Triangulo {
	private double base;
	private double altura;
	
	public Triangulo(double base,double altura) {
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
	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + "]";
	}
	
	
}
