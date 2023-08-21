package com.afdm.potafymodel;

import java.time.LocalTime;

public class Cancion {
	
	private int IdCancion;
	private String Titulo;
	private LocalTime Duracion;
	private String Genero;
	private String URLFichero;
	private boolean Publica;
	private Album Album;
	private Usuario Usuario;
	
	

	public Cancion(String titulo, LocalTime duracion, String genero, String uRLFichero, boolean publica,
			com.afdm.potafymodel.Album album, com.afdm.potafymodel.Usuario usuario) {
		super();
		Titulo = titulo;
		Duracion = duracion;
		Genero = genero;
		URLFichero = uRLFichero;
		Publica = publica;
		Album = album;
		Usuario = usuario;
	}

	public Cancion(int idCancion, String titulo, LocalTime duracion, String genero, String uRLFichero, boolean publica,
			com.afdm.potafymodel.Album album, com.afdm.potafymodel.Usuario usuario) {
		super();
		IdCancion = idCancion;
		Titulo = titulo;
		Duracion = duracion;
		Genero = genero;
		URLFichero = uRLFichero;
		Publica = publica;
		Album = album;
		Usuario = usuario;
	}

	public Album getAlbum() {
		return Album;
	}

	public void setAlbum(Album album) {
		Album = album;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public int getIdCancion() {
		return IdCancion;
	}

	public void setIdCancion(int idCancion) {
		IdCancion = idCancion;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public LocalTime getDuracion() {
		return Duracion;
	}

	public void setDuracion(LocalTime duracion) {
		Duracion = duracion;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getURLFichero() {
		return URLFichero;
	}

	public void setURLFichero(String uRLFichero) {
		URLFichero = uRLFichero;
	}

	public boolean isPublica() {
		return Publica;
	}

	public void setPublica(boolean publica) {
		Publica = publica;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Canción: ").append(this.IdCancion).append("\nTítulo:").append(this.Titulo).append("\nDuracción: ").append(this.Duracion).append("\nGénero: ").append(this.Genero).append("\nPista sonora: ").append(this.URLFichero).append("\nPública: ").append(this.Publica);
		return builder.toString();	
		}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj!= null && obj instanceof Cancion) {
		Cancion otro = (Cancion) obj;
		iguales = this.IdCancion == otro.IdCancion;
		}
		return iguales;
	}
	
}
