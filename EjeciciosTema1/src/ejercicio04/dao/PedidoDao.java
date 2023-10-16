package ejercicio04.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio04.modelo.Pedido;

public class PedidoDao {
	public void insertarPedido(Connection conn, Pedido pedido) throws SQLException {

		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement("INSERT INTO pedidos VALUES (?, ?, ?, ?) ");
			stmt.setLong(1, pedido.getIdPedido());
			stmt.setDate(2, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(3, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(4, pedido.getCliente());

			stmt.execute();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
	
}
