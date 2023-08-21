package com.afdm.potafymodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.afdm.potafymodel.Cancion;

public class CancionJDBCDAO {

	private final static String INSERTAR_CANCION = "insert into cancion (titulo, duracion, genero, urlfichero, publica, idalbum, idusuario) values (?,?,?,?,?,?,?)";
	
	private final static String BUSCAR_POR_TITULO = "select * from cancion where (IdUsuario = ? or Publica = true) and Titulo like ?"; 
	
	private final static String BORRAR_CANCION = "delete from Cancion where IdCancion = ? and IdUsuario = ?";
	
	public void insertarCancion(Cancion cancion) throws SQLException {
		//1º Obtener la conexión
		Connection conexion = DaoUtility.getConnection();
		// 2º 
		PreparedStatement sentencia = conexion.prepareStatement(INSERTAR_CANCION);
		sentencia.setString(1, cancion.getTitulo());
		if (cancion.getDuracion() == null) {
			sentencia.setNull(2, Types.TIME);
		} else {
			sentencia.setTime(2, Time.valueOf(cancion.getDuracion()));
		}
		sentencia.setString(3, cancion.getGenero());
		sentencia.setString(4, cancion.getURLFichero());
		sentencia.setBoolean(5, cancion.isPublica());
		if (cancion.getAlbum() == null) {
			sentencia.setNull(6, Types.INTEGER);
		} else {
			sentencia.setInt(6, cancion.getAlbum().getIdAlbum());
		}
		sentencia.setInt(7, cancion.getUsuario().getIdUsuario());
		
		int numFilas = sentencia.executeUpdate();
		
		conexion.close();
		
	}
	
	/*busqueda = name escrito en el fichero JSP*/
	
	public List<Cancion> buscarCancionesPorTitulo(String busqueda, int IdUsuario) throws SQLException {
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		
		Connection conexion = DaoUtility.getConnection();
		
		PreparedStatement sentencia = conexion.prepareStatement(BUSCAR_POR_TITULO);
		sentencia.setInt(1, IdUsuario);
		sentencia.setString(2, "%" + busqueda + "%");
		System.out.println(sentencia);
		// ResultSet se pone cuando queremos hacer un select en sql
		ResultSet resultado = sentencia.executeQuery();
		while (resultado.next()) {
			int IdCancion = resultado.getInt("IdCancion");
			String Titulo = resultado.getString("Titulo");
			LocalTime Duracion = null;
			if(resultado.getTime("Duracion") != null) {
				Duracion = resultado.getTime("Duracion").toLocalTime();
			}
			String Genero = resultado.getString("Genero");
			String URLFichero = resultado.getString("URLFichero");
			boolean publica = resultado.getBoolean("Publica");
			// QUEDA SACAR ALBUM
			Cancion cancion = new Cancion(IdCancion, Titulo, Duracion, Genero, URLFichero, publica, null, null);
			
			listaCanciones.add(cancion);
		}
		conexion.close();
		return listaCanciones;
	}
	
	
	
	public boolean borrarCancion(int idCancion, int idUsuario) throws SQLException {
		
		Connection conexion = DaoUtility.getConnection();
		
		PreparedStatement sentencia = conexion.prepareStatement(BORRAR_CANCION);
		sentencia.setInt(1, idCancion);
		sentencia.setInt(2, idUsuario);
		int numFilas = sentencia.executeUpdate();
		conexion.close();
		return numFilas == 1;
	}
	
	
	
		
}
