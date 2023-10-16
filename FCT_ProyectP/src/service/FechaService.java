package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.FechaDao;
import db.Conexion;
import modelo.Fecha;

public class FechaService {
	private Integer anho;
	private Integer evaluacion;
	private Conexion openConn;

	public FechaService() {
		openConn = new Conexion();
	}

	/**
	 * Este metodo te duevuelve todas las fechas de la base de datos.
	 * 
	 * @return Una list con todas las fechas.
	 * @throws EvaluacionException   (Excepcion que lanza)
	 * @throws FechaServiceException (Excepcion que lanza)
	 */
	public List<Fecha> fechaCompleta() throws EvaluacionException, FechaServiceException {
		Connection conn = null;

		try {
			conn = openConn.abrirConexion();
			List<Fecha> fechas = new ArrayList<>();
			FechaDao date = new FechaDao();
			anho = LocalDate.now().getYear();
			if (LocalDate.now().getMonthValue() >= 9 || LocalDate.now().getMonthValue() <= 11) {
				evaluacion = 1;
			} else if (LocalDate.now().getMonthValue() >= 12 || LocalDate.now().getMonthValue() <= 3) {
				evaluacion = 2;
			} else if (LocalDate.now().getMonthValue() >= 4 || LocalDate.now().getMonthValue() <= 6) {
				evaluacion = 3;
			} else {
				throw new EvaluacionException();
			}
			fechas = date.consultarFecha(conn, anho, evaluacion);
			return fechas;

		} catch (SQLException e) {
			System.out.println("Error en la base de datos " + e.getMessage());
			e.printStackTrace();
			throw new FechaServiceException();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {

			}
		}

	}
}
