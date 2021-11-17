package vista;

//CLIENTE
import datos.dCliente;
import entidad.eCliente;
import negocio.nCliente;
//VENDEDOR
import negocio.nVendedor;
//PRODUCTO
import entidad.eProducto;
import datos.dProducto;
import negocio.nProducto;

//DETALLE VENTAS
import entidad.eDetalleVentas;
import datos.dDetalleVentas;
import negocio.nDetalleVentas;

//vwntas
import datos.dVentas;
import entidad.eVentas;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSpinner;

public class GenerarVenta extends JInternalFrame {
	
	nCliente ObjNC = new nCliente();
	nProducto ObjNP = new nProducto();
	
	eProducto ObjP = new eProducto();
	eDetalleVentas ObjNDV = new eDetalleVentas();
	
	
	String IdProd;
	
	

	
	Object Columnas[] = {"item","codProd","Producto","Cant","PreUni","Total"};
	
	DefaultTableModel modelo= new DefaultTableModel(Columnas,0);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtNroVenta;
	private JTextField txtDniCliente;
	private JTextField txtCodPro;
	private JTextField txtPrePro;
	private JTextField txtFecha;
	private JPanel panel_1;
	private JTable miTabla;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JTextField txtPagar;
	private JTextField txtCliente;
	private JTextField txtProducto;
	private JTextField txtStock;
	private JButton btnCancelar;
	private JButton btnGenerarVenta;
	private JSpinner txtCantidad;
	private JTextField txtVendedor;
	private JButton btnAgregar;
	private JButton btnBuscarP;
	private JButton btnBuscarC;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarVenta frame = new GenerarVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	
	
	public GenerarVenta() {

		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon(GenerarVenta.class.getResource("/img/logo20p.jpg")));
		setTitle("Generar Venta");
		setBounds(100, 100, 655, 578);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 619, 147);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/logo100p.jpg")));
		label.setBounds(40, 21, 100, 100);
		panel.add(label);
		
		JLabel lblPuntoDeVenta = new JLabel("PUNTO DE VENTA SDEKI");
		lblPuntoDeVenta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPuntoDeVenta.setBounds(199, 11, 224, 27);
		panel.add(lblPuntoDeVenta);
		
		JLabel lblJugueteria = new JLabel("JUGUETERIA");
		lblJugueteria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJugueteria.setBounds(255, 49, 100, 14);
		panel.add(lblJugueteria);
		
		JLabel lblAlPorMayor = new JLabel("AL POR MAYOR Y MENOR");
		lblAlPorMayor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlPorMayor.setBounds(226, 74, 153, 14);
		panel.add(lblAlPorMayor);
		
		JLabel lblNro = new JLabel("Nro:");
		lblNro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNro.setBounds(210, 99, 59, 22);
		panel.add(lblNro);
		
		txtNroVenta = new JTextField();
		txtNroVenta.setBounds(267, 101, 86, 20);
		panel.add(txtNroVenta);
		txtNroVenta.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 169, 619, 128);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDniCliente = new JLabel("DNI CLIENTE");
		lblDniCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDniCliente.setBounds(10, 11, 104, 14);
		panel_1.add(lblDniCliente);
		
		JLabel lblCodProduto = new JLabel("COD. PRODUTO");
		lblCodProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodProduto.setBounds(10, 38, 104, 14);
		panel_1.add(lblCodProduto);
		
		JLabel lblPreProducto = new JLabel("PRECIO PROD.");
		lblPreProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPreProducto.setBounds(10, 64, 104, 14);
		panel_1.add(lblPreProducto);
		
		JLabel lblCantidadProd = new JLabel("CANTIDAD PROD.");
		lblCantidadProd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadProd.setBounds(10, 89, 104, 14);
		panel_1.add(lblCantidadProd);
		
		txtDniCliente = new JTextField();
		txtDniCliente.setBounds(111, 11, 112, 20);
		panel_1.add(txtDniCliente);
		txtDniCliente.setColumns(10);
		
		txtCodPro = new JTextField();
		txtCodPro.setBounds(111, 39, 112, 20);
		panel_1.add(txtCodPro);
		txtCodPro.setColumns(10);
		
		txtPrePro = new JTextField();
		txtPrePro.setBounds(111, 66, 112, 20);
		panel_1.add(txtPrePro);
		txtPrePro.setColumns(10);
		
		btnBuscarC = new JButton("Buscar");
		btnBuscarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscarCliente(e);
			}
		});
		btnBuscarC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarC.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/buscarCliente.png")));
		btnBuscarC.setBounds(233, 8, 105, 23);
		panel_1.add(btnBuscarC);
		
		btnBuscarP = new JButton("Buscar");
		btnBuscarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscarProducto(e);
			}
		});
		btnBuscarP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarP.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/buscarProducto.png")));
		btnBuscarP.setBounds(233, 35, 105, 23);
		panel_1.add(btnBuscarP);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregarProducto(e);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregar.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/agregarCompra.png")));
		btnAgregar.setBounds(233, 61, 105, 23);
		panel_1.add(btnAgregar);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(233, 90, 105, 20);
		panel_1.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCliente.setBounds(348, 11, 75, 14);
		panel_1.add(lblCliente);
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProducto.setBounds(348, 38, 75, 14);
		panel_1.add(lblProducto);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStock.setBounds(348, 64, 75, 14);
		panel_1.add(lblStock);
		
		JLabel lblVendedor = new JLabel("VENDEDOR");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVendedor.setBounds(348, 89, 75, 14);
		panel_1.add(lblVendedor);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(433, 11, 176, 20);
		panel_1.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(433, 36, 176, 20);
		panel_1.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(433, 63, 176, 20);
		panel_1.add(txtStock);
		txtStock.setColumns(10);
		
		txtVendedor = new JTextField();
		txtVendedor.setBounds(433, 88, 176, 20);
		panel_1.add(txtVendedor);
		txtVendedor.setColumns(10);
		
		txtCantidad = new JSpinner();
		txtCantidad.setBounds(124, 90, 99, 20);
		panel_1.add(txtCantidad);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 308, 619, 170);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 599, 148);
		panel_2.add(scrollPane);
		
		miTabla = new JTable();
		//agregado
		miTabla.setModel(modelo);
		scrollPane.setViewportView(miTabla);
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 489, 619, 48);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/CancelarCompra.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(41, 11, 108, 23);
		panel_3.add(btnCancelar);
		
		btnGenerarVenta = new JButton("Generar Venta");
		btnGenerarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnGenerarVenta(e);
			}
		});
		btnGenerarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerarVenta.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/GenerarVenta.png")));
		btnGenerarVenta.setBounds(178, 11, 159, 23);
		panel_3.add(btnGenerarVenta);
		
		txtPagar = new JTextField();
		txtPagar.setBounds(523, 12, 86, 20);
		panel_3.add(txtPagar);
		txtPagar.setColumns(10);
		
		JLabel lblTotalAPagar = new JLabel("TOTAL A PAGAR");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalAPagar.setIcon(new ImageIcon(GenerarVenta.class.getResource("/img/totalPagar.png")));
		lblTotalAPagar.setBounds(373, 15, 140, 19);
		panel_3.add(lblTotalAPagar);
		
		//FECHA 
		Calendar calendar=new GregorianCalendar();
		txtFecha.setText(""+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
		
		
		//CargarTabla();

	}
	
	//BOTON BUSCAR CLIENTE este vale revisar bprod
	protected void actionPerformedBtnBuscarCliente(ActionEvent e){
		eCliente ObjC = new eCliente();
		ObjC=ObjNC.Buscar(txtDniCliente.getText());
		
		if(txtDniCliente.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar dni cliente");
		}else {			
			if(ObjC !=null){
				txtCliente.setText(ObjC.getNombres()+ObjC.getApellidos());				
			}else{	
				int r=JOptionPane.showConfirmDialog(this, "Cliente no encontrado, desea registrar?");
				if(r==0){
					Cliente c= new Cliente();
					MenuPrincipal.desktopPane.add(c);
					c.setVisible(true);
				}
				txtDniCliente.setText("");
				txtDniCliente.requestFocus();
			}
		}		
	}
	
	//BOTON BUSCAR PRODUCTO
	protected void actionPerformedBtnBuscarProducto(ActionEvent e){
		eProducto ObjP = new eProducto();
		ObjP=ObjNP.Buscar(txtCodPro.getText());
		
		if(txtCodPro.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Debe ingresar codigo de producto");
		}else{
			if(ObjP !=null){
				txtProducto.setText(ObjP.getDescripcion());
				txtPrePro.setText(""+ObjP.getPrecio());
				txtStock.setText(""+ObjP.getStock());
			}else{
				JOptionPane.showMessageDialog(null, "Producto no registrado");
				txtCodPro.setText("");
				txtCodPro.requestFocus();
			}
		}
	}
	
	//BOTON AGREGAR PRODUCTO 
	protected void actionPerformedBtnAgregarProducto(ActionEvent e){
		eDetalleVentas ObjDV = new eDetalleVentas();
		eProducto ObjP = new eProducto();
		//System.out.print(ObjDV);
		
		double total;
		int item=0;
		modelo=(DefaultTableModel)miTabla.getModel();
		item=item+1;
		
		IdProd=txtCodPro.getText();
		//IdProd=ObjP.getIdProducto();
		String nomProd=txtProducto.getText();
		double preProd=Double.parseDouble(txtPrePro.getText());
		int cantProd=Integer.parseInt(txtCantidad.getValue().toString());
		total=cantProd*preProd;
		int stock= Integer.parseInt(txtStock.getText());
		
			
		ArrayList listaP = new ArrayList();
		if(stock>0){
			//listaP.add(ObjDV.getCantidad());
			listaP.add(item);
			//listaP.add(txtCliente.getText());
			listaP.add(IdProd);
			listaP.add(nomProd);
			listaP.add(cantProd);
			listaP.add(preProd);
			listaP.add(total);
			Object[]ob=new Object[6];
			ob[0]=listaP.get(0);
			ob[1]=listaP.get(1);
			ob[2]=listaP.get(2);
			ob[3]=listaP.get(3);
			ob[4]=listaP.get(4);
			ob[5]=listaP.get(5);
			
			eVentas ObjEV = new eVentas();
			ObjEV.setIdVenta("12345678");
			ObjEV.setIdCliente(txtDniCliente.getText());
			ObjEV.setIdVendedor(txtVendedor.getText());
			ObjEV.setNumeroVenta("87654321");
			ObjEV.setFechaVenta(txtFecha.getText());
			ObjEV.setMonto(Double.parseDouble(txtPagar.getText()));
			ObjEV.setEstado("1");
			dVentas ObjV = new dVentas();
			ObjV.guardarVenta(ObjEV);
			
			modelo.addRow(ob);
			miTabla.setModel(modelo);
		}else{
			JOptionPane.showMessageDialog(null, "Stock no disponible");
		}
		
	}
	
	
	
	protected void actionPerformedBtnGenerarVenta(ActionEvent e){
		guardarVenta();
		guardarDetalle();
	}
	
	void guardarVenta(){
		int idv=0;
		int idc=0;
		String serie=txtNroVenta.getText();
		String fecha=txtFecha.getText();
		//double monto=txtPrePro;
	}
	
	void guardarDetalle(){
		
	}
}
