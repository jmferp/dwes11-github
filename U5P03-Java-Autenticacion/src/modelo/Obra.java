package modelo;
public class Obra {
	
	private String id_obra;
	private String titulo;
    private String id_autor;
    private String genero;
    private String descripcion;
    private String año;
    private String imagen;
    private String nombre;
    
    
	public String getId_obra() {
		return id_obra;
	}
	public void setId_obra(String id_obra) {
		this.id_obra = id_obra;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getId_autor() {
		return id_autor;
	}
	public void setId_autor(String id_autor) {
		this.id_autor = id_autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Obra(String id_obra, String titulo, String id_autor, String genero, String descripcion, String año,
			String imagen, String nombre) {
		super();
		this.id_obra = id_obra;
		this.titulo = titulo;
		this.id_autor = id_autor;
		this.genero = genero;
		this.descripcion = descripcion;
		this.año = año;
		this.imagen = imagen;
		this.nombre = nombre;
	}
}

