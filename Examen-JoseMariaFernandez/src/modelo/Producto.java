package modelo;

public class Producto {
	private int idproducto;
	private String nombre;
	private String marca;
	private double precio;
	private int stock;
	private String descripcion;
	private String imagen;
	private String familia;
	private int ubicacion;
	
	public Producto(int idproducto, String nombre, String marca, double precio, int stock, String descripcion,
			String imagen, String familia, int ubicacion) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.familia = familia;
		this.ubicacion = ubicacion;
	}
	
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public int getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}
