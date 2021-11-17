package negocio;

import datos.dProducto;
import entidad.eProducto;
import java.util.ArrayList;


public class nProducto {
	dProducto ObjDP;
	
	public nProducto(){
		ObjDP = new dProducto();
	}
	
	public ArrayList<eProducto>Listar(){
		return ObjDP.Listar();
	}
	
	public eProducto Buscar(String Id){
		return ObjDP.Buscar(Id);
	}
	
	public void Insertar(eProducto ObjP){
		ObjDP.Insertar(ObjP);
	}
	
	public void Modificar(eProducto ObjP){
		ObjDP.Modificar(ObjP);
	}
	
	public void Suprimir(String Id){
		ObjDP.Suprimir(Id);
	}
	
	public String GeneraCodigoProducto() {
		return ObjDP.GeneraCodigoProducto();
	}
}
