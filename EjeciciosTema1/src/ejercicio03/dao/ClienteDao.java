package ejercicio03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio03.modelo.Cliente;


public class ClienteDao {
	public List<Cliente> consultarClientes(Connection conn ) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Cliente> cientes = new ArrayList<Cliente>();
			String sql = "select * from customer";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Cliente a = new Cliente();
				a.setId(rs.getInt("customer_id"));
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				a.setEmail(rs.getString("email"));
				a.setActivo(rs.getBoolean("active"));;
				cientes.add(a);
			}
			return cientes;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
