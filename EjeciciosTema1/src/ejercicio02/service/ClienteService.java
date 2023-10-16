package ejercicio02.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio02.dao.ClienteDao;
import ejercicio02.modelo.Cliente;

public class ClienteService {
	private Conexion openConn;

	public ClienteService() {
		openConn = new Conexion();
	}

	public Map<String, Cliente> consultarClientes() throws ClienteServiceException {
		Connection conn = null;
		List<Cliente> listClientes = new ArrayList<>();
		Map<String, Cliente> mapClientes = new HashMap<>();

		try {
			conn = openConn.abrirConexion();
			ClienteDao dao = new ClienteDao();
			listClientes = dao.consultarClientes(conn);

			for (Cliente cliente : listClientes) {
				mapClientes.put(cliente.getEmail(), cliente);
			}

			return mapClientes;

		} catch (SQLException e) {
			System.out.println("Error al consultar cliente");
			throw new ClienteServiceException("Error al consultar en la BBDD", e);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
