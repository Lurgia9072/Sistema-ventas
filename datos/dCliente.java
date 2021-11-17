package datos;

import entidad.eCliente;
import java.sql.*;
import java.util.ArrayList;

public class dCliente {

	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/jugueteria";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	private ArrayList<eCliente> miLista;
	
	public dCliente(){
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Clave);
		} catch (Exception e) {
			System.out.println("ERROR CONECCION:" + e.getMessage());
		}
	}
	
	//METODO LISTAR CLIENTE
	public ArrayList<eCliente> Listar(){
		String SQL = "call ListarClientes()";
		miLista = new ArrayList<eCliente>();
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				while(Rs.next()) {
					miLista.add(new eCliente(Rs.getString("IdCliente"),
							Rs.getString("Dni"),
							Rs.getString("Nombres"),
							Rs.getString("Apellidos"),
							Rs.getString("Telefono"),
							Rs.getString("Direccion"),
							Rs.getString("Estado")));
				}
				Rs.close();		
					
				System.out.println("puede listar");
		} catch (Exception e) {
			System.out.println("ERROR LISTAR CLIENTE:" + e.getMessage());
		}
		return miLista;
	}
	
	//Listar cliente con dni
	public eCliente BuscarDNI(String Dni){
		String SQL = "select*from cliente where Dni=?";
		eCliente ObjC = null;
		try{
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, Dni);
			Rs = Stmt.executeQuery();
				if(Rs.next()) {
				ObjC = new eCliente(Rs.getString("IdCliente"),
						Rs.getString("Dni"),
						Rs.getString("Nombres"),
						Rs.getString("Apellidos"),
						Rs.getString("Telefono"),
						Rs.getString("Direccion"),
						Rs.getString("Estado"));
			}
				Rs.close();
		}catch(Exception e){			
			System.out.println("ERROR BUSCAR DNI CLIENTE:" + e.getMessage());
		}
		return ObjC;
	}
		
	//METODO BUSCAR CLIENTE
	public eCliente Buscar(String Id){
		String SQL = "call BuscarCliente(?)";
		eCliente ObjC = null;
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
					if(Rs.next()) {
					ObjC = new eCliente(Rs.getString("IdCliente"),
							Rs.getString("Dni"),
							Rs.getString("Nombres"),
							Rs.getString("Apellidos"),
							Rs.getString("Telefono"),
							Rs.getString("Direccion"),
							Rs.getString("Estado"));
				}
				Rs.close();
				//System.out.println("pude buscar");
		} catch (Exception e) {
			System.out.println("ERROR BUSCAR CLIENTE:" + e.getMessage());
		}
		return ObjC;
	}	
	
	//METODO INSERTAR CLIENTE
	public void Insertar(eCliente ObjC){
		String SQL = "call InsertarCliente(?,?,?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjC.getIdCliente());
				Stmt.setString(2, ObjC.getDni());
				Stmt.setString(3, ObjC.getNombres());
				Stmt.setString(4, ObjC.getApellidos());
				Stmt.setString(5, ObjC.getTelefono());
				Stmt.setString(6, ObjC.getDireccion());
				Stmt.setString(7, ObjC.getEstado());
				Stmt.executeUpdate();
						
				System.out.println("puede insertar");
		} catch (Exception e) {
				System.out.println("ERROR INSERTAR CLIENTE:" + e.getMessage());
		}
	}
	
	//METODO MODIFICAR CLIENTE
	public void Modificar(eCliente ObjC){
		String SQL = "call ModificaCliente(?,?,?,?,?,?,?)";
		try {
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, ObjC.getIdCliente());
			Stmt.setString(2, ObjC.getDni());
			Stmt.setString(3, ObjC.getNombres());
			Stmt.setString(4, ObjC.getApellidos());
			Stmt.setString(5, ObjC.getTelefono());
			Stmt.setString(6, ObjC.getDireccion());
			Stmt.setString(7, ObjC.getEstado());
			Stmt.executeUpdate();
			
			System.out.println("puede modificar");
		} catch (Exception e) {
				System.out.println("ERROR MODIFICAR PRODUCTO:" + e.getMessage());
		}
	}
	
	//METODO SUPRIMIR CLIENTE
	public void Suprimir(String Id){
		String SQL = "call SuprimirCliente(?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Stmt.executeUpdate();
				
				System.out.println("puede eliminar");
		} catch (Exception e) {
				System.out.println("ERROR SUPRIMIR CLIENTE:" + e.getMessage());
		}
	}
	
	//METODO PARA GENERAR CODIGO
	public String GeneraCodigoCliente() {
		String SQL = "call  GenerarCodigoCliente()", nuevo = "";
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				if(Rs.next()) {
						nuevo = Rs.getString(1);
				}
				Rs.close();
				
				System.out.println("puede generar cod");
		} catch (Exception e) {
			System.out.println("ERROR GENERAR CODIGO:" + e.getMessage());
		}
		return nuevo;
	}
}
