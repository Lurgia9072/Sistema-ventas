package entidad;

public class eVendedor {
	private String IdVendedor;
	private String Dni;
	private String Nombres;
	private String Apellidos;
	private String Telefono;
	private String Usuario;
	private String Estado;
	
	public eVendedor() {

	}

	public eVendedor(String idVendedor, String dni, String nombres, String apellidos, String telefono, String usuario,
			String estado) {
		IdVendedor = idVendedor;
		Dni = dni;
		Nombres = nombres;
		Apellidos = apellidos;
		Telefono = telefono;
		Usuario = usuario;
		Estado = estado;
	}

	public String getIdVendedor() {
		return IdVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		IdVendedor = idVendedor;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
}
