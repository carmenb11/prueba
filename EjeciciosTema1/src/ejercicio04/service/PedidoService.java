package ejercicio04.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejercicio04.dao.LineaDao;
import ejercicio04.dao.PedidoDao;
import ejercicio04.modelo.LineaPedido;
import ejercicio04.modelo.Pedido;

public class PedidoService {
	private Conexion openConn;

	public PedidoService() {
		openConn = new Conexion();
	}
	public void registrarPedido(Pedido pedido)  {
		Connection conn = null;
		PedidoDao pedidoDao = new PedidoDao();
		LineaDao lineaDao = new LineaDao();
		List<LineaPedido> pedidos = pedido.getListaLienaPedido();
		try {
			conn = openConn.abrirConexion();
			conn.setAutoCommit(false);
			pedidoDao.insertarPedido(conn, pedido);
			
			for (int i = 0; i < pedidos.size(); i++) {
				lineaDao.insertarLineaPedido(conn, pedidos.get(i));
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				if (conn!=null) {
					conn.rollback();
				}
				
			} catch (SQLException e2) {
				System.out.println("Error con el rollback");
			}
			e.printStackTrace();
		}
	}

}
