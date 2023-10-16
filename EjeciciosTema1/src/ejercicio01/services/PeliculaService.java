package ejercicio01.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ejercicio01.dao.PeliculasDao;
import ejercicio01.modelo.Pelicula;

public class PeliculaService {
	private Conexion openConn;

	public PeliculaService() {
		openConn = new Conexion();
	}

	public List<Pelicula> consultarPeliculas() throws PeliculaServiceException {
		Connection conn = null;
		List<Pelicula> peliculas = new ArrayList<>();
		try {
			conn = openConn.abrirConexion();
			PeliculasDao dao = new PeliculasDao();
			peliculas = dao.consultarPeliculas(conn);

			Iterator<Pelicula> iterator = peliculas.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getLongitud() > 100) {
					iterator.remove();
				}
			}

			return peliculas;

		} catch (SQLException e) {
			System.out.println("Error al consultar peliculas");
			throw new PeliculaServiceException("Error al consultar en la BBDD", e);

		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
