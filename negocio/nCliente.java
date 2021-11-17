package negocio;

import java.util.ArrayList;
import datos.dCliente;
import entidad.eCliente;

public class nCliente {
	 dCliente ObjDC;
	 
		public nCliente(){
			ObjDC = new dCliente();
		}
		
		public ArrayList<eCliente>Listar(){
			return ObjDC.Listar();
		}
		
		public eCliente BuscarDNI(String Dni){
			return ObjDC.BuscarDNI(Dni);
		}
		
		public eCliente Buscar(String Id){
			return ObjDC.Buscar(Id);
		}
		
		public void Insertar(eCliente ObjP){
			ObjDC.Insertar(ObjP);
		}
		
		public void Modificar(eCliente ObjP){
			ObjDC.Modificar(ObjP);
		}
		
		public void Suprimir(String Id){
			ObjDC.Suprimir(Id);
		}
		
		public String GeneraCodigoCliente() {
			return ObjDC.GeneraCodigoCliente();
		}
}
