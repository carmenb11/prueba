package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Usuario;

public class UsuarioDao {
	public Usuario consultarUsuario(Connection conn, String email) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Usuario user = new Usuario();
		try {
			String sql = "select * from usuarios where '" + email + "' = email";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {

				user.setIdUsuario(rs.getLong("id_usuario"));
				user.setEmail(rs.getString("email"));
				user.setContraseña(rs.getString("password"));
				user.setNombre(rs.getString("nombre"));
				user.setApellidos(rs.getString("apellidos"));
				user.setCiclo(rs.getString("ciclo"));
				user.setActivo(rs.getBoolean("active"));
				;
				return user;
			}else {
				return null;
			}
			
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

	public void insertarUsuario(Connection conn, Usuario usuario) throws SQLException {

		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?, ?,?,?,?) ");
			stmt.setLong(1, usuario.getIdUsuario());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getContraseña());
			stmt.setString(4, usuario.getNombre());
			stmt.setString(5, usuario.getApellidos());
			stmt.setString(6, usuario.getCiclo());
			stmt.setBoolean(7, usuario.getActivo());

			stmt.execute();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
