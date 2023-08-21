package com.afdm.potafymodel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Album {

	private int IdAlbum;
	private String NombreAlbum;
	private String Portada;
	private String Interprete;
	private LocalDate FechaPublicacion;
	private List<Cancion> canciones;
	
	public Album(int idAlbum, String nombreAlbum, String portada, String interprete, LocalDate fechaPublicacion,List<Cancion> canciones) {
	
		this.IdAlbum = idAlbum;
		this.NombreAlbum = nombreAlbum;
		this.Portada = portada;
		this.Interprete = interprete;
		this.FechaPublicacion = fechaPublicacion;
		this.canciones = new ArrayList<>();
		
	}

	public int getIdAlbum() {
		return IdAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		IdAlbum = idAlbum;
	}

	public String getNombreAlbum() {
		return NombreAlbum;
	}

	public void setNombreAlbum(String nombreAlbum) {
		NombreAlbum = nombreAlbum;
	}

	public String getPortada() {
		return Portada;
	}

	public void setPortada(String portada) {
		Portada = portada;
	}

	public String getInterprete() {
		return Interprete;
	}

	public void setInterprete(String interprete) {
		Interprete = interprete;
	}

	public LocalDate getFechaPublicacion() {
		return FechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}
	
	
	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Album: ").append(this.IdAlbum).append("\nNombre del álbum:").append(this.NombreAlbum).append("\nPortada: ").append(this.Portada).append("\nIntérprete: ").append(this.Interprete).append("\nFecha de publicación: ").append(this.FechaPublicacion).append("\nLista de temas: ").append(this.canciones);
		return builder.toString();	
		}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj!= null && obj instanceof Album) {
		Album otro = (Album) obj;
		iguales = this.IdAlbum == otro.IdAlbum;
		}
		return iguales;
	}
	
}
