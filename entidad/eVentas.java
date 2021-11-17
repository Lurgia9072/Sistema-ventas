package entidad;

//import java.sql.Date;

public class eVentas {
	private String IdVenta;
	private String IdCliente;
	private String IdVendedor;
	private String NumeroVenta;
	private String FechaVenta;
	private double Monto;
	private String Estado;
	
	public eVentas() {
		
	}

	public eVentas(String idVenta, String idCliente, String idVendedor, String numeroVenta, String fechaVenta,
			double monto, String estado) {
		IdVenta = idVenta;
		IdCliente = idCliente;
		IdVendedor = idVendedor;
		NumeroVenta = numeroVenta;
		FechaVenta = fechaVenta;
		Monto = monto;
		Estado = estado;
	}

	public String getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(String idVenta) {
		IdVenta = idVenta;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getIdVendedor() {
		return IdVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		IdVendedor = idVendedor;
	}

	public String getNumeroVenta() {
		return NumeroVenta;
	}

	public void setNumeroVenta(String numeroVenta) {
		NumeroVenta = numeroVenta;
	}

	public String getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		FechaVenta = fechaVenta;
	}

	public double getMonto() {
		return Monto;
	}

	public void setMonto(double monto) {
		Monto = monto;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
}
