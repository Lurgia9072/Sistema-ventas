package vista;

import entidad.eVendedor;
import negocio.nVendedor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	nVendedor ObjNV = new nVendedor();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIngresar;
	private JLabel label;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/img/User.png")));
		lblUsuario.setBounds(10, 162, 102, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setIcon(new ImageIcon(Login.class.getResource("/img/Contrase\u00F1a.png")));
		lblContrasea.setBounds(10, 244, 131, 30);
		contentPane.add(lblContrasea);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/img/Ingresar (1).png")));
		btnIngresar.setBounds(56, 335, 130, 30);
		contentPane.add(btnIngresar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/login2020 (1).png")));
		label.setBounds(56, 11, 140, 140);
		contentPane.add(label);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 203, 235, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(10, 285, 235, 30);
		contentPane.add(txtClave);
		
		//Facil acceso jeje
		txtUsuario.setText("ADMIN");
		txtClave.setText("1");
	}
	
	//BOTON INGRESAR
	protected void actionPerformedBtnIngresar(ActionEvent e){
		validar();
	}
	
	//METODO PARA VALIDAR 
	public void validar(){
		eVendedor ObjV = new eVendedor();

		String dni=txtClave.getText();
		String user=txtUsuario.getText();
		
		if(txtUsuario.getText().equals("")|txtClave.getText().equals("")){
			JOptionPane.showMessageDialog(this, "DebeIngresar datos");
			txtUsuario.requestFocus();
		}else{
			ObjV=ObjNV.ValidarVendedor( dni,user);
			if(ObjV.getUsuario() !=null && ObjV.getDni() !=null){
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "Debe Ingresar Datos Validos");
				txtUsuario.requestFocus();
			}			
		}
	}
}
