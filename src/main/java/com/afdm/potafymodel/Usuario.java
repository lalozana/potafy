package com.afdm.potafymodel;

import java.time.LocalDate;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String clave;
	private LocalDate fechaNacimiento;
	private String email;
	private boolean deBaja;
	
	
	public Usuario(int idUsuario, String nombre, String apellidos, String nombreUsuario, String clave,
			LocalDate fechaNacimiento, String email, boolean deBaja) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.deBaja = deBaja;
	}
	
	
	// constructor sin idUsuario ni DeBaja
	public Usuario(String nombre, String apellidos, String nombreUsuario, String clave,
			LocalDate fechaNacimiento, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDeBaja() {
		return deBaja;
	}
	public void setDeBaja(boolean deBaja) {
		this.deBaja = deBaja;
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(IdUsuario);
	}*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario: ").append(this.idUsuario).append("\nNombre:").append(this.nombre).append("\nApellidos: ").append(this.apellidos).append("\n").append("\nNombre Usuario: ").append(this.nombreUsuario).append("\nFecha de nacimiento: ").append(this.fechaNacimiento).append("\nCuenta inactiva: ").append(this.deBaja);
		return builder.toString();	
		}
	
	
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		if (obj!= null && obj instanceof Usuario) {
		Usuario otro = (Usuario) obj;
		iguales = this.idUsuario == otro.idUsuario;
		}
		return iguales;
	}
	
	
	
	
}
