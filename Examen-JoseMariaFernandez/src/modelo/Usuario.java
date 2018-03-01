package modelo;

public class Usuario {
	private String login;
	private String password;
	private String nombre;
	private double gasto;
	private String direccion;
	public Usuario(String login, String password, String nombre, double gasto, String direccion) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.gasto = gasto;
		this.direccion = direccion;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getGasto() {
		return gasto;
	}
	public void setGasto(double gasto) {
		this.gasto = gasto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "<p><ul><li>login:" + login + "</li><li> password: " + password + "</li><li> nombre: " + nombre + "</li><li> gasto: "
		+ gasto + "</li><li> direccion: "+ direccion +"</li></p></ul>";
	}
	
	
	

}
