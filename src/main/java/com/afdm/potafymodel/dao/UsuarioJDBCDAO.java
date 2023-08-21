package com.afdm.potafymodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.afdm.potafymodel.Usuario;

public class UsuarioJDBCDAO {
	
	private final static String BUSCAR_POR_NOMBRE_USUARIO = "select * from Usuario where NombreUsuario = ? and DeBaja = false";

	public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) throws SQLException {
		Usuario usuario = null;
		//1º Obtener la conexión 
		Connection conexion = DaoUtility.getConnection();
		// 2º Obtener la sentencia 
		PreparedStatement sentencia = conexion.prepareStatement(BUSCAR_POR_NOMBRE_USUARIO);
		// 2ª A - Darle valor a los parámetros
		sentencia.setString(1, nombreUsuario);
		// 3º Ejecutar la sentencia
		ResultSet resultado = sentencia.executeQuery();
		// 4º Procesar el resultado
		if (resultado.next()) {
			int idUsuario = resultado.getInt("IdUsuario");
			String nombre = resultado.getString("Nombre");
			String apellidos = resultado.getString("Apellidos");
			String clave = resultado.getString("Clave");
			LocalDate fechaNacimiento = null;
				if (resultado.getDate("FechaNacimiento") != null) {
					fechaNacimiento= resultado.getDate("FechaNacimiento").toLocalDate();
			}
			String email = resultado.getString("Email");
			boolean DeBaja = resultado.getBoolean("DeBaja");
			usuario = new Usuario(idUsuario, nombre, apellidos, nombreUsuario, clave, fechaNacimiento, email, DeBaja);
		}
		conexion.close();
		return usuario;
	}
}
