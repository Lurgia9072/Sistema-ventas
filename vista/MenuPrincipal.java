package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSalir;
	private JMenu mnMenu;
	private JMenuBar menuBar;
	private JMenuItem mntmVendedor;
	private JMenuItem mntmCliente;
	private JMenuItem mntmProducto;
	private JMenu mnVenta;
	private JMenu mnReporte;
	private JMenuItem mntmGenerarVenta;
	public static JDesktopPane desktopPane;
	private JMenuItem mntmReporte;
	private JPanel contentPane;

	//Se quita para que mande directo al login
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/logo20p.jpg")));
		setTitle("Sistema Jugueteria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setLocationRelativeTo(null);
		
		
		setBounds(100, 100, 547, 437);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		mnMenu.setForeground(Color.BLACK);
		mnMenu.setFont(new Font("MS PGothic", Font.BOLD, 14));
		mnMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/menu.png")));
		menuBar.add(mnMenu);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?","Salida",JOptionPane.YES_NO_OPTION)==0) {
					System.exit(0);
				}
			}
		});
		mntmSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/salir (1).png")));
		mntmSalir.setFont(new Font("MS PGothic", Font.PLAIN, 14));
		mnMenu.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(Color.BLACK);
		mnMantenimiento.setFont(new Font("MS PGothic", Font.BOLD, 14));
		mnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setFont(new Font("MS PGothic", Font.PLAIN, 14));
		mntmCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/cliente (1).png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				desktopPane.add(c);
				c.setVisible(true);
				
			}
		});
		mnMantenimiento.add(mntmCliente);
		
		mntmVendedor = new JMenuItem("Vendedor");
		mntmVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vendedor v = new Vendedor();
				desktopPane.add(v);
				v.setVisible(true);
				
				
			}
		});
		mntmVendedor.setFont(new Font("MS PGothic", Font.PLAIN, 14));
		mntmVendedor.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/vendedor (1).png")));
		mnMantenimiento.add(mntmVendedor);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto p = new Producto();
				desktopPane.add(p);
				p.setVisible(true);
			}
		});
		mntmProducto.setFont(new Font("MS PGothic", Font.PLAIN, 14));
		mntmProducto.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/producto (1).png")));
		mnMantenimiento.add(mntmProducto);
		
		mnVenta = new JMenu("Venta");
		mnVenta.setForeground(Color.BLACK);
		mnVenta.setFont(new Font("MS PGothic", Font.BOLD, 14));
		mnVenta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/venta.png")));
		menuBar.add(mnVenta);
		
		mntmGenerarVenta = new JMenuItem("Generar Venta");
		mntmGenerarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerarVenta gv = new GenerarVenta();
				desktopPane.add(gv);
				gv.setVisible(true);
				
			}
		});
		mntmGenerarVenta.setFont(new Font("MS PGothic", Font.PLAIN, 14));
		mntmGenerarVenta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/vent1as.png")));
		mnVenta.add(mntmGenerarVenta);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setForeground(Color.BLACK);
		mnReporte.setFont(new Font("MS PGothic", Font.BOLD, 14));
		mnReporte.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/reporte.png")));
		menuBar.add(mnReporte);
		
		mntmReporte = new JMenuItem("Reporte");
		mntmReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmReporte.setFont(new Font("MS PGothic", Font.PLAIN, 14));
		mntmReporte.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/reportes (1).png")));
		mnReporte.add(mntmReporte);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	
	
}
