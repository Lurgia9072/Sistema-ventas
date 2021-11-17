package vista;

import datos.dCliente;
import entidad.eCliente;
import negocio.nCliente;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cliente extends JInternalFrame {
	nCliente ObjNC = new nCliente();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTable miTabla;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnSuprimir;
	private JButton btnCancelar;
	private JComboBox<Object> cboEstado;
	private JTextField txtTelefono;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	String Columnas[] = {"IdCliente","Dni","Nombres","Apellidos","Telefono","Direccion","Estado"};
	Object Filas[][];
	ArrayList<eCliente> miLista;	
	
	//METODO PARA CARGAR EL CONTROL JTABLE
	private void CargarTabla() {
		tabla = new DefaultTableModel();
		miLista = new ArrayList<eCliente>();
		miLista = ObjNC.Listar();
		Filas = new Object[miLista.size()][7];
		for(int i = 0; i < Columnas.length; i++)tabla.addColumn(Columnas[i]);
		for(int i = 0; i < miLista.size(); i++) {
			Filas[i][0] = miLista.get(i).getIdCliente();
			Filas[i][1] = miLista.get(i).getDni();
			Filas[i][2] = miLista.get(i).getNombres();
			Filas[i][3] = miLista.get(i).getApellidos();
			Filas[i][4] = miLista.get(i).getTelefono();
			Filas[i][5] = miLista.get(i).getDireccion();
			Filas[i][6] = miLista.get(i).getEstado();
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
		txtDireccion.setText("");
		txtCodigo.requestFocus();
		cboEstado.setSelectedItem("Seleccionar");
	}
	
	public Cliente() {
		setFrameIcon(new ImageIcon(Cliente.class.getResource("/img/logo20p.jpg")));
		setForeground(Color.BLACK);
		setTitle("Mantenimiento Cliente");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 576, 505);
		getContentPane().setLayout(null);
		
		JLabel lblDatos = new JLabel("Datos:");
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatos.setBounds(10, 11, 46, 14);
		getContentPane().add(lblDatos);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 36, 540, 194);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 11, 80, 14);
		panel.add(lblCodigo);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setBounds(10, 36, 80, 14);
		panel.add(lblDni);
		
		JLabel lblNombres = new JLabel("NOMBRES");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(10, 61, 80, 14);
		panel.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 86, 80, 14);
		panel.add(lblApellidos);
		
		JLabel lblDireccin = new JLabel("DIRECCI\u00D3N");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDireccin.setBounds(10, 111, 80, 14);
		panel.add(lblDireccin);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(10, 164, 80, 14);
		panel.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 9, 121, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(85, 36, 121, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(85, 59, 235, 20);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(85, 84, 235, 20);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(85, 109, 235, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar", "1", "2"}));
		cboEstado.setBounds(85, 161, 121, 20);
		panel.add(cboEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setIcon(new ImageIcon(Cliente.class.getResource("/img/buscar.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscar.setBounds(216, 7, 105, 23);
		panel.add(btnBuscar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregar(e);
			}
		});
		btnAgregar.setIcon(new ImageIcon(Cliente.class.getResource("/img/agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregar.setBounds(396, 7, 110, 23);
		panel.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		btnModificar.setIcon(new ImageIcon(Cliente.class.getResource("/img/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModificar.setBounds(396, 57, 110, 23);
		panel.add(btnModificar);
		
		btnSuprimir = new JButton("Suprimir");
		btnSuprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSuprimir(e);
			}
		});
		btnSuprimir.setIcon(new ImageIcon(Cliente.class.getResource("/img/suprimir.png")));
		btnSuprimir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSuprimir.setBounds(396, 107, 110, 23);
		panel.add(btnSuprimir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		btnCancelar.setIcon(new ImageIcon(Cliente.class.getResource("/img/cancelar.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(396, 160, 110, 23);
		panel.add(btnCancelar);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(85, 136, 121, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(10, 139, 80, 14);
		panel.add(lblTelefono);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(230, 155, 89, 23);
		panel.add(btnAceptar);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDetalle.setBounds(10, 245, 72, 14);
		getContentPane().add(lblDetalle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 270, 540, 194);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 520, 172);
		panel_1.add(scrollPane);
		
		miTabla = new JTable();
		miTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedMiTabla(e);
			}
		});
		scrollPane.setViewportView(miTabla);
		
		//MOSTRAR DATOS DE LA TABLA
		CargarTabla();

		btnAceptar.setEnabled(false);

	}
	
	//BOTON ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent e){
		if(btnAgregar.isEnabled()==false){
			String id=txtCodigo.getText();
			String dn=txtDni.getText();
			String no=txtNombres.getText();
			String ap=txtApellidos.getText();
			String te=txtTelefono.getText();
			String di=txtDireccion.getText();
			String est=cboEstado.getSelectedItem().toString();
			
			eCliente ObjC = new eCliente(id,dn,no,ap,te,di,est);
			ObjNC.Insertar(ObjC);
			CargarTabla();
			LimpiarCajas();
			JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
			
			btnAgregar.setEnabled(true);
			txtCodigo.setEnabled(true);
			btnAceptar.setEnabled(false);
			}
			
			if(btnModificar.isEnabled()==false){
				eCliente ObjC = new eCliente(txtCodigo.getText(),
						txtDni.getText(),
						txtNombres.getText(),
						txtApellidos.getText(),
						txtTelefono.getText(),
						txtDireccion.getText(),
						cboEstado.getSelectedItem().toString()
						);
				ObjNC.Modificar(ObjC);
				LimpiarCajas();
				CargarTabla();	
				JOptionPane.showMessageDialog(null, "SE MODIFICO CLIENTE");
				
				btnModificar.setEnabled(true);
				txtCodigo.setEnabled(true);
				btnAceptar.setEnabled(false);
			}
	}
	
	//BOTON BUSCAR
	protected void actionPerformedBtnBuscar(ActionEvent e){
		eCliente ObjC = new eCliente();
		ObjC = ObjNC.Buscar(txtCodigo.getText());

		if(ObjC !=null){
			txtCodigo.setText(ObjC.getIdCliente());
			txtDni.setText(ObjC.getDni());
			txtNombres.setText(ObjC.getNombres()+"");
			txtApellidos.setText(ObjC.getApellidos()+"");
			txtTelefono.setText(ObjC.getTelefono()+"");	
			txtDireccion.setText(ObjC.getDireccion());
				
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, CODIGO CLIENTE NO EXISTE");
		}
	}
	//BOTON MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent e){
		int fila=miTabla.getSelectedRow();
		
		if(fila==-1){
			
			JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
			txtCodigo.setEnabled(false);
			btnModificar.setEnabled(false);
			btnAceptar.setEnabled(true);
		}	
	}
	//BOTON SUPRIMIR
	protected void actionPerformedBtnSuprimir(ActionEvent e){
		int fila=miTabla.getSelectedRow();
		if(fila==-1){
			JOptionPane.showMessageDialog(null, "Debe selecionar una fila");
		}else{
			ObjNC.Suprimir(txtCodigo.getText());
			LimpiarCajas();
			CargarTabla();
			JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO CORRECTAMENTE");
		}
	}
	//BOTON AGREGAR
	protected void actionPerformedBtnAgregar(ActionEvent e){
		txtCodigo.setText(ObjNC.GeneraCodigoCliente());
		txtCodigo.setEnabled(false);
		btnAgregar.setEnabled(false);
		btnAceptar.setEnabled(true);
	}

	//BOTON CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent e){
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
		txtDireccion.setText(miTabla.getValueAt(f, 5).toString());
				
	}
}

