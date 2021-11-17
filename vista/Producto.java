package vista;

import entidad.eProducto;
//import datos.dProducto;
import negocio.nProducto;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
//import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Producto extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	nProducto ObjNP = new nProducto();
	
	private JPanel panelDatos;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JComboBox<Object> cboEstado;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnSuprimir;
	private JButton btnCerrar;
	private JPanel panelDetalle;
	private JTable miTabla;
	private JButton btnAceptar;
	
	//DATOS PARA LA CARGA DEL JTABLE
	DefaultTableModel tabla;
	String Columnas[] = {"IdProducto","Descripcion","Precio","Stock","Estado"};
	Object Filas[][];
	ArrayList<eProducto> miLista;	
	
	
	//METODO PARA CARGAR EL CONTROL JTABLE
	private void CargarTabla() {
		tabla = new DefaultTableModel();
		miLista = new ArrayList<eProducto>();
		miLista = ObjNP.Listar();
		Filas = new Object[miLista.size()][5];
		for(int i = 0; i < Columnas.length; i++)tabla.addColumn(Columnas[i]);
		for(int i = 0; i < miLista.size(); i++) {
			Filas[i][0] = miLista.get(i).getIdProducto();
			Filas[i][1] = miLista.get(i).getDescripcion();
			Filas[i][2] = miLista.get(i).getPrecio();
			Filas[i][3] = miLista.get(i).getStock();
			Filas[i][4] = miLista.get(i).getEstado();
			tabla.addRow(Filas[i]);
		}
		miTabla.setModel(tabla);
	}
	
	//METODO LIMPIAR CAJAS
	private void LimpiarCajas() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtCodigo.requestFocus();
		cboEstado.setSelectedItem("Seleccionar");
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto frame = new Producto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Producto() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento Producto");
		setFrameIcon(new ImageIcon(Producto.class.getResource("/img/logo20p.jpg")));
		setBounds(100, 100, 579, 489);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Datos:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 11, 46, 14);
		getContentPane().add(label);
		
		panelDatos = new JPanel();
		panelDatos.setBackground(Color.LIGHT_GRAY);
		panelDatos.setBounds(10, 36, 375, 159);
		getContentPane().add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 11, 94, 14);
		panelDatos.add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(10, 36, 94, 14);
		panelDatos.add(lblDescripcion);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStock.setBounds(10, 86, 94, 14);
		panelDatos.add(lblStock);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(10, 111, 94, 14);
		panelDatos.add(lblEstado);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 61, 94, 14);
		panelDatos.add(lblPrecio);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(114, 9, 123, 20);
		panelDatos.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(114, 34, 245, 20);
		panelDatos.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(114, 59, 123, 20);
		panelDatos.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(114, 84, 123, 20);
		panelDatos.add(txtStock);
		txtStock.setColumns(10);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar", "1", "2"}));
		cboEstado.setBounds(114, 109, 123, 20);
		panelDatos.add(cboEstado);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedAceptar(e);
			}
		});
		btnAceptar.setBounds(276, 125, 89, 23);
		panelDatos.add(btnAceptar);
		
		JLabel label_1 = new JLabel("Detalle:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(10, 217, 72, 14);
		getContentPane().add(label_1);
		
		panelDetalle = new JPanel();
		panelDetalle.setLayout(null);
		panelDetalle.setBackground(Color.LIGHT_GRAY);
		panelDetalle.setBounds(10, 242, 540, 206);
		getContentPane().add(panelDetalle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 520, 184);
		panelDetalle.add(scrollPane);
		
		miTabla = new JTable();
		miTabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mouseClickedMiTabla(e);
			}
		});
		scrollPane.setViewportView(miTabla);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(440, 76, 110, 29);
		getContentPane().add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedAgregar(e);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregar.setIcon(new ImageIcon(Producto.class.getResource("/img/agregar.png")));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(440, 116, 110, 29);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedModificar(e);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificar.setIcon(new ImageIcon(Producto.class.getResource("/img/modificar.png")));
		
		btnSuprimir = new JButton("Suprimir");
		btnSuprimir.setBounds(440, 162, 110, 29);
		getContentPane().add(btnSuprimir);
		btnSuprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedSuprimir(e);
			}
		});
		btnSuprimir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuprimir.setIcon(new ImageIcon(Producto.class.getResource("/img/suprimir.png")));
		
		btnCerrar = new JButton("Cancelar");
		btnCerrar.setBounds(440, 202, 113, 29);
		getContentPane().add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCerrar(e);
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrar.setIcon(new ImageIcon(Producto.class.getResource("/img/cancelar.png")));
				
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(440, 36, 110, 29);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBuscar(e);
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscar.setIcon(new ImageIcon(Producto.class.getResource("/img/buscar.png")));
		
		//MOSTRAR DATOS DE LA TABLA
		CargarTabla();

		//BOTON ACEPTAR EMPIZA DESACTIVADO
		btnAceptar.setEnabled(false);
	}
	
	//BOTON BUSCAR +
	protected void actionPerformedBuscar(ActionEvent e){
		eProducto ObjP = new eProducto();
		ObjP = ObjNP.Buscar(txtCodigo.getText());

		if(ObjP !=null){
			txtCodigo.setText(ObjP.getIdProducto());
			txtDescripcion.setText(ObjP.getDescripcion());
			txtPrecio.setText(ObjP.getPrecio()+"");
			txtStock.setText(ObjP.getStock()+"");
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, CODIGO PRODUCTO NO EXISTE");
		}
	}
	//BOTON AGREGAR -
	protected void actionPerformedAgregar(ActionEvent e){
		LimpiarCajas();
		txtCodigo.setText(ObjNP.GeneraCodigoProducto());
		txtCodigo.setEnabled(false);
		btnAgregar.setEnabled(false);
		btnAceptar.setEnabled(true);
	}
	//BOTON MODIFICAR -
	protected void actionPerformedModificar(ActionEvent e){
		
		int fila=miTabla.getSelectedRow();
		
		if(fila==-1){
			
			JOptionPane.showMessageDialog(this, "Debe selecionar una fila");
			//LimpiarCajas();
			txtCodigo.setEnabled(false);
			btnModificar.setEnabled(false);
			btnAceptar.setEnabled(true);
			
		}	
	}
	//BOTON SUPRIMIR +
	protected void actionPerformedSuprimir(ActionEvent e){
		int fila=miTabla.getSelectedRow();
		if(fila==-1){
			JOptionPane.showMessageDialog(this, "Debe selecionar una fila");
		}else{
			ObjNP.Suprimir(txtCodigo.getText());
			LimpiarCajas();
			CargarTabla();
			JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO CORRECTAMENTE");
		}
	}
	
	protected void actionPerformedAceptar(ActionEvent e){
		if(btnAgregar.isEnabled()==false){
		String id=txtCodigo.getText();
		String des=txtDescripcion.getText();
		double pre=Double.parseDouble(txtPrecio.getText());
		int sto=Integer.parseInt(txtStock.getText());
		String est=cboEstado.getSelectedItem().toString();
		
		eProducto ObjP = new eProducto(id,des,pre,sto,est);
		ObjNP.Insertar(ObjP);
		CargarTabla();
		LimpiarCajas();
		JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
		
		btnAgregar.setEnabled(true);
		txtCodigo.setEnabled(true);
		btnAceptar.setEnabled(false);
		}
		
		if(btnModificar.isEnabled()==false){
			eProducto ObjP = new eProducto(txtCodigo.getText(),
					txtDescripcion.getText(),
					Double.parseDouble(txtPrecio.getText()),
					Integer.parseInt(txtStock.getText()),
					cboEstado.getSelectedItem().toString()
					);
			ObjNP.Modificar(ObjP);
			LimpiarCajas();
			CargarTabla();	
			JOptionPane.showMessageDialog(null, "SE MODIFICO PRODUCTO");
			
			btnModificar.setEnabled(true);
			txtCodigo.setEnabled(true);
			btnAceptar.setEnabled(false);
		}
	}
	
	//BOTON CANCELAR
	protected void actionPerformedCerrar(ActionEvent e){
		//dispose();
		btnAceptar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAgregar.setEnabled(true);
		txtCodigo.setEnabled(true);
		LimpiarCajas();
		JOptionPane.showMessageDialog(null, "SE CANCECLO ACCION");
	}
	
	// METODO MOUSE CLICKED EN MI TABLA
	protected void mouseClickedMiTabla(MouseEvent e) {
		int f = miTabla.getSelectedRow();
		txtCodigo.setText(miTabla.getValueAt(f, 0).toString());
		txtDescripcion.setText(miTabla.getValueAt(f, 1).toString());
		txtPrecio.setText(miTabla.getValueAt(f, 2).toString());
		txtStock.setText(miTabla.getValueAt(f, 3).toString());
	}
}
