package ejercicio01.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio01.modelo.Pelicula;

public class PeliculasDao {
	public List<Pelicula> consultarPeliculas(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pelicula> actores = new ArrayList<Pelicula>();
			String sql = "select * from film";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula a = new Pelicula();
				a.setId(rs.getInt("film_id"));
				a.setTitulo(rs.getString("title"));
				a.setLongitud(rs.getInt("length"));
				actores.add(a);
			}
			return actores;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
