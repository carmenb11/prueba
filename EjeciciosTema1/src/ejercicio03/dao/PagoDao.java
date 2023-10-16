package ejercicio03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio03.modelo.Pago;

public class PagoDao {
	public List<Pago> consultarPago(Connection conn, Integer id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pago> listaPago = new ArrayList<>();
			String sql = "select sum(amount), payment_date from payment where customer_id = " + id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pago pago = new Pago();
				pago.setImporte(rs.getBigDecimal("amount"));
				pago.setFecha(rs.getDate("payment_date").toLocalDate());
				
				listaPago.add(pago);
				
			}
			return listaPago;
			
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}
}
