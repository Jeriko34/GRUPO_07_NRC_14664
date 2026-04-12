package arreglos;

import java.util.ArrayList;

import clases.Restaurante;

public class ArregloPedidos {
private ArrayList<Restaurante>rest;
public ArregloPedidos() {
	rest = new ArrayList<Restaurante>();
}
public void Registrar(Restaurante x) {
	rest.add(x); 
}
public int Tamaño() {
	return rest.size();
}
public Restaurante Obtener(int x) {
	return rest.get(x);
}
public Restaurante Buscar(int pedido) {
	for (int i = 0; i < Tamaño(); i++) {
		if(Obtener(i).getPedido()==pedido) return Obtener(i);	
	}
	return null;
}
//Para buscar un pedido.
public void Eliminar(Restaurante x) {
		rest.remove(x);
}

//Para eliminar un pedido completo (o cliente, es lo mismo por ahora).
public Restaurante BuscarPorCliente(String nombre) {
    for (int i = 0; i < Tamaño(); i++) {
        if (Obtener(i).getCliente().equalsIgnoreCase(nombre)) {
            return Obtener(i);
        }
    }
    return null;
}
}