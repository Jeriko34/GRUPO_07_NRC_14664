package Clases;

public class restaurante {
private double pedido,direc,plato; // "pedido" es el registro de pedidos, "direc es el registro de direccion","plato" es cantidad de platos
public restaurante(double pedido, double direc, double plato, String cliente) {
	super();
	this.pedido = pedido;
	this.direc = direc;
	this.plato = plato;
	this.cliente = cliente;
}
private String cliente;//Para registrar al cliente
public double getPedido() {
	return pedido;
}
public void setPedido(double pedido) {
	this.pedido = pedido;
}
public double getDirec() {
	return direc;
}
public void setDirec(double direc) {
	this.direc = direc;
}
public double getPlato() {
	return plato;
}
public void setPlato(double plato) {
	this.plato = plato;
}
public String getCliente() {
	return cliente;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
//tecnicamente esto seria la clase, en los metodos trata de darle valor a los platos que aparecen en el gui.
}
