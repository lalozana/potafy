package com.afdm.potafymodel;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
	 
	private int IdPlayList;
	private String NombrePlayList;
	private Usuario IdUsuario;
	private List<Cancion> canciones;
	
public PlayList(int idPlayList, String nombrePlayList, Usuario idUsuario, List<Cancion> canciones) {
		
		this.IdPlayList = idPlayList;
		this.NombrePlayList = nombrePlayList;
		this.IdUsuario = idUsuario;
		this.canciones = canciones;
	}
	
	public PlayList( String nombrePlayList, Usuario idUsuario, List<Cancion> canciones) {
		
		this.NombrePlayList = nombrePlayList;
		this.IdUsuario = idUsuario;
		this.canciones = new ArrayList<>();
	}
	
	
	public int getIdPlayList() {
		return IdPlayList;
	}
	public void setIdPlayList(int idPlayList) {
		IdPlayList = idPlayList;
	}
	public String getNombrePlayList() {
		return NombrePlayList;
	}
	public void setNombrePlayList(String nombrePlayList) {
		NombrePlayList = nombrePlayList;
	}
	public Usuario getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		IdUsuario = idUsuario;
	}
	
	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayList: ").append(this.IdPlayList).append("\nNombre de la PlayList:").append(this.NombrePlayList).append("\nUsuario: ").append(this.IdUsuario).append("\nLista de Canciones: ").append(this.canciones);
		return builder.toString();	
		}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj!= null && obj instanceof PlayList) {
		PlayList otro = (PlayList) obj;
		iguales = this.IdPlayList == otro.IdPlayList;
		}
		return iguales;
	}

	
	
	public void insertarCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}
	
	public void quitarCancion(Cancion cancion) {
		this.canciones.remove(cancion);
	}
	
}
