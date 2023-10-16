package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UsuarioDao;
import db.Conexion;
import modelo.Usuario;

public class UsuarioService {
	private Conexion openConn;

	public UsuarioService() {
		openConn = new Conexion();
	}

	/**
	 * Este metodo devulve un usuario segun el email y la contraseña pasadas por
	 * parametro, para saber si esta en la bbdd.
	 * 
	 * @param email      (Parametro de entrada)
	 * @param contraseña (Parametro de entrada)
	 * @return Devuelve un usuario.
	 * @throws AutentificarException   (Excepcion que lanza)
	 * @throws UsuarioServiceException (Excepcion que lanza)
	 */

	public Usuario loginUsuario(String email, String contraseña) throws AutentificarException, UsuarioServiceException {
		Connection conn = null;

		try {
			conn = openConn.abrirConexion();
			UsuarioDao usuario = new UsuarioDao();
			Usuario userCorrecto = usuario.consultarUsuario(conn, email);
			if (userCorrecto == null) {
				throw new AutentificarException("El email indicado no existe");
			} else if (!userCorrecto.getContraseña().equals(contraseña)) {
				throw new AutentificarException("La contraseña indicada no es correcta");
			} else {
				return userCorrecto;
			}
		} catch (SQLException e) {
			System.out.println("Error en la base de datos " + e.getMessage());
			e.printStackTrace();
			throw new UsuarioServiceException("La contraseña indicada no es correcta");
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {

			}
		}
	}

	/**
	 * Este metodo comprueba si el email del usuario existe o no, si no existe lo
	 * inserta en la bbdd
	 * 
	 * @param user (Parametro de entrada)
	 * @throws UsuarioServiceException (Excepcion que lanza)
	 */

	public void altausuario(Usuario user) throws UsuarioServiceException {
		Connection conn = null;
		try {
			conn = openConn.abrirConexion();
			UsuarioDao usuario = new UsuarioDao();
			Usuario userCorrecto = usuario.consultarUsuario(conn, user.getEmail());
			if (userCorrecto != null) {
				throw new UsuarioServiceException("EL email indicado exixtse");
			} else {
				System.out.println("Usuario aceptado");
				usuario.insertarUsuario(conn, user);
			}
		} catch (SQLException e) {
			System.out.println("Error en la base de datos " + e.getMessage());
			e.printStackTrace();
			throw new UsuarioServiceException("La contraseña indicada no es correcta");
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {

			}
		}
	}
}
