package ejercicio04.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;
import ejercicio04.service.PedidoService;

public class App {
	public static void main(String[] args)  {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(001L);
		pedido.setCliente("Carlos");
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.now());
		pedido.setListaLienaPedido(null);

		LineaPedido articulo1 = new LineaPedido();
		
		articulo1.setArticulo("Gafas");
		articulo1.setIdPedido(001L);
		articulo1.setNumeroLinea(1);
		articulo1.setPrecio(new BigDecimal("12.33"));
		
		LineaPedido articulo2 = new LineaPedido();
		articulo2.setArticulo("Calcetines");
		articulo2.setIdPedido(001L);
		articulo2.setNumeroLinea(2);
		articulo2.setPrecio(new BigDecimal("5.33"));
		
		List<LineaPedido> listLineaPedido = new ArrayList<>();
		listLineaPedido.add(articulo1);
		listLineaPedido.add(articulo2);
				
		PedidoService service = new PedidoService();
		pedido.setListaLienaPedido(listLineaPedido);
		service.registrarPedido(pedido);
	}
}
