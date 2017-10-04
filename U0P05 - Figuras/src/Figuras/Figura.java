package Figuras;

public abstract class Figura {
	
	private String titulo;
	private Color color;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "Figura [titulo=" + titulo + ", color=" + color + "]";
	}
	public abstract double area();
	public abstract double perimetro();
	
	
	
}
