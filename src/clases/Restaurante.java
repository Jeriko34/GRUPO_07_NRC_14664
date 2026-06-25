package clases;

public class Restaurante {
private int pedido, seleccion, cantidad;
private double total;
private String cliente, direc;
public Restaurante(int pedido, int seleccion, int cantidad, double total, String cliente, String direc) {
	this.pedido = pedido;
	this.seleccion = seleccion;
	this.cantidad = cantidad;
	this.total = total;
	this.cliente = cliente;
	this.direc = direc;
}
public int getPedido() {
	return pedido;
}
public void setPedido(int pedido) {
	this.pedido = pedido;
}
public int getSeleccion() {
	return seleccion;
}
public void setSeleccion(int seleccion) {
	this.seleccion = seleccion;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getCliente() {
	return cliente;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
public String getDirec() {
	return direc;
}
public void setDirec(String direc) {
	this.direc = direc;
}
}
