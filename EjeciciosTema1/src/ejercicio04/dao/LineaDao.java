package ejercicio04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio04.modelo.LineaPedido;

public class LineaDao {
	
	public void insertarLineaPedido(Connection conn, LineaPedido pedido) throws SQLException {

		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement("INSERT INTO pedidos_lineas VALUES (?, ?, ?, ?) ");
			stmt.setLong(1, pedido.getIdPedido());
			stmt.setInt(2, pedido.getNumeroLinea());
			stmt.setString(3, pedido.getArticulo());
			stmt.setBigDecimal(4, pedido.getPrecio());

			stmt.execute();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
