package datos;

import entidad.eDetalleVentas;
import entidad.eProducto;

import java.sql.*;
import java.util.ArrayList;

public class dDetalleVentas {
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/jugueteria";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	
	//private int r=0;

	
	
	//METODO GUARDAR DETALLE VENTAS
	public void guardarDetalleVenta(eDetalleVentas ObjDv){
		String SQL = "call InsertarDetalleVenta(?,?,?,?,?)";
		try {
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, ObjDv.getIdDetalleVentas());
			Stmt.setString(2, ObjDv.getIdVenta());
			Stmt.setString(3, ObjDv.getIdProducto());
			Stmt.setInt(4, ObjDv.getCantidad());	
			Stmt.setDouble(5, ObjDv.getPrecioVenta());					
			Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR INSERTAR DETALLE VENTA:" + e.getMessage());
		}
		
	}
	
	
	private ArrayList<eDetalleVentas> miLista1;
	
	//Listar
	public ArrayList<eDetalleVentas> Listar1(){
		String SQL = "call ListarProductos()";
		miLista1 = new ArrayList<eDetalleVentas>();
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
					miLista1.add(new eDetalleVentas(Rs.getString("IdDetalleVentas"),
							Rs.getString("IdVenta"),
							Rs.getString("IdProducto"),
							Rs.getInt("Cantidad"),
							Rs.getDouble("PrecioVenta")));
				}
				Rs.close();				
		} catch (Exception e) {
			System.out.println("ERROR LISTAR PRODUCTOS:" + e.getMessage());
		}
		return miLista1;
	}
	
	
}
