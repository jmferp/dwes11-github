package Figuras;
/**
 * @author Jose Maria Fernandez Parra
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorFiguras{
	/**
	 * Lista de figuras
	 */
	private ArrayList<Figura> arFig;
	
	/**
	 * Constructor de las figuras
	 */
	public GestorFiguras() {
		this.arFig= new ArrayList<Figura>();
	}
	
	/**
	 * 
	 * metodo para anadir un figura al arraylist
	 */
	public void anadirFigura(Figura fig) {
		boolean enc=false;
		for(int i=0;i<arFig.size();i++) {
			if(arFig.get(i).getTitulo().equalsIgnoreCase(fig.getTitulo())) {
				enc=true;
			}
		}
		if(!enc) {
		arFig.add(fig);
		}
	}
	
	/**
	 * 
	 * @param tit introduciendo un titulo eliminamos la figura del arraylist
	 */
	public void eliminarFigura(String tit) {
		for(int i=0;i<arFig.size();i++) {
			if(arFig.get(i).getTitulo().equalsIgnoreCase(tit)) {
				arFig.remove(i);
			}
		}
	}
	
	/**
	 * metodo para mostrar el contenido del arraylist
	 */
	public void mostrarFiguras() {
		for(int i=0;i<arFig.size();i++) {
			System.out.println(arFig.get(i).toString());;
		}
		
	}
	
	/**
	 * 
	 * @return metodo que devuelve la suma de todas las areas de las figuras del arraylist
	 */
	public double calcularSumatorioAreas(){
		double suma=0;
		for(int i=0;i<arFig.size();i++) {
			suma=suma+(arFig.get(i).area());
		}
		return suma;
	}
	
	
}
