package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Fecha;

public class FechaDao {
	/**
	 * Este metodo consulta la fecha segun el año y la evaluacion y devuelve una
	 * lista.
	 * 
	 * @param conn       (Parametro de entrada)
	 * @param año        (Parametro de entrada)
	 * @param evaluacion (Parametro de entrada)
	 * @return Devuelve una lista con las fechas que ha sacado de la consulta.
	 * @throws SQLException (Excepcion que lanza)
	 */
	public List<Fecha> consultarFecha(Connection conn, Integer año, Integer evaluacion) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Fecha> fechas = new ArrayList<>();
			String sql = "select * from fechas where " + año + " = año and " + evaluacion + " = evaluacion";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Fecha date = new Fecha();

				date.setFecha(rs.getDate("fecha").toLocalDate());
				date.setAño(rs.getInt("año"));
				date.setEvaluación(rs.getInt("evaluacion"));
				date.setDisponibilidad(rs.getBoolean("disponibilidad"));
				fechas.add(date);
			}
			return fechas;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
