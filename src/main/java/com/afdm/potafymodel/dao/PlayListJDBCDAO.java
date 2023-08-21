package com.afdm.potafymodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.afdm.potafymodel.PlayList;
import com.afdm.potafymodel.Usuario;

public class PlayListJDBCDAO {

	private final static String INSERTAR_PLAYLIST = "insert into Playlist (NombrePlayList, IdUsuario) values (?, ?)";
	
	public PlayList insertarPlayList(String nombre, Usuario usuario) throws SQLException {
	PlayList playlist = null;
	Connection conexion = DaoUtility.getConnection();
	
	// Preparo la sentencia en la que se pone una constante del tipo Statement para recuperar la clave autogenere de IdPlayList de SQL
	PreparedStatement sentencia = conexion.prepareStatement(INSERTAR_PLAYLIST, Statement.RETURN_GENERATED_KEYS);
	sentencia.setString(1, nombre);
	sentencia.setInt(2, usuario.getIdUsuario());
	sentencia.executeUpdate();
	ResultSet claves = sentencia.getGeneratedKeys();
	if (claves.next()) {
		int idPlayList = claves.getInt(1);
		playlist = new PlayList(idPlayList, nombre, usuario, null);
	}
	
	conexion.close();
	return playlist;
	}
}
