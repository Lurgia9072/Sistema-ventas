package datos;

import entidad.eVendedor;
import java.sql.*;
import java.util.ArrayList;


public class dVendedor {

	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/jugueteria";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<eVendedor> miLista;
	
	public dVendedor(){
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Clave);
		} catch (Exception e) {
			System.out.println("ERROR CONECCION:" + e.getMessage());
		}
	}
	
	//METODO PARA VALIDAR VENDEDOR EN EL LOGIN
	public eVendedor ValidarVendedor(String dni, String user){
		String SQL = "call VerificarVendedor(?,?)";
		eVendedor ObjV = null;
		try{
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, dni);
			Stmt.setString(2, user);
			Rs = Stmt.executeQuery();
			if(Rs.next()) {
				ObjV = new eVendedor(Rs.getString("IdVendedor"),
						Rs.getString("Dni"),
						Rs.getString("Nombres"),
						Rs.getString("Apellidos"),
						Rs.getString("Telefono"),
						Rs.getString("Estado"),
						Rs.getString("Usuario"));
			}
			Rs.close();
			
		}catch(Exception e){
			System.out.println("ERROR VALIDAR VENDEDOR:" + e.getMessage());
		}
		return ObjV;
	}
	
	//METODO LISTAR VENDEDORES
	public ArrayList<eVendedor> Listar(){
		String SQL = "call ListarVendedores();";
		miLista = new ArrayList<eVendedor>();
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
					miLista.add(new eVendedor(Rs.getString("IdVendedor"),
							Rs.getString("Dni"),
							Rs.getString("Nombres"),
							Rs.getString("Apellidos"),
							Rs.getString("Telefono"),
							Rs.getString("Estado"),
							Rs.getString("Usuario")));
				}
				Rs.close();				
		} catch (Exception e) {
			System.out.println("ERROR LISTAR VENDEDORES:" + e.getMessage());
		}
		return miLista;
	}
	
	//METODO BUSCAR VENDEDOR
	public eVendedor Buscar(String Id){
		String SQL = "call BuscarVendedor(?)";
		eVendedor ObjV = null;
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
				if(Rs.next()) {
					ObjV = new eVendedor(Rs.getString("IdVendedor"),
							Rs.getString("Dni"),
							Rs.getString("Nombres"),
							Rs.getString("Apellidos"),
							Rs.getString("Telefono"),
							Rs.getString("Estado"),
							Rs.getString("Usuario"));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR BUSCAR VENDEDOR:" + e.getMessage());
		}
		return ObjV;
	}
	
	//METODO INSERTAR VENDEDOR
	public void Insertar(eVendedor ObjV){
		String SQL = "call InsertarVendedor(?,?,?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjV.getIdVendedor());
				Stmt.setString(2, ObjV.getDni());
				Stmt.setString(3, ObjV.getNombres());
				Stmt.setString(4, ObjV.getApellidos());
				Stmt.setString(5, ObjV.getTelefono());	
				Stmt.setString(6, ObjV.getEstado());
				Stmt.setString(7, ObjV.getUsuario());
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR INSERTAR VENDEDOR:" + e.getMessage());
		}
	}
	
	//METODO MODIFICAR VENDEDOR
	public void Modificar(eVendedor ObjV){
		String SQL = "call ModificaVendedor(?,?,?,?,?,?,?)";
		try {
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, ObjV.getIdVendedor());
			Stmt.setString(2, ObjV.getDni());
			Stmt.setString(3, ObjV.getNombres());
			Stmt.setString(4, ObjV.getApellidos());
			Stmt.setString(5, ObjV.getTelefono());	
			Stmt.setString(6, ObjV.getEstado());
			Stmt.setString(7, ObjV.getUsuario());
			Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR MODIFICAR VENDEDOR:" + e.getMessage());
		}
	}
	
	//METODO SUPRIMIR VENDEDOR
	public void Suprimir(String Id){
		String SQL = "call SuprimirVendedor(?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR SUPRIMIR VENDEDOR:" + e.getMessage());
		}
	}
	
	//METODO PARA GENERAR CODIGO VENDEDOR
	public String GeneraCodigoVendedor() {
		String SQL = "call GenerarCodigoVendedor()", nuevo = "";
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				if(Rs.next()) {
						nuevo = Rs.getString(1);
				}
				Rs.close();
		} catch (Exception e) {
			System.out.println("ERROR GENERAR CODIGO VENDEDOR:" + e.getMessage());
		}
		return nuevo;
	}
}
