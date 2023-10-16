package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Registro;

public class RegistroDao {
	/**
	 * Este metodo consulta un registro segun su id de usuario y la fecha pasados
	 * por parametro para devolver un regitro.
	 * 
	 * @param conn  (Parametro de entrada)
	 * @param user  (Parametro de entrada)
	 * @param fecha (Parametro de entrada)
	 * @return Devuelve un ragistro.
	 * @throws SQLException (Excepcion que lanza)
	 */
	public Registro consultarRegistro(Connection conn, Long user, LocalDate fecha) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Registro register = new Registro();
		try {
			String sql = "select * from registros where id_usuario =?  and fecha = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, user);
			stmt.setDate(2, Date.valueOf(fecha));

			rs = stmt.executeQuery();
			if (rs.next()) {

				register.setIdRegistro((long) rs.getInt("id_registro"));
				register.setIdUsuario((long) rs.getInt("id_usuario"));
				register.setFecha(rs.getDate("fecha").toLocalDate());
				register.setNumHoras(rs.getBigDecimal("num_horas"));
				register.setDescripcion(rs.getString("descripcion"));
				return register;
			} else {
				return null;
			}

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

	/**
	 * Este metodo consulta un registro segun un id de usuario y devulve una lista
	 * de los registros recogidos.
	 * 
	 * @param conn (Parametro de entrada)
	 * @param id   (Parametro de entrada)
	 * @return Devuelve una lista de registros.
	 * @throws SQLException (Excepcion que lanza)
	 */

	public List<Registro> listConsultarRegistro(Connection conn, Long id) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Registro> registros = new ArrayList<>();
			String sql = "select * from registros where " + id + " = id_usuario";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Registro register = new Registro();

				register.setIdRegistro((long) rs.getInt("id_registro"));
				register.setIdUsuario((long) rs.getInt("id_usuario"));
				register.setFecha(rs.getDate("fecha").toLocalDate());
				register.setNumHoras(rs.getBigDecimal("num_horas"));
				register.setDescripcion(rs.getString("descripcion"));

				registros.add(register);
			}
			return registros;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

	/**
	 * Este metodo inserta un registro segun su id de usuario, su numero de horas y
	 * su descripcion.Decuelve un id de usuario
	 * 
	 * @param conn     (Parametro de entrada)
	 * @param registro (Parametro de entrada)
	 * @return Devuelve un Long como id.
	 * @throws SQLException (Excepcion que lanza)
	 */

	public Long insertarRegistro(Connection conn, Registro registro) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(
					"INSERT INTO registros(id_usuario,fecha,num_horas,descripcion) VALUES (?, ?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, registro.getIdRegistro());
			stmt.setDate(2, Date.valueOf(registro.getFecha()));
			stmt.setBigDecimal(3, registro.getNumHoras());
			stmt.setString(4, registro.getDescripcion());

			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);

			return id;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
