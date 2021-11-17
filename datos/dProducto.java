package datos;

import entidad.eProducto;
import java.sql.*;
import java.util.ArrayList;


public class dProducto {

	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/jugueteria";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<eProducto> miLista;
	
	public dProducto(){
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Clave);
		} catch (Exception e) {
			System.out.println("ERROR CONECCION:" + e.getMessage());
		}
	}
	
	//METODO LISTAR PRODUCTOS
	public ArrayList<eProducto> Listar(){
		String SQL = "call ListarProductos()";
		miLista = new ArrayList<eProducto>();
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
					miLista.add(new eProducto(Rs.getString("IdProducto"),
							Rs.getString("Descripcion"),
							Rs.getDouble("Precio"),
							Rs.getInt("Stock"),
							Rs.getString("Estado")));
				}
				Rs.close();				
		} catch (Exception e) {
			System.out.println("ERROR LISTAR PRODUCTOS:" + e.getMessage());
		}
		return miLista;
	}
	
	//METODO BUSCAR PRODUCTO
	public eProducto Buscar(String Id){
		String SQL = "call BuscarProducto(?)";
		eProducto ObjP = null;
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
				if(Rs.next()) {
					ObjP = new eProducto(Rs.getString("IdProducto"),
							Rs.getString("Descripcion"),
							Rs.getDouble("Precio"),
							Rs.getInt("Stock"),
							Rs.getString("Estado"));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR BUSCAR PRODUCTO:" + e.getMessage());
		}
		return ObjP;
	}
	
	//METODO INSERTAR PRODUCTO
	public void Insertar(eProducto ObjP){
		String SQL = "call InsertarProducto(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjP.getIdProducto());
				Stmt.setString(2, ObjP.getDescripcion());
				Stmt.setDouble(3, ObjP.getPrecio());
				Stmt.setInt(4, ObjP.getStock());
				Stmt.setString(5, ObjP.getEstado());				
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR INSERTAR PRODUCTO:" + e.getMessage());
		}
	}
	
	//METODO MODIFICAR PRODUCTO
	public void Modificar(eProducto ObjP){
		String SQL = "call ModificaProducto(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjP.getIdProducto());
				Stmt.setString(2, ObjP.getDescripcion());
				Stmt.setDouble(3, ObjP.getPrecio());
				Stmt.setInt(4, ObjP.getStock());
				Stmt.setString(5, ObjP.getEstado());
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR MODIFICAR PRODUCTO:" + e.getMessage());
		}
	}
	
	//METODO SUPRIMIR PRODUCTO
	public void Suprimir(String Id){
		String SQL = "call SuprimirProducto(?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR SUPRIMIR PRODUCTO:" + e.getMessage());
		}
	}
	
	//METODO PARA GENERAR CODIGO
	public String GeneraCodigoProducto() {
		String SQL = "call GenerarCodigoProducto()", nuevo = "";
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				if(Rs.next()) {
						nuevo = Rs.getString(1);
				}
				Rs.close();
		} catch (Exception e) {
			System.out.println("ERROR GENERAR CODIGO:" + e.getMessage());
		}
		return nuevo;
	}
	
	//LISTA PARA MOSTRAR EN GENERAR VENTAR
	
	
}
