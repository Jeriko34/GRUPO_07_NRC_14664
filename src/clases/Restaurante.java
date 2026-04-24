package clases;

public class Restaurante {
private int pedido;
private double plato, total;
private String cliente, direc;
public Restaurante(int pedido, double plato, String cliente, String direc) {
	this.pedido = pedido;
	this.plato = plato;
	this.cliente = cliente;
	this.direc = direc;
}
public double getPedido() {
	return pedido;
}
public void setPedido(int pedido) {
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
public double getTotal() {
    return total;
}
public void setTotal(double total) {
    this.total = total;
}
}
