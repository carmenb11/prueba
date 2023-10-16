package ejercicio03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio02.service.Conexion;
import ejercicio03.dao.ClienteDao;
import ejercicio03.dao.PagoDao;
import ejercicio03.modelo.Cliente;
import ejercicio03.modelo.Pago;

public class PagoService {
	private Conexion openConn;

	public PagoService() {
		openConn = new Conexion();
	}

	public Map<String, List<Pago>> consultarPagos() throws PagosException {
		Connection conn = null;

		try {
			conn = openConn.abrirConexion();
			ClienteDao cliente = new ClienteDao();
			PagoDao pago = new PagoDao();
			List<Cliente> listaClientes = new ArrayList<>();
			listaClientes = cliente.consultarClientes(conn);
			Map<String, List<Pago>> listaFinal = new HashMap<>();

			for (int i = 0; i < listaClientes.size(); i++) {
				listaFinal.put(listaClientes.get(i).getEmail(), pago.consultarPago(conn, listaClientes.get(i).getId()));

			}

			return listaFinal;
		} catch (SQLException e) {
			System.err.println("Error al obtener pagos de clientes en la BBDD ");
			throw new PagosException("Error al consultar en la BBDD", e);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
