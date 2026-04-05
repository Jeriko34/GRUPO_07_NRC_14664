package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private JTextField txtPedido;
	private JTextField txtDirección;
	private JTextField txtCliente;
	private JLabel lblNewLabel_3;
	private JTextField txtPlatos;
	private JTextArea textArea;
	private JButton btnPedido;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Registre n° de pedido:");
			lblNewLabel.setBounds(18, 16, 128, 12);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Registre dirección:");
			lblNewLabel_1.setBounds(18, 38, 112, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Nombre del cliente:");
			lblNewLabel_2.setBounds(18, 60, 112, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Seleccione plato del día---", "Tallarines Verdes", "Lomo Saltado", "Seco de Pollo", "Locro"}));
			comboBox.setBounds(20, 82, 218, 20);
			contentPane.add(comboBox);
		}
		{
			txtPedido = new JTextField();
			txtPedido.setBounds(143, 13, 111, 18);
			contentPane.add(txtPedido);
			txtPedido.setColumns(10);
		}
		{
			txtDirección = new JTextField();
			txtDirección.setBounds(143, 35, 111, 18);
			contentPane.add(txtDirección);
			txtDirección.setColumns(10);
		}
		{
			txtCliente = new JTextField();
			txtCliente.setBounds(143, 57, 111, 18);
			contentPane.add(txtCliente);
			txtCliente.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Cantidad de platos:");
			lblNewLabel_3.setBounds(18, 112, 112, 12);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtPlatos = new JTextField();
			txtPlatos.setBounds(143, 112, 111, 18);
			contentPane.add(txtPlatos);
			txtPlatos.setColumns(10);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(18, 134, 461, 143);
			contentPane.add(textArea);
		}
		{
			btnPedido = new JButton("Calcular Pedido:");
			btnPedido.setBounds(280, 12, 140, 38);
			contentPane.add(btnPedido);
		}
		{
			btnLimpiar = new JButton("Limpiar pedidos:");
			btnLimpiar.setBounds(280, 70, 140, 38);
			contentPane.add(btnLimpiar);
		}

	}
}
