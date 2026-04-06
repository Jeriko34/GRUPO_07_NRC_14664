package Clases;

public class restaurante {
private double pedido,plato;
public restaurante(double pedido, double plato, String cliente, String direc) {
	this.pedido = pedido;
	this.plato = plato;
	this.cliente = cliente;
	this.direc = direc;
}
public double getPedido() {
	return pedido;
}
public void setPedido(double pedido) {
	this.pedido = pedido;
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
public String getDirec() {
	return direc;
}
public void setDirec(String direc) {
	this.direc = direc;
}
private String cliente, direc;
//tecnicamente esto seria la clase, en los metodos trata de darle valor a los platos que aparecen en el gui.
}
