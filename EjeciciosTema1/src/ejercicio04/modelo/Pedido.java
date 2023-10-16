package ejercicio04.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private Long idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String Cliente;
	private List<LineaPedido> listaLienaPedido;
	
	public Pedido() {
		listaLienaPedido = new ArrayList<>();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public List<LineaPedido> getListaLienaPedido() {
		return listaLienaPedido;
	}

	public void setListaLienaPedido(List<LineaPedido> listaLienaPedido) {
		this.listaLienaPedido = listaLienaPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega
				+ ", Cliente=" + Cliente + ", listaLienaPedido=" + listaLienaPedido + "]";
	}
	
}
