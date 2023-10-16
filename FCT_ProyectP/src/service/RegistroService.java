package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.RegistroDao;
import db.Conexion;
import modelo.Registro;

public class RegistroService {
	private Conexion openConn;

	public RegistroService() {
		openConn = new Conexion();
	}

	/**
	 * Este metodo consulta un registro segun el id que le pasamos por parametro.
	 * 
	 * @param id (Parametro de entrada)
	 * @return Devulve una lista con los registros.
	 * @throws RegistroServiceException (Excepcion que lanza)
	 */
	public List<Registro> consultRegistros(Long id) throws RegistroServiceException {
		Connection conn = null;
		RegistroDao regist = new RegistroDao();
		try {
			conn = openConn.abrirConexion();

			return regist.listConsultarRegistro(conn, id);

		} catch (SQLException e) {
			System.out.println("Error en la base de datos " + e.getMessage());
			e.printStackTrace();
			throw new RegistroServiceException();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {

			}
		}

	}

	/**
	 * Este metodo inserta un registro segun el registro pasado por parametro.
	 * 
	 * @param registro (Parametro de entrada)
	 * @throws UsuarioServiceException  (Excepcion que lanza)
	 * @throws RegistroServiceException (Excepcion que lanza)
	 */
	public void insertRegistro(Registro registro) throws UsuarioServiceException, RegistroServiceException {
		Connection conn = null;
		RegistroDao regist = new RegistroDao();
		try {
			conn = openConn.abrirConexion();
			if (regist.consultarRegistro(conn, registro.getIdUsuario(), registro.getFecha()) == null) {
				regist.insertarRegistro(conn, registro);
				System.out.println("Se ha insertado correctamente");
			} else {
				throw new UsuarioServiceException("El registro ya existe");

			}
		} catch (SQLException e) {
			System.out.println("Error en la base de datos " + e);
			e.printStackTrace();
			throw new RegistroServiceException();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {

			}
		}
	}
}
