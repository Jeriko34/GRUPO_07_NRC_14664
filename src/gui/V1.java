package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloPedidos;
import clases.Restaurante;

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
		setTitle("Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 528);
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
			txtS.setBounds(18, 134, 597, 347);
			contentPane.add(txtS);
		}
		{
			btnPedido = new JButton("Calcular pedido");
			btnPedido.addActionListener(this);
			btnPedido.setBounds(266, 8, 136, 29);
			contentPane.add(btnPedido);
		}
		{
			btnLimpiar = new JButton("Limpiar pedidos");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(266, 48, 136, 29);
			contentPane.add(btnLimpiar);
		}
		{
			btnBuscar = new JButton("Buscar pedidos");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(266, 87, 136, 29);
			contentPane.add(btnBuscar);
		}
		{
			btnModificar = new JButton("Modificar dirección");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(412, 8, 150, 29);
			contentPane.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar pedido");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(412, 48, 150, 29);
			contentPane.add(btnEliminar);
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnPedido) {
			do_btnPedido_actionPerformed(e);
		}
	}
	ArregloPedidos listaPedidos = new ArregloPedidos();
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	public double obtenerPrecioPlato(int index) {
		switch (index) {
	     case 1: return 25.50; //Tallarines verdes
	     case 2: return 18.00; //Lomo saltado
	     case 3: return 22.00; //Seco de Pollo
	     case 4: return 17.00; //Locro
	     default: return 0.0;
	    }
	}
	protected void do_btnPedido_actionPerformed(ActionEvent e) {
		try {
            int nPedido = Integer.parseInt(txtPedido.getText());
            double cantidad = Double.parseDouble(txtPlatos.getText());
            String direccion = txtDirección.getText();
            String nombre = txtCliente.getText();
            int seleccion = BoxLista.getSelectedIndex(); //Obtener precio del plato seleccionado en el ComboBox
            double precioUnitario = obtenerPrecioPlato(seleccion);
            double total = precioUnitario * cantidad;

            Restaurante nuevoPedido = new Restaurante(nPedido, cantidad, nombre, direccion);
            nuevoPedido.setTotal(total);
            listaPedidos.Registrar(nuevoPedido);
            
            String linea = String.format("Cliente: %s | Dirección del cliente: %s  |   Total: S/ %.2f\n", nombre, direccion, total);
            txtS.append(linea);
            txtPedido.setText("");
			txtCliente.setText("");
			txtDirección.setText("");
			txtPlatos.setText("");
			BoxLista.setSelectedIndex(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Por favor, verifique que los campos  sean correctos.");
        }
	}
	
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
        
		if (listaPedidos.Tamaño() == 0) {
	        JOptionPane.showMessageDialog(null, "No hay pedidos para limpiar.",
	            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
		
		txtPedido.setText("");
        txtDirección.setText("");
        txtCliente.setText("");
        txtPlatos.setText("");
        txtS.setText("");
        BoxLista.setSelectedIndex(0);
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
	String nombreBuscado = txtCliente.getText().trim();
	if (nombreBuscado.isEmpty()) {
		JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del cliente.");
		return;
	}
	Restaurante encontrado = listaPedidos.BuscarPorCliente(nombreBuscado);
	if (encontrado != null) {
		JOptionPane.showMessageDialog(null, "Pedido encontrado:\n" + "N° Pedido: " + (int)encontrado.getPedido() + "\n" + 
				"Cliente: " + encontrado.getCliente() + "\n" + "Dirección: " + encontrado.getDirec(),"Pedido encontrado",JOptionPane.INFORMATION_MESSAGE);
	} else {
		JOptionPane.showMessageDialog(null, "✘ No se encontró ningún pedido para el cliente: " + nombreBuscado, "No encontrado", JOptionPane.WARNING_MESSAGE);
	}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			int nPedido = Integer.parseInt(txtPedido.getText().trim());
		    String nuevaDirec = txtDirección.getText().trim();
		    boolean modificado = listaPedidos.ModificarDireccion(nPedido, nuevaDirec);
		    if (!modificado) {
		        JOptionPane.showMessageDialog(null, "No se encontró el pedido N°: " + nPedido,
		            "No encontrado", JOptionPane.WARNING_MESSAGE);
		        return;
		    }
		    txtS.setText("");
		    for (int i = 0; i < listaPedidos.Tamaño(); i++) {
		        Restaurante r = listaPedidos.Obtener(i);
		        double total = obtenerPrecioPlato((int) r.getPlato());
		        String linea = String.format("Cliente: %s | Dirección del cliente: %s | Total: S/ %.2f\n",
		        	    r.getCliente(), r.getDirec(), r.getTotal());
		        txtS.append(linea);
		    }
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Ingrese un número de pedido válido para modificar su dirección.");
		}
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
			String textoPedido = txtPedido.getText().trim();

			if (textoPedido.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese el número de pedido a eliminar.");
				txtPedido.requestFocus();
				return;
			}

			int numPedido = Integer.parseInt(textoPedido);

			Restaurante encontrado = listaPedidos.Buscar(numPedido);

			if (encontrado == null) {
				JOptionPane.showMessageDialog(this, "No existe un pedido con ese número.");
				return;
			}

			listaPedidos.Eliminar(encontrado);

			txtS.setText("");
			for (int i = 0; i < listaPedidos.Tamaño(); i++) {
				Restaurante r = listaPedidos.Obtener(i);

				String linea = String.format(
					"N° Pedido: %d | Cliente: %s | Dirección: %s | Cantidad de platos: %.0f%n",
					(int) r.getPedido(),
					r.getCliente(),
					r.getDirec(),
					r.getPlato()
				);

				txtS.append(linea);
			}

			JOptionPane.showMessageDialog(this, "Pedido eliminado correctamente.");

			txtPedido.setText("");
			txtCliente.setText("");
			txtDirección.setText("");
			txtPlatos.setText("");
			BoxLista.setSelectedIndex(0);

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Ingrese un número de pedido válido.");
		}
	}
}
