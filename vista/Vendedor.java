package vista;

import datos.dVendedor;
import entidad.eVendedor;
import negocio.nVendedor;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vendedor extends JInternalFrame {
	nVendedor ObjNV = new nVendedor();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable miTabla;
	private JTextField txtCodigo;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JComboBox<Object> cboEstado;
	private JButton btnBuscar;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnSuprimir;
	private JButton btnCancelar;
	private JPanel panel_1;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendedor frame = new Vendedor();
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
	
	//DATOS PARA LA CARGA DEL JTABLE
	DefaultTableModel tabla;
	String Columnas[] = {"IdVendedor","Dni","Nombres","Apellidos","Telefono","Estado","Usuario"};
	Object Filas[][];
	ArrayList<eVendedor> miLista;		
	
	//METODO PARA CARGAR EL CONTROL JTABLE
	private void CargarTabla() {
		tabla = new DefaultTableModel();
		miLista = new ArrayList<eVendedor>();
		miLista = ObjNV.Listar();
		Filas = new Object[miLista.size()][7];
		for(int i = 0; i < Columnas.length; i++)tabla.addColumn(Columnas[i]);
		for(int i = 0; i < miLista.size(); i++) {
			Filas[i][0] = miLista.get(i).getIdVendedor();
			Filas[i][1] = miLista.get(i).getDni();
			Filas[i][2] = miLista.get(i).getNombres();
			Filas[i][3] = miLista.get(i).getApellidos();
			Filas[i][4] = miLista.get(i).getTelefono();				
			Filas[i][5] = miLista.get(i).getEstado();
			Filas[i][6] = miLista.get(i).getUsuario();
			tabla.addRow(Filas[i]);
		}
		miTabla.setModel(tabla);
	}
	
	//METODO LIMPIAR CAJAS
	private void LimpiarCajas() {
		txtCodigo.setText("");
		txtDni.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtUsuario.setText("");
		txtCodigo.requestFocus();
		cboEstado.setSelectedItem("Seleccionar");
	}
	
	public Vendedor() {
		setFrameIcon(new ImageIcon(Vendedor.class.getResource("/img/logo20p.jpg")));
		setTitle("Mantenimiento Vendedor");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 579, 517);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Detalle:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 245, 72, 14);
		getContentPane().add(label);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 270, 540, 206);
		getContentPane().add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 520, 184);
		panel.add(scrollPane);
		
		miTabla = new JTable();
		miTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedMiTabla(e);
			}
		});
		scrollPane.setViewportView(miTabla);
		
		JLabel label_1 = new JLabel("Datos:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(10, 11, 46, 14);
		getContentPane().add(label_1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 36, 540, 198);
		getContentPane().add(panel_1);
		
		JLabel label_2 = new JLabel("CODIGO");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(10, 11, 80, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("DNI");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(10, 36, 80, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("NOMBRES");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(10, 61, 80, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("APELLIDOS");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(10, 86, 80, 14);
		panel_1.add(label_5);
		
		JLabel label_7 = new JLabel("ESTADO");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(10, 165, 80, 14);
		panel_1.add(label_7);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(85, 9, 121, 20);
		panel_1.add(txtCodigo);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(85, 36, 121, 20);
		panel_1.add(txtDni);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(85, 59, 235, 20);
		panel_1.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(85, 84, 235, 20);
		panel_1.add(txtApellidos);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar", "1", "2"}));
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setBounds(85, 162, 121, 20);
		panel_1.add(cboEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBuscar(e);
			}
		});
		btnBuscar.setIcon(new ImageIcon(Vendedor.class.getResource("/img/buscar.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscar.setBounds(396, 7, 104, 23);
		panel_1.add(btnBuscar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedAgregar(e);
			}
		});
		btnAgregar.setIcon(new ImageIcon(Vendedor.class.getResource("/img/agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregar.setBounds(396, 57, 109, 23);
		panel_1.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedModificar(e);
			}
		});
		btnModificar.setIcon(new ImageIcon(Vendedor.class.getResource("/img/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificar.setBounds(396, 93, 109, 23);
		panel_1.add(btnModificar);
		
		btnSuprimir = new JButton("Suprimir");
		btnSuprimir.setIcon(new ImageIcon(Vendedor.class.getResource("/img/suprimir.png")));
		btnSuprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedSuprimir(e);
			}
		});
		btnSuprimir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuprimir.setBounds(396, 127, 109, 23);
		panel_1.add(btnSuprimir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCancelar(e);
			}
		});
		btnCancelar.setIcon(new ImageIcon(Vendedor.class.getResource("/img/cancelar.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(396, 161, 109, 23);
		panel_1.add(btnCancelar);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(85, 111, 121, 20);
		panel_1.add(txtTelefono);
		
		JLabel label_8 = new JLabel("TELEFONO");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(10, 111, 80, 14);
		panel_1.add(label_8);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(10, 140, 80, 14);
		panel_1.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(85, 137, 121, 20);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedAceptar(e);
			}
		});
		btnAceptar.setBounds(235, 137, 89, 23);
		panel_1.add(btnAceptar);
		
		//CARGAR TABLA
		CargarTabla();
		
		//BOTON ACEPTAR EMPIZA EN FALSE
		btnAceptar.setEnabled(false);
	}
	
	
	//BOTON ACEPTAR
	protected void actionPerformedAceptar(ActionEvent e){
		if(btnAgregar.isEnabled()==false){
			String id=txtCodigo.getText();
			String dn=txtDni.getText();
			String no=txtNombres.getText();
			String ap=txtApellidos.getText();
			String te=txtTelefono.getText();
			
			String usu=txtUsuario.getText();
			String est=cboEstado.getSelectedItem().toString();
			
			eVendedor ObjV = new eVendedor(id,dn,no,ap,te,usu,est);
			ObjNV.Insertar(ObjV);
			CargarTabla();
			LimpiarCajas();
			JOptionPane.showMessageDialog(null, "REGISTRO VENDEDOR EXITOSO");
			
			btnAgregar.setEnabled(true);
			txtCodigo.setEnabled(true);
			btnAceptar.setEnabled(false);
			}
			
			if(btnModificar.isEnabled()==false){
				eVendedor ObjV = new eVendedor(txtCodigo.getText(),
						txtDni.getText(),
						txtNombres.getText(),
						txtApellidos.getText(),
						txtTelefono.getText(),
						
						txtUsuario.getText(),
						cboEstado.getSelectedItem().toString()
						);
				ObjNV.Modificar(ObjV);
				LimpiarCajas();
				CargarTabla();	
				JOptionPane.showMessageDialog(null, "SE MODIFICO VENDEDOR");
				
				btnModificar.setEnabled(true);
				txtCodigo.setEnabled(true);
				btnAceptar.setEnabled(false);
			}
	}
	
	//BOTON BUSCAR
	protected void actionPerformedBuscar(ActionEvent e){
		eVendedor ObjV = new eVendedor();
		ObjV = ObjNV.Buscar(txtCodigo.getText());

		if(ObjV !=null){
			txtCodigo.setText(ObjV.getIdVendedor());
			txtDni.setText(ObjV.getDni());
			txtNombres.setText(ObjV.getNombres()+"");
			txtApellidos.setText(ObjV.getApellidos()+"");
			txtTelefono.setText(ObjV.getTelefono()+"");	
			txtUsuario.setText(ObjV.getUsuario());
				
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, CODIGO VENDEDOR NO EXISTE");
		}
	}
	
	//BOTON SUPRIMIR
	protected void actionPerformedSuprimir(ActionEvent e){
		int fila=miTabla.getSelectedRow();
		if(fila==-1){
			JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
		}else{
			ObjNV.Suprimir(txtCodigo.getText());
			LimpiarCajas();
			CargarTabla();
			JOptionPane.showMessageDialog(null, "VENDEDOR ELIMINADO CORRECTAMENTE");
		}
	}
	
	//BOTON MODIFICAR
	protected void actionPerformedModificar(ActionEvent e){
		int fila=miTabla.getSelectedRow();
		
		if(fila==-1){
			
			JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
			txtCodigo.setEnabled(false);
			btnModificar.setEnabled(false);
			btnAceptar.setEnabled(true);
		}
	}
	
	//BOTON AGREGAR
	protected void actionPerformedAgregar(ActionEvent e){
		txtCodigo.setText(ObjNV.GeneraCodigoVendedor());
		txtCodigo.setEnabled(false);
		btnAgregar.setEnabled(false);
		btnAceptar.setEnabled(true);
	}
	
	//BOTON CANCELAR
	protected void actionPerformedCancelar(ActionEvent e){
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
		txtDni.setText(miTabla.getValueAt(f, 1).toString());
		txtNombres.setText(miTabla.getValueAt(f, 2).toString());
		txtApellidos.setText(miTabla.getValueAt(f, 3).toString());
		txtTelefono.setText(miTabla.getValueAt(f, 4).toString());
		txtUsuario.setText(miTabla.getValueAt(f, 5).toString());					
	}
	
}
