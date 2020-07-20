package com.angelica.modelos;

public class Autor {
	protected Integer idAutor;
	protected String nombre;
	
	public Autor(Integer idAutor, String nombre) {
		this.idAutor = idAutor;
		this.nombre = nombre;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Id: " + idAutor + "\tNombre: " + nombre;
	}
}
