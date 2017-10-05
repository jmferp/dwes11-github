package Figuras;
/**
 * 
 * @author Jose Maria Fernandez Parra
 *
 */

public class Cuadrado extends Figura {
	private double lado;
	/**
	 * 
	 * @param titulo Nombre de la figura
	 * @param color Color de la figura
	 * @param lado Longitud del lado
	 */
	public Cuadrado(String titulo,Color color,double lado) {
		super.setTitulo(titulo);
		super.setColor(color);
		this.lado=lado;
	}
	/**
	 * 
	 * @return Constructor del cuadrado
	 */

	public double getLado() {
		return lado;
	}
	/**
	 * 
	 * @param lado metodo para obtener el lado
	 */

	public void setLado(double lado) {
		this.lado = lado;
	}
	/**
	 * Metodos getter y setter del cuadrado
	 */
	
	public double area(){
		return this.getLado()*this.getLado();
	}
	/**
	 * @return Metodo para calcular area
	 */
	
	public double perimetro() {
		return this.getLado()*4;
	}
	/**
	 * @return Metodo para calcular perimetro
	 */

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", getTitulo()=" + getTitulo() + ", getColor()=" + getColor() + "]";
	}
	/**
	 * @return Metodo para sacar sus datos
	 */
	

	
	
	

}
