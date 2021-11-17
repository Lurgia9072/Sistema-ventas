package negocio;

import datos.dDetalleVentas;
import entidad.eDetalleVentas;


import java.util.ArrayList;

public class nDetalleVentas {

	dDetalleVentas ObjDV;
	
	public ArrayList<eDetalleVentas>Listar1(){
		return ObjDV.Listar1();
	}
	
	public void guardarDetalleVenta(eDetalleVentas ObjDv){
		ObjDV.guardarDetalleVenta(ObjDv);
	}
}
