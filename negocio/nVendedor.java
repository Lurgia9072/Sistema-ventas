package negocio;

import java.util.ArrayList;

import datos.dVendedor;
import entidad.eVendedor;

public class nVendedor {
	dVendedor ObjDV;
	
	public eVendedor ValidarVendedor(String dni, String user){
		return ObjDV.ValidarVendedor(dni, user);
	}
	
	public nVendedor(){
		ObjDV = new dVendedor();
	}
	
	public ArrayList<eVendedor>Listar(){
		return ObjDV.Listar();
	}
	
	public eVendedor Buscar(String Id){
		return ObjDV.Buscar(Id);
	}
	
	public void Insertar(eVendedor ObjP){
		ObjDV.Insertar(ObjP);
	}
	
	public void Modificar(eVendedor ObjP){
		ObjDV.Modificar(ObjP);
	}
	
	public void Suprimir(String Id){
		ObjDV.Suprimir(Id);
	}
	
	public String GeneraCodigoVendedor() {
		return ObjDV.GeneraCodigoVendedor();
	}
}
