package Figuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorFiguras implements Comparable{

	private ArrayList<Figura> arFig;
	
	public GestorFiguras() {
		this.arFig= new ArrayList<Figura>();
	}
	
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
	
	public void eliminarFigura(String tit) {
		for(int i=0;i<arFig.size();i++) {
			if(arFig.get(i).getTitulo().equalsIgnoreCase(tit)) {
				arFig.remove(i);
			}
		}
	}
	
	public void mostrarFiguras() {
		Collections.sort();
		
	}

	public int compareTo(Figura fig) {
		       
		return 0;
	}
	
	
}
