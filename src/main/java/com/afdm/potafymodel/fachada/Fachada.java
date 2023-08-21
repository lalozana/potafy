package com.afdm.potafymodel.fachada;

import java.sql.SQLException;
import java.util.List;

import com.afdm.potafymodel.Cancion;
import com.afdm.potafymodel.PlayList;
import com.afdm.potafymodel.Usuario;
import com.afdm.potafymodel.dao.CancionJDBCDAO;
import com.afdm.potafymodel.dao.PlayListJDBCDAO;
import com.afdm.potafymodel.dao.UsuarioJDBCDAO;
import com.afdm.potafymodel.exception.ConexionException;
import com.afdm.potafymodel.exception.PlayListRepetidaException;

public class Fachada {

	public Usuario iniciarSesion(String nombreUsuario, String clave) throws ConexionException {
		UsuarioJDBCDAO dao = new UsuarioJDBCDAO();
		Usuario usuario;
		try {
			usuario = dao.buscarUsuarioPorNombreUsuario(nombreUsuario);
			if (usuario != null && usuario.getClave().equals(clave)) {
				return usuario;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("No hay conexión con los datos");
		}
		
	}
	
	public void subirCancion(Cancion cancion) throws ConexionException {
		CancionJDBCDAO dao = new CancionJDBCDAO();
		try {
			dao.insertarCancion(cancion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("No hay conexión con los datos");
		}
	}
	
	public List<Cancion> buscarCancionesPorTitulo(String busqueda, int IdUsuario) throws ConexionException {
		CancionJDBCDAO dao = new CancionJDBCDAO();
		try {
			return dao.buscarCancionesPorTitulo(busqueda, IdUsuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("No hay conexión con los datos");
		}
	}
	
	// poner el mismo tipo de método que en JDBCDAO "boolean"
	public boolean borrarCancion(int idCancion, int idUsuario) throws ConexionException {
		CancionJDBCDAO dao = new CancionJDBCDAO();
		try {
			return dao.borrarCancion(idCancion, idUsuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConexionException("No hay conexión con los datos");
		}
	}
	
	
	public PlayList  crearPlayList(String nombre, Usuario usuario) throws ConexionException, PlayListRepetidaException {
		PlayListJDBCDAO dao = new PlayListJDBCDAO();
		try {
			return dao.insertarPlayList(nombre, usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if( e.getErrorCode() == 1062) {
				throw new PlayListRepetidaException("La PlayList "+ nombre + " ya existe. Puedes crear una nueva con otro nombre");
			} else {
			throw new ConexionException("No hay conexión con los datos");
			}
		}
	}
	
}
