package datos;

import entidad.eVentas;
import java.sql.*;
//import java.util.ArrayList;

public class dVentas {

	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/jugueteria";
	private String Usuario = "root";	
	private String Clave = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	//private ArrayList<eVentas> miLista;
	
	private int r=0;
	
	public dVentas(){
		try {
			Class.forName(Driver);
			Cn = DriverManager.getConnection(URL, Usuario, Clave);
		} catch (Exception e) {
			System.out.println("ERROR CONECCION:" + e.getMessage());
		}
	}
	
	//LISTAR VENTAS
	
	
	//ID VENTA 
	public String IdVenta(){
		String idv="";
		String SQL ="select max(IdVenta)from venta";
		try{
		Cmd = Cn.createStatement();
		Rs = Cmd.executeQuery(SQL);
		while(Rs.next()){
			idv=Rs.getString(1);
		}
		}catch(Exception e){
			System.out.println("ERROR ID VENTA:" + e.getMessage());
		}
		return null;
	}
	
	//METODO GUARDAR VENTAS
	public void guardarVenta(eVentas ObjVt){
		eVentas ventas= new eVentas();
		String SQL = "call InsertarVenta(?,?,?,?,?,?,?)";
		try {
			Stmt = Cn.prepareCall(SQL);
			Stmt.setString(1, ObjVt.getIdVenta());
			Stmt.setString(2, ObjVt.getIdCliente());
			Stmt.setString(3, ObjVt.getIdVendedor());
			Stmt.setString(4, ObjVt.getNumeroVenta());
			Stmt.setString(5, ObjVt.getFechaVenta());	
			Stmt.setDouble(6, ObjVt.getMonto());	
			Stmt.setString(7, ObjVt.getEstado());				
			Stmt.executeUpdate();
			System.out.print("intento guargar");
		} catch (Exception e) {
				System.out.println("ERROR INSERTAR VENTA:" + e.getMessage());
		}
		
	}
	

	
}
