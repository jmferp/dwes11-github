package modelo;

public class Ubicacion {
	private int idubicacion;
	private int pasillo;
	private int modulo;
	private int altura;
	private int hueco;
	
	public Ubicacion(int idubicacion, int pasillo, int modulo, int altura, int hueco) {
		super();
		this.idubicacion = idubicacion;
		this.pasillo = pasillo;
		this.modulo = modulo;
		this.altura = altura;
		this.hueco = hueco;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	public int getPasillo() {
		return pasillo;
	}

	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getHueco() {
		return hueco;
	}

	public void setHueco(int hueco) {
		this.hueco = hueco;
	}
	
	
	
}
