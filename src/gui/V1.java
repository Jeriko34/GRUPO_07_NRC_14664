package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.restaurante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox BoxLista;
	private JTextField txtPedido;
	private JTextField txtDirección;
	private JTextField txtCliente;
	private JLabel lblNewLabel_3;
	private JTextField txtPlatos;
	private JTextArea txtS;
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
			lblNewLabel.setBounds(18, 16, 128, 13);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Registre dirección:");
			lblNewLabel_1.setBounds(18, 36, 112, 13);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Nombre del cliente:");
			lblNewLabel_2.setBounds(18, 56, 112, 13);
			contentPane.add(lblNewLabel_2);
		}
		{
			BoxLista = new JComboBox();
			BoxLista.setModel(new DefaultComboBoxModel(new String[] {"---Seleccione plato del día---", "Tallarines Verdes", "Lomo Saltado", "Seco de Pollo", "Locro"}));
			BoxLista.setBounds(20, 82, 236, 20);
			contentPane.add(BoxLista);
		}
		{
			txtPedido = new JTextField();
			txtPedido.setBounds(145, 14, 111, 18);
			contentPane.add(txtPedido);
			txtPedido.setColumns(10);
		}
		{
			txtDirección = new JTextField();
			txtDirección.setBounds(145, 34, 111, 18);
			contentPane.add(txtDirección);
			txtDirección.setColumns(10);
		}
		{
			txtCliente = new JTextField();
			txtCliente.setBounds(145, 54, 111, 18);
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
			txtPlatos.setBounds(143, 110, 113, 18);
			contentPane.add(txtPlatos);
			txtPlatos.setColumns(10);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(18, 134, 461, 143);
			contentPane.add(txtS);
		}
		{
			btnPedido = new JButton("Calcular Pedido:");
			btnPedido.addActionListener(this);
			btnPedido.setBounds(339, 11, 140, 38);
			contentPane.add(btnPedido);
		}
		{
			btnLimpiar = new JButton("Limpiar pedidos:");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(339, 69, 140, 38);
			contentPane.add(btnLimpiar);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnPedido) {
			do_btnPedido_actionPerformed(e);
		}
	}
	ArrayList<restaurante> listaPedidos = new ArrayList<>();
	
	//Método para obtener el precio según el plato seleccionado
	public double obtenerPrecioPlato(int index) {
		switch (index) {
	     case 1: return 25.50; // Lomo Saltado
	     case 2: return 18.00; // Ají de Gallina
	     case 3: return 22.00; // Arroz con Pollo
	     default: return 0.0;
	    }
	}
	
	protected void do_btnPedido_actionPerformed(ActionEvent e) {
		try {
            // Captura de datos desde los JTextField
            double nPedido = Double.parseDouble(txtPedido.getText());
            double cantidad = Double.parseDouble(txtPlatos.getText());
            String direccion = txtDirección.getText();
            String nombre = txtCliente.getText();
            
            // Obtener precio del plato seleccionado en el ComboBox
            int seleccion = BoxLista.getSelectedIndex();
            double precioUnitario = obtenerPrecioPlato(seleccion);
            
            // Cálculo del total
            double total = precioUnitario * cantidad;
            
            // Crear objeto y agregar al arreglo (ArrayList)
            restaurante nuevoPedido = new restaurante(nPedido, cantidad, nombre, direccion);
            listaPedidos.add(nuevoPedido);
            
            // Mostrar en el JTextArea (el cuadro blanco grande)
            String linea = String.format("Cliente: %s | Total: S/ %.2f\n", nombre, total);
            txtS.append(linea);
            //txtS.append("Cliente: " + nombre + " | Plato: " + seleccion + "()" + " | Total: S/ " + total + "\n");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Por favor, verifique que los campos  sean correctos.");
        }
	}
	
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		// Limpiar campos de texto
        txtPedido.setText("");
        txtDirección.setText("");
        txtCliente.setText("");
        txtPlatos.setText("");
        BoxLista.setSelectedIndex(0);
        
        // Opcional: Limpiar el historial visual y el arreglo
        txtS.setText("");
        listaPedidos.clear(); 
	}
}
