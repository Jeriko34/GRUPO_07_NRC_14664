package arreglo;

import java.util.ArrayList;

//... dentro de la clase de tu JFrame ...
ArrayList<restaurante> listaPedidos = new ArrayList<>();

//Método para obtener el precio según el plato seleccionado
public double obtenerPrecioPlato(int index) {
 switch (index) {
     case 1: return 25.50; // Lomo Saltado
     case 2: return 18.00; // Ají de Gallina
     case 3: return 22.00; // Arroz con Pollo
     default: return 0.0;
 }

 btnCalcular.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        try {
	            // Captura de datos desde los JTextField
	            double nPedido = Double.parseDouble(txtPedido.getText());
	            double direccion = Double.parseDouble(txtDireccion.getText()); // Según tu clase es double
	            String nombre = txtCliente.getText();
	            double cantidad = Double.parseDouble(txtCantidad.getText());
	            
	            // Obtener precio del plato seleccionado en el ComboBox
	            int seleccion = comboBoxPlatos.getSelectedIndex();
	            double precioUnitario = obtenerPrecioPlato(seleccion);
	            
	            // Cálculo del total
	            double total = precioUnitario * cantidad;
	            
	            // Crear objeto y agregar al arreglo (ArrayList)
	            restaurante nuevoPedido = new restaurante(nPedido, direccion, cantidad, nombre);
	            listaPedidos.add(nuevoPedido);
	            
	            // Mostrar en el JTextArea (el cuadro blanco grande)
	            txtAreaResumen.append("Cliente: " + nombre + " | Total: S/ " + total + "\n");
	            
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Por favor, verifique que los campos numéricos sean correctos.");
	        }
	    }
	});
 
 btnLimpiar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        // Limpiar campos de texto
	        txtPedido.setText("");
	        txtDireccion.setText("");
	        txtCliente.setText("");
	        txtCantidad.setText("");
	        comboBoxPlatos.setSelectedIndex(0);
	        
	        // Opcional: Limpiar el historial visual y el arreglo
	        txtAreaResumen.setText("");
	        listaPedidos.clear(); 
	    }
	});

}
